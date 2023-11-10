package org.example;

import net.sourceforge.pmd.PMDConfiguration;
import net.sourceforge.pmd.PmdAnalysis;
import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.RuleViolation;
import net.sourceforge.pmd.lang.LanguageRegistry;
import org.eclipse.jgit.api.Git;
import org.example.dto.PMDRepositoryStats;
import org.example.dto.PMDResult;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PMDAnalyzer {
    public static void main(String[] args) throws Exception {
        Logger pmdLogger = Logger.getLogger("net.sourceforge.pmd");
        pmdLogger.setLevel(Level.SEVERE);

        if (args.length == 0) {
            System.out.println("Usage: PMDAnalyzer <git_repo_directory>");
            return;
        }

        String gitRepoUrl = args[0];
        String destinationDirectory = args.length > 1 ? args[1] : "pmd-analyzer-projects";

        String repoName = getRepositoryName(gitRepoUrl).replace(".git", "");
        File gitRepoDirectory = new File(destinationDirectory, repoName);

        if (!gitRepoDirectory.exists()) {
            // Clone the repository if it's public
            // Step 0: (Clone repository as not exists)
            System.out.println("Step 0: (Clone repository as not exists) Execution Started");
            long step0StartTime = System.nanoTime();
            Git.cloneRepository().setURI(gitRepoUrl).setDirectory(gitRepoDirectory).call();
            System.out.println("Repository cloned from " + gitRepoUrl + " to " + gitRepoDirectory.getAbsolutePath());
            long step0EndTime = System.nanoTime();
            long step0Time = (step0EndTime - step0StartTime) / 1_000_000; // in milliseconds
            System.out.println("Step 0 Execution Completed!");
            System.out.println("Step 0 Execution Time: " + step0Time + " ms");
        }

        createDirectoryIfNotExists(gitRepoDirectory + "/pmd-stats-on-commit");

        Git git = Git.open(gitRepoDirectory);

        // Step 1: (Get the list of commits in the git repository)
        System.out.println("Step 1: (Get the list of commits in the git repository)");
        long step1StartTime = System.nanoTime();
        List<String> commits = getCommits(gitRepoDirectory);
        long step1EndTime = System.nanoTime();
        long step1Time = (step1EndTime - step1StartTime) / 1_000_000; // in milliseconds
        System.out.println("Step 1 Execution Completed!");
        System.out.println("Step 1 Execution Time: " + step1Time + " ms");

        // Step 2: (Collect static analysis results for each commit)
        System.out.println("Step 2: (Collect static analysis results for each commit)");
        long step2StartTime = System.nanoTime();
        PMDResult pmdResult = new PMDResult(gitRepoDirectory.getAbsolutePath());
        PMDRepositoryStats pmdRepositoryStats = new PMDRepositoryStats();
        pmdRepositoryStats.setNumber_of_commits(commits.size());

        Integer totalNumberOfJavaFiles = 0;
        Integer totalNumberOfWarnings = 0;
        for (String commit : commits) {
            System.out.println("Analysis started on commit: " + commit);
            Map<String, Object> results = collectStaticAnalysisResults(gitRepoDirectory.getPath(), commit, null);
            Integer numOfJavaFiles = (Integer) results.get("num_java_files");
            totalNumberOfJavaFiles += numOfJavaFiles;
            if ((Integer) results.get("num_java_files") > 0) {
                totalNumberOfWarnings += (Integer) results.get("num_warnings");
                Map<String, Integer> temp = (Map<String, Integer>) results.get("stat_of_warnings");
                temp.forEach((key, value) ->
                        pmdResult.getStat_of_warnings().merge(key, value, Integer::sum)
                );
            }
        }
        pmdRepositoryStats.setAvg_of_num_java_files(totalNumberOfJavaFiles / (double) commits.size());
        pmdRepositoryStats.setAvg_of_num_warnings(totalNumberOfWarnings / (double) commits.size());

        pmdResult.setStat_of_repository(pmdRepositoryStats);
        long step2EndTime = System.nanoTime();
        long step2Time = (step2EndTime - step2StartTime) / 1_000_000; // in milliseconds
        System.out.println("Step 2 Execution Completed!");
        System.out.println("Step 2 Execution Time: " + step2Time + " ms");
        JSONObject jsonObject = new JSONObject(pmdResult);
        System.out.println("Final JSON Object:");
        System.out.println(jsonObject);
    }

    private static String getRepositoryName(String gitRepoUrl) {
        String[] parts = gitRepoUrl.split("/");
        return parts[parts.length - 1];
    }

    public static void createDirectoryIfNotExists(String directoryPath) {
        Path path = Paths.get(directoryPath);

        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                System.out.println("Directory created: " + path);
            } catch (IOException e) {
                System.err.println("Unable to create directory: " + path);
                e.printStackTrace();
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

    private static List<String> getCommits(File gitRepositoryLocation) throws Exception {
        Process process = Runtime.getRuntime().exec("git rev-list HEAD", new String[0], gitRepositoryLocation);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        List<String> commits = new ArrayList<>();
        String commit;
        while ((commit = reader.readLine()) != null) {
            commits.add(commit);
        }

        reader.close();
        process.waitFor();

        return commits;
    }

    private static List<String> getJavaFiles(String gitRepositoryLocation, String commit) throws Exception {
        // Get the root directory of the Git repository.
        String rootDirectoryPath = gitRepositoryLocation;
        if (!gitRepositoryLocation.endsWith(".git")) {
            rootDirectoryPath = Paths.get(gitRepositoryLocation, ".git").toString();
        }

        // Get the list of Java files that were changed in the commit.
        Process process = Runtime.getRuntime().exec("git diff --name-only " + commit + " HEAD", new String[0], new File(rootDirectoryPath));
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        List<String> javaFiles = new ArrayList<>();
        String javaFile;
        while ((javaFile = reader.readLine()) != null) {
            // Only add Java files to the list.
            if (javaFile.endsWith(".java")) {
                javaFiles.add(Paths.get(gitRepositoryLocation, javaFile).toString());
            }
        }

        reader.close();
        process.waitFor();

        return javaFiles;
    }

    private static Map<String, Object> collectStaticAnalysisResults(String gitRepositoryLocation, String commit, String rulesetFilePath) throws Exception {
        List<String> javaFilesAgainstCommit = getJavaFiles(gitRepositoryLocation, commit);
        Map<String, Object> result = new HashMap<>();
        result.put("num_java_files", javaFilesAgainstCommit.size());
        if (!javaFilesAgainstCommit.isEmpty()) {
            System.out.println("Java files found in commit: " + javaFilesAgainstCommit.size());

            // Create a PMD configuration.
            PMDConfiguration configuration = new PMDConfiguration();
            // configuration.setMinimumPriority(RulePriority.MEDIUM);
            if (rulesetFilePath != null) {
                configuration.addRuleSet(rulesetFilePath);
            } else {
                configuration.addRuleSet("rulesets/java/quickstart.xml");
            }
            // configuration.setInputPaths(gitRepositoryLocation + "/src/main/java");
            for (String javaFile : javaFilesAgainstCommit) {
                Path inputPath = Path.of(javaFile);
                if (Files.exists(inputPath)) {
                    configuration.addInputPath(inputPath);
                }
            }
            configuration.setDefaultLanguageVersion(LanguageRegistry.findLanguageByTerseName("java").getVersion("11"));
            configuration.prependAuxClasspath(gitRepositoryLocation + "/target/classes");
            configuration.setReportFormat("json");
            configuration.setReportFile(Path.of(gitRepositoryLocation + "/pmd-stats-on-commit/" + commit + ".json"));

            PmdAnalysis pmdAnalysis = PmdAnalysis.create(configuration);

            // Collect static analysis results for the Java files in the commit.
            Map<String, Integer> statOfWarnings = new HashMap<>();
            Report report = pmdAnalysis.performAnalysisAndCollectReport();
            for (RuleViolation violation : report.getViolations()) {
                String warningType = violation.getRule().getName();
                int count = statOfWarnings.getOrDefault(warningType, 0);
                statOfWarnings.put(warningType, count + 1);
            }
            result.put("num_warnings", statOfWarnings.values().stream()
                    .mapToInt(Integer::intValue)
                    .sum()
            );
            result.put("stat_of_warnings", statOfWarnings);
            System.out.println("PMD analysis commit file Location: " + gitRepositoryLocation + "/pmd-stats-on-commit/" + commit + ".json");
        } else {
            System.out.println("No Java files found in commit");
        }

        return result;
    }
}