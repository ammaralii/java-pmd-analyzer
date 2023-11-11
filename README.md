# Static Analysis Tool Using PMD

## Introduction

This repository contains a dynamic analysis tool for collecting static analysis results (by PMD) along with a revision
history for a further repository mining. This information is then summarized and output in a JSON file.

## Table of Contents

- [Requirements](#requirements)
- [Usage](#usage)
- [Output](#output)
- [Performance](#performance)
- [Testing](#testing)

## Requirements

**R1** Any programming language can be used.

**R2** Your program should be shared by a GitHub or Bitbucket repository.

**R3**  In your repository, there should be “README.md” explaining how to run your program.

**R4** Using Docker is highly recommended for setting up a running environment but it is
optional.

**R5** Your program should take a git repository location as input; the git repository is a Java
project.

**R6** Your program shall take other optional parameters if necessary.

**R7** Your program shall produce a JSON file as output for each commit; this should be stored
into a designated location by an optional parameter.

**R8** Your program shall produce a file summarizing the results of running PMD along with
the history of the target project; the format should be as follows:

```json
{
  "location": "/a/b/c",
  "stat_of_repository": {
    "number_of_commits": 101,
    "avg_of_num_java_files": 30.2,
    "avg_of_num_warnings": 193.2
  },
  "stat_of_warnings": {
    "AbstractClassWithoutAbstractMethod": 1908,
    "AvoidReassigningCatchVariables": 2020
  }
}
```

**R9** Your program should take a ruleset file path as a parameter.

**R10** Your program should perform, at least, 1.0s/commit. In other words, your program shall finish processing a
repository with 1,000 commits within 1000s.

**R11** You can test your program with
the [https://github.com/apache/commons-lang](https://github.com/apache/commons-lang) repository.

## Usage

### Prerequisites

Before you can run this project, you need to have the following software installed on your system:

- **Docker:** Install [Docker](https://docs.docker.com/engine/install/) using this link if docker not exists in your 
system, if you want to check docker exits or not then run this:
   ```sh
   docker --version
   ```
  if you got output similar to this **"Docker version 20.10.23, build 7155243"** it means docker exists

### Running the Project

To run the project locally, follow these steps:

1. Clone this repository to your local machine using Git:
   ```sh
   git clone https://github.com/ammaralii/java-pmd-analyzer.git
   ```
2. Navigate to the project directory:
    ```sh
   cd java-pmd-analyzer
    ```
3. Build docker image:
    ```sh
   docker build -t pmd-analyzer:latest .
    ```
3. Run the application:
    
    `docker run --name <container_name> <image_name>:latest java -jar /app/pmd-analyzer.jar <REPO_URL>`
    ```sh
   docker run --name pmd-analyzer pmd-analyzer:latest java -jar /app/pmd-analyzer.jar https://github.com/ammaralii/interview-preparation-kit.git
    ```
   
4. If you want to copy JSON files having commit analysis details, run this(It will copy stopped container files to host path):
   
    `mkdir -p <host_path> && docker cp <container_name_or_id>:<source_path> <host_path>`
    ```sh
    mkdir -p $HOME/pmd-analyzer-projects/interview-preparation-kit && docker cp pmd-analyzer:/app/pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit $HOME/pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit
    ```

## Output

The tool will produce a JSON file output similar to this:
```json
{
  "location": "/app/pmd-analyzer-projects/interview-preparation-kit",
  "stat_of_repository": {
    "number_of_commits": 112,
    "avg_of_num_warnings": 185.54,
    "avg_of_num_java_files": 70.73
  },
  "stat_of_warnings": {
    "UseEqualsToCompareStrings": 136,
    "UseUtilityClass": 3753,
    "LooseCoupling": 332,
    "LocalVariableNamingConventions": 676,
    "UnusedPrivateMethod": 213,
    "FormalParameterNamingConventions": 270,
    "UnnecessaryLocalBeforeReturn": 61,
    "UnnecessaryFullyQualifiedName": 62,
    "ForLoopCanBeForeach": 510,
    "CloseResource": 467,
    "SwitchStmtsShouldHaveDefault": 82,
    "DoNotExtendJavaLangThrowable": 78,
    "UselessParentheses": 728,
    "ControlStatementBraces": 1496,
    "MethodNamingConventions": 10330,
    "SimplifyBooleanReturns": 93,
    "AvoidBranchingStatementAsLastInLoop": 62,
    "LiteralsFirstInComparisons": 238,
    "OneDeclarationPerLine": 515,
    "CompareObjectsWithEquals": 136,
    "UseCollectionIsEmpty": 122,
    "UnusedLocalVariable": 34,
    "UncommentedEmptyConstructor": 97,
    "UnnecessaryImport": 289
  }
}
```

## Performance

The tool is designed to meet the performance requirements outlined in Requirement R10. It should be capable of 
processing a repository with 1,000 commits within 1000s.

I tried my best to meet this requirement and processed 1 commit in 200-800 milliseconds. Here is the output where 
I processed **112** commits in **50** seconds approx
```
2023-11-11 12:31:26 Step 0: (Clone repository as not exists) Execution Started
2023-11-11 12:31:38 Repository cloned from https://github.com/ammaralii/interview-preparation-kit.git to /app/pmd-analyzer-projects/interview-preparation-kit
2023-11-11 12:31:38 Step 0 Execution Completed!
2023-11-11 12:31:38 Step 0 Execution Time: 12098 ms
2023-11-11 12:31:38 Directory created: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit
2023-11-11 12:31:38 Step 1: (Get the list of commits in the git repository)
2023-11-11 12:31:38 Step 1 Execution Completed!
2023-11-11 12:31:38 Step 1 Execution Time: 3 ms
2023-11-11 12:31:38 Step 2: (Collect static analysis results for each commit)
2023-11-11 12:31:38 --------------------------------------------------------------------
2023-11-11 12:31:38 Analysis started on commit: 44d870b83d5c0aebaec6759927518b611bd7baa5
2023-11-11 12:31:38 No Java files found in commit
2023-11-11 12:31:38 --------------------------------------------------------------------
2023-11-11 12:31:38 Analysis started on commit: 660e2699d169cf46e8b9d9b5d57c166491456d3e
2023-11-11 12:31:38 No Java files found in commit
2023-11-11 12:31:38 --------------------------------------------------------------------
2023-11-11 12:31:38 Analysis started on commit: 4473141d250c11c3fbaad48139e169180729d3e7
2023-11-11 12:31:38 No Java files found in commit
2023-11-11 12:31:38 --------------------------------------------------------------------
2023-11-11 12:31:38 Analysis started on commit: 5308b08caca7702082286bc31b55c3175573a22e
2023-11-11 12:31:38 No Java files found in commit
2023-11-11 12:31:38 --------------------------------------------------------------------
2023-11-11 12:31:38 Analysis started on commit: f50e00acf42e643b3bdde0e4c968d114922eca3b
2023-11-11 12:31:38 No Java files found in commit
2023-11-11 12:31:38 --------------------------------------------------------------------
2023-11-11 12:31:38 Analysis started on commit: 29a893f1aa5bd09dec077f4784adbf3b761e5bbb
2023-11-11 12:31:38 No Java files found in commit
2023-11-11 12:31:38 --------------------------------------------------------------------
2023-11-11 12:31:38 Analysis started on commit: 16e39e4a44f074da904e2b5958519b5f5e0293f5
2023-11-11 12:31:38 Java files found in commit: 5
2023-11-11 12:31:39 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/16e39e4a44f074da904e2b5958519b5f5e0293f5.json
2023-11-11 12:31:39 --------------------------------------------------------------------
2023-11-11 12:31:39 Analysis started on commit: fa907cf9a6c0ba52bc79575f55e5cabbb5192cba
2023-11-11 12:31:39 Java files found in commit: 5
2023-11-11 12:31:40 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/fa907cf9a6c0ba52bc79575f55e5cabbb5192cba.json
2023-11-11 12:31:40 --------------------------------------------------------------------
2023-11-11 12:31:40 Analysis started on commit: 4ca3cc5bf930c071aec103e645e0e7a330a441e9
2023-11-11 12:31:40 Java files found in commit: 14
2023-11-11 12:31:40 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/4ca3cc5bf930c071aec103e645e0e7a330a441e9.json
2023-11-11 12:31:40 --------------------------------------------------------------------
2023-11-11 12:31:40 Analysis started on commit: 93f08484c2ebbe4a425738071252ad164be49433
2023-11-11 12:31:40 Java files found in commit: 14
2023-11-11 12:31:41 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/93f08484c2ebbe4a425738071252ad164be49433.json
2023-11-11 12:31:41 --------------------------------------------------------------------
2023-11-11 12:31:41 Analysis started on commit: b8a980ca291ae8848438e296199fae295655d482
2023-11-11 12:31:41 Java files found in commit: 14
2023-11-11 12:31:41 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/b8a980ca291ae8848438e296199fae295655d482.json
2023-11-11 12:31:41 --------------------------------------------------------------------
2023-11-11 12:31:41 Analysis started on commit: 14c310e61ff6ffaa3b9cf911a74271cebeaaf837
2023-11-11 12:31:41 Java files found in commit: 14
2023-11-11 12:31:42 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/14c310e61ff6ffaa3b9cf911a74271cebeaaf837.json
2023-11-11 12:31:42 --------------------------------------------------------------------
2023-11-11 12:31:42 Analysis started on commit: d1dc342b4bf909fdb3f0d95410781a025bced7f1
2023-11-11 12:31:42 Java files found in commit: 14
2023-11-11 12:31:42 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d1dc342b4bf909fdb3f0d95410781a025bced7f1.json
2023-11-11 12:31:42 --------------------------------------------------------------------
2023-11-11 12:31:42 Analysis started on commit: c05c9c39f56e45b317082249e884a1dfbfa4c3e8
2023-11-11 12:31:42 Java files found in commit: 14
2023-11-11 12:31:43 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/c05c9c39f56e45b317082249e884a1dfbfa4c3e8.json
2023-11-11 12:31:43 --------------------------------------------------------------------
2023-11-11 12:31:43 Analysis started on commit: 85ebeb3307cd953905b24c2ad8b5966f6cb5dda6
2023-11-11 12:31:43 Java files found in commit: 14
2023-11-11 12:31:43 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/85ebeb3307cd953905b24c2ad8b5966f6cb5dda6.json
2023-11-11 12:31:43 --------------------------------------------------------------------
2023-11-11 12:31:43 Analysis started on commit: 5b5720df1a1a69e246de9788df85ff3e9f7b25b2
2023-11-11 12:31:43 Java files found in commit: 14
2023-11-11 12:31:43 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5b5720df1a1a69e246de9788df85ff3e9f7b25b2.json
2023-11-11 12:31:43 --------------------------------------------------------------------
2023-11-11 12:31:43 Analysis started on commit: becdafe620d14882d79fbebce79bc84dbc78cf24
2023-11-11 12:31:43 Java files found in commit: 16
2023-11-11 12:31:44 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/becdafe620d14882d79fbebce79bc84dbc78cf24.json
2023-11-11 12:31:44 --------------------------------------------------------------------
2023-11-11 12:31:44 Analysis started on commit: 9e9b243157e0a34acf906e76a707892341faa98d
2023-11-11 12:31:44 Java files found in commit: 16
2023-11-11 12:31:44 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9e9b243157e0a34acf906e76a707892341faa98d.json
2023-11-11 12:31:44 --------------------------------------------------------------------
2023-11-11 12:31:44 Analysis started on commit: 6b8f7d4e922fe43ab7c4abc9d20dd420084fe669
2023-11-11 12:31:44 Java files found in commit: 17
2023-11-11 12:31:45 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/6b8f7d4e922fe43ab7c4abc9d20dd420084fe669.json
2023-11-11 12:31:45 --------------------------------------------------------------------
2023-11-11 12:31:45 Analysis started on commit: 9bc8744d52a6e7f8f0f9000104bbcb77e6f38550
2023-11-11 12:31:45 Java files found in commit: 20
2023-11-11 12:31:45 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9bc8744d52a6e7f8f0f9000104bbcb77e6f38550.json
2023-11-11 12:31:45 --------------------------------------------------------------------
2023-11-11 12:31:45 Analysis started on commit: d45fc27cbd5e984022493ea983b5fcc06765463c
2023-11-11 12:31:45 Java files found in commit: 20
2023-11-11 12:31:46 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d45fc27cbd5e984022493ea983b5fcc06765463c.json
2023-11-11 12:31:46 --------------------------------------------------------------------
2023-11-11 12:31:46 Analysis started on commit: efe32e905767fe73dfbba3b656cae65a7d70c7b5
2023-11-11 12:31:46 Java files found in commit: 21
2023-11-11 12:31:46 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/efe32e905767fe73dfbba3b656cae65a7d70c7b5.json
2023-11-11 12:31:46 --------------------------------------------------------------------
2023-11-11 12:31:46 Analysis started on commit: 90b4aff012ebc41dbd743fbee39f65217efedbde
2023-11-11 12:31:46 Java files found in commit: 21
2023-11-11 12:31:47 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/90b4aff012ebc41dbd743fbee39f65217efedbde.json
2023-11-11 12:31:47 --------------------------------------------------------------------
2023-11-11 12:31:47 Analysis started on commit: 908f9254d6af2aba5a770532892b6901560f150a
2023-11-11 12:31:47 Java files found in commit: 21
2023-11-11 12:31:47 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/908f9254d6af2aba5a770532892b6901560f150a.json
2023-11-11 12:31:47 --------------------------------------------------------------------
2023-11-11 12:31:47 Analysis started on commit: 1c823f7e1677decabd96a3a48e174b7fadf84d74
2023-11-11 12:31:47 Java files found in commit: 21
2023-11-11 12:31:48 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1c823f7e1677decabd96a3a48e174b7fadf84d74.json
2023-11-11 12:31:48 --------------------------------------------------------------------
2023-11-11 12:31:48 Analysis started on commit: 61f53046340e7f224888ee14daf8c061392aad4a
2023-11-11 12:31:48 Java files found in commit: 24
2023-11-11 12:31:48 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/61f53046340e7f224888ee14daf8c061392aad4a.json
2023-11-11 12:31:48 --------------------------------------------------------------------
2023-11-11 12:31:48 Analysis started on commit: 359f65f2f862be545bc2ab89eb5ef48eb5d5f711
2023-11-11 12:31:48 Java files found in commit: 24
2023-11-11 12:31:48 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/359f65f2f862be545bc2ab89eb5ef48eb5d5f711.json
2023-11-11 12:31:48 --------------------------------------------------------------------
2023-11-11 12:31:48 Analysis started on commit: 61ba4b4ecb1ba803718954b12d077157ea16c048
2023-11-11 12:31:48 Java files found in commit: 24
2023-11-11 12:31:49 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/61ba4b4ecb1ba803718954b12d077157ea16c048.json
2023-11-11 12:31:49 --------------------------------------------------------------------
2023-11-11 12:31:49 Analysis started on commit: 2fd59f4898d89835b1e97bb320429cbe06bb328b
2023-11-11 12:31:49 Java files found in commit: 24
2023-11-11 12:31:49 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2fd59f4898d89835b1e97bb320429cbe06bb328b.json
2023-11-11 12:31:49 --------------------------------------------------------------------
2023-11-11 12:31:49 Analysis started on commit: 62df651e12b5bfcfd272d36b23303fd135e216c5
2023-11-11 12:31:49 Java files found in commit: 25
2023-11-11 12:31:50 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/62df651e12b5bfcfd272d36b23303fd135e216c5.json
2023-11-11 12:31:50 --------------------------------------------------------------------
2023-11-11 12:31:50 Analysis started on commit: 1e7fe6c9ebb942a1a96ea87d0fcfe879c2fed7e3
2023-11-11 12:31:50 Java files found in commit: 26
2023-11-11 12:31:50 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1e7fe6c9ebb942a1a96ea87d0fcfe879c2fed7e3.json
2023-11-11 12:31:50 --------------------------------------------------------------------
2023-11-11 12:31:50 Analysis started on commit: fc2af949d0660de67aa67404834ff47c8a6b1527
2023-11-11 12:31:50 Java files found in commit: 28
2023-11-11 12:31:51 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/fc2af949d0660de67aa67404834ff47c8a6b1527.json
2023-11-11 12:31:51 --------------------------------------------------------------------
2023-11-11 12:31:51 Analysis started on commit: d4bab9f601d72c4d12423e6397269a077796486f
2023-11-11 12:31:51 Java files found in commit: 28
2023-11-11 12:31:51 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d4bab9f601d72c4d12423e6397269a077796486f.json
2023-11-11 12:31:51 --------------------------------------------------------------------
2023-11-11 12:31:51 Analysis started on commit: 2c1167cb6cb76dcf7ff853e476d2bcb637cb051d
2023-11-11 12:31:51 Java files found in commit: 28
2023-11-11 12:31:51 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2c1167cb6cb76dcf7ff853e476d2bcb637cb051d.json
2023-11-11 12:31:51 --------------------------------------------------------------------
2023-11-11 12:31:51 Analysis started on commit: 877d30eeb942bd2837439c7099b441cebf71a487
2023-11-11 12:31:51 Java files found in commit: 29
2023-11-11 12:31:52 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/877d30eeb942bd2837439c7099b441cebf71a487.json
2023-11-11 12:31:52 --------------------------------------------------------------------
2023-11-11 12:31:52 Analysis started on commit: 3eae137d87bdc93a0cb3a8e2e67652ae5f5df453
2023-11-11 12:31:52 Java files found in commit: 29
2023-11-11 12:31:52 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/3eae137d87bdc93a0cb3a8e2e67652ae5f5df453.json
2023-11-11 12:31:52 --------------------------------------------------------------------
2023-11-11 12:31:52 Analysis started on commit: 2cdb0298cc7b10de3b94b895f254702fbfd00908
2023-11-11 12:31:52 Java files found in commit: 29
2023-11-11 12:31:53 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2cdb0298cc7b10de3b94b895f254702fbfd00908.json
2023-11-11 12:31:53 --------------------------------------------------------------------
2023-11-11 12:31:53 Analysis started on commit: 4d13feea80221fe946c6a09998ed1a98e5ac36f1
2023-11-11 12:31:53 Java files found in commit: 29
2023-11-11 12:31:53 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/4d13feea80221fe946c6a09998ed1a98e5ac36f1.json
2023-11-11 12:31:53 --------------------------------------------------------------------
2023-11-11 12:31:53 Analysis started on commit: f270cdad00b420a473c9f943a734a7b6a5a1a3f7
2023-11-11 12:31:53 Java files found in commit: 29
2023-11-11 12:31:54 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/f270cdad00b420a473c9f943a734a7b6a5a1a3f7.json
2023-11-11 12:31:54 --------------------------------------------------------------------
2023-11-11 12:31:54 Analysis started on commit: 64a0f12585bd70212614cc0ef2f0ce76da09c1cb
2023-11-11 12:31:54 Java files found in commit: 29
2023-11-11 12:31:54 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/64a0f12585bd70212614cc0ef2f0ce76da09c1cb.json
2023-11-11 12:31:54 --------------------------------------------------------------------
2023-11-11 12:31:54 Analysis started on commit: f2ef525fb17f1041eb0b75fef8c334e67ec29fc2
2023-11-11 12:31:54 Java files found in commit: 31
2023-11-11 12:31:55 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/f2ef525fb17f1041eb0b75fef8c334e67ec29fc2.json
2023-11-11 12:31:55 --------------------------------------------------------------------
2023-11-11 12:31:55 Analysis started on commit: 86e3be56de6ec99679342544e2a251dcdbc94336
2023-11-11 12:31:55 Java files found in commit: 31
2023-11-11 12:31:55 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/86e3be56de6ec99679342544e2a251dcdbc94336.json
2023-11-11 12:31:55 --------------------------------------------------------------------
2023-11-11 12:31:55 Analysis started on commit: f3b9339939a889d20ac6d79b1c2d3642d2dea736
2023-11-11 12:31:55 Java files found in commit: 33
2023-11-11 12:31:56 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/f3b9339939a889d20ac6d79b1c2d3642d2dea736.json
2023-11-11 12:31:56 --------------------------------------------------------------------
2023-11-11 12:31:56 Analysis started on commit: 5293fe2d136dc38ca01473330d6f5d2e1f0ea6a0
2023-11-11 12:31:56 Java files found in commit: 33
2023-11-11 12:31:56 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5293fe2d136dc38ca01473330d6f5d2e1f0ea6a0.json
2023-11-11 12:31:56 --------------------------------------------------------------------
2023-11-11 12:31:56 Analysis started on commit: 9622b0d0833dfbbeb7569cc4bcd3e6b5b8dcb82b
2023-11-11 12:31:56 Java files found in commit: 35
2023-11-11 12:31:56 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9622b0d0833dfbbeb7569cc4bcd3e6b5b8dcb82b.json
2023-11-11 12:31:56 --------------------------------------------------------------------
2023-11-11 12:31:56 Analysis started on commit: 7bf3226024e2567e4548defd8cc7ae2dc21d894a
2023-11-11 12:31:56 Java files found in commit: 37
2023-11-11 12:31:57 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/7bf3226024e2567e4548defd8cc7ae2dc21d894a.json
2023-11-11 12:31:57 --------------------------------------------------------------------
2023-11-11 12:31:57 Analysis started on commit: e856d0d661c4284167d4a89d3160b4f2eb6b75ca
2023-11-11 12:31:57 Java files found in commit: 39
2023-11-11 12:31:57 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e856d0d661c4284167d4a89d3160b4f2eb6b75ca.json
2023-11-11 12:31:57 --------------------------------------------------------------------
2023-11-11 12:31:57 Analysis started on commit: cd47b3862afe75759e50544d8bb438635f863c95
2023-11-11 12:31:57 Java files found in commit: 39
2023-11-11 12:31:58 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/cd47b3862afe75759e50544d8bb438635f863c95.json
2023-11-11 12:31:58 --------------------------------------------------------------------
2023-11-11 12:31:58 Analysis started on commit: 2b8d373ba6a017dc3d1e7f65afce82fbaa5b9f5b
2023-11-11 12:31:58 Java files found in commit: 39
2023-11-11 12:31:58 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2b8d373ba6a017dc3d1e7f65afce82fbaa5b9f5b.json
2023-11-11 12:31:58 --------------------------------------------------------------------
2023-11-11 12:31:58 Analysis started on commit: 9d7fd41de4825afc25f9f7e5637ed3304ab032a4
2023-11-11 12:31:58 Java files found in commit: 39
2023-11-11 12:31:59 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9d7fd41de4825afc25f9f7e5637ed3304ab032a4.json
2023-11-11 12:31:59 --------------------------------------------------------------------
2023-11-11 12:31:59 Analysis started on commit: e8780714100da4dac82b26dbafbffd649c06a5b7
2023-11-11 12:31:59 Java files found in commit: 43
2023-11-11 12:31:59 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e8780714100da4dac82b26dbafbffd649c06a5b7.json
2023-11-11 12:31:59 --------------------------------------------------------------------
2023-11-11 12:31:59 Analysis started on commit: ad3af745075d51f6f7dd82e798b2b372c801e16d
2023-11-11 12:31:59 Java files found in commit: 55
2023-11-11 12:32:00 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/ad3af745075d51f6f7dd82e798b2b372c801e16d.json
2023-11-11 12:32:00 --------------------------------------------------------------------
2023-11-11 12:32:00 Analysis started on commit: d5e1a8b06ee4bf941722333a26795e7695f9e6cc
2023-11-11 12:32:00 Java files found in commit: 55
2023-11-11 12:32:00 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d5e1a8b06ee4bf941722333a26795e7695f9e6cc.json
2023-11-11 12:32:00 --------------------------------------------------------------------
2023-11-11 12:32:00 Analysis started on commit: 10ee11621c5e6810351085cd6356efbacdf58a7b
2023-11-11 12:32:00 Java files found in commit: 56
2023-11-11 12:32:00 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/10ee11621c5e6810351085cd6356efbacdf58a7b.json
2023-11-11 12:32:00 --------------------------------------------------------------------
2023-11-11 12:32:00 Analysis started on commit: 099ac491ccb2f183587b4fdf41446ffecceba292
2023-11-11 12:32:01 Java files found in commit: 56
2023-11-11 12:32:01 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/099ac491ccb2f183587b4fdf41446ffecceba292.json
2023-11-11 12:32:01 --------------------------------------------------------------------
2023-11-11 12:32:01 Analysis started on commit: 93e4586a82cfd948fcb065ed3ea84119e8eba27b
2023-11-11 12:32:01 Java files found in commit: 56
2023-11-11 12:32:01 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/93e4586a82cfd948fcb065ed3ea84119e8eba27b.json
2023-11-11 12:32:01 --------------------------------------------------------------------
2023-11-11 12:32:01 Analysis started on commit: 5b2551a837fd65bbee0925c15220651c5d7239a8
2023-11-11 12:32:01 Java files found in commit: 56
2023-11-11 12:32:02 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5b2551a837fd65bbee0925c15220651c5d7239a8.json
2023-11-11 12:32:02 --------------------------------------------------------------------
2023-11-11 12:32:02 Analysis started on commit: 92cf291d0edcb52f3fa187a4cc59c5f848aa2c7a
2023-11-11 12:32:02 Java files found in commit: 55
2023-11-11 12:32:02 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/92cf291d0edcb52f3fa187a4cc59c5f848aa2c7a.json
2023-11-11 12:32:02 --------------------------------------------------------------------
2023-11-11 12:32:02 Analysis started on commit: 1407de3a30800133c65e4e8dff56b313ce5b6bd8
2023-11-11 12:32:02 Java files found in commit: 57
2023-11-11 12:32:03 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1407de3a30800133c65e4e8dff56b313ce5b6bd8.json
2023-11-11 12:32:03 --------------------------------------------------------------------
2023-11-11 12:32:03 Analysis started on commit: 93fc5749b004103cf5dc0cbcd808373aef8e24ba
2023-11-11 12:32:03 Java files found in commit: 56
2023-11-11 12:32:03 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/93fc5749b004103cf5dc0cbcd808373aef8e24ba.json
2023-11-11 12:32:03 --------------------------------------------------------------------
2023-11-11 12:32:03 Analysis started on commit: a61cd0eabc3ae5857026a73ccd358739cd8db950
2023-11-11 12:32:03 Java files found in commit: 58
2023-11-11 12:32:04 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/a61cd0eabc3ae5857026a73ccd358739cd8db950.json
2023-11-11 12:32:04 --------------------------------------------------------------------
2023-11-11 12:32:04 Analysis started on commit: d31eb5b72202b6a14906f88e329d1d051ad6bdc1
2023-11-11 12:32:04 Java files found in commit: 60
2023-11-11 12:32:04 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d31eb5b72202b6a14906f88e329d1d051ad6bdc1.json
2023-11-11 12:32:04 --------------------------------------------------------------------
2023-11-11 12:32:04 Analysis started on commit: 2bee6dfa718d256f79a67c5573cf39a2fbec5cca
2023-11-11 12:32:04 Java files found in commit: 62
2023-11-11 12:32:05 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2bee6dfa718d256f79a67c5573cf39a2fbec5cca.json
2023-11-11 12:32:05 --------------------------------------------------------------------
2023-11-11 12:32:05 Analysis started on commit: ae20a7784f7214c187c5575a936b2320794c54a6
2023-11-11 12:32:05 Java files found in commit: 63
2023-11-11 12:32:05 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/ae20a7784f7214c187c5575a936b2320794c54a6.json
2023-11-11 12:32:05 --------------------------------------------------------------------
2023-11-11 12:32:05 Analysis started on commit: 9738db2e99e40cb7a25a90ed4b1d6888a108b033
2023-11-11 12:32:05 Java files found in commit: 64
2023-11-11 12:32:06 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9738db2e99e40cb7a25a90ed4b1d6888a108b033.json
2023-11-11 12:32:06 --------------------------------------------------------------------
2023-11-11 12:32:06 Analysis started on commit: 093a9ff25032436db0032944e6afc554da45e458
2023-11-11 12:32:06 Java files found in commit: 66
2023-11-11 12:32:06 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/093a9ff25032436db0032944e6afc554da45e458.json
2023-11-11 12:32:06 --------------------------------------------------------------------
2023-11-11 12:32:06 Analysis started on commit: 241a324a6e5ba869ffc9b5368b8d6be97e533b43
2023-11-11 12:32:06 Java files found in commit: 68
2023-11-11 12:32:06 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/241a324a6e5ba869ffc9b5368b8d6be97e533b43.json
2023-11-11 12:32:06 --------------------------------------------------------------------
2023-11-11 12:32:06 Analysis started on commit: 5de12fc6de44b5fcff497deb2893c0ea5043dd5f
2023-11-11 12:32:06 Java files found in commit: 70
2023-11-11 12:32:07 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5de12fc6de44b5fcff497deb2893c0ea5043dd5f.json
2023-11-11 12:32:07 --------------------------------------------------------------------
2023-11-11 12:32:07 Analysis started on commit: 9dbc81cb39486013a82743bd606fc4f0df3962a3
2023-11-11 12:32:07 Java files found in commit: 70
2023-11-11 12:32:07 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9dbc81cb39486013a82743bd606fc4f0df3962a3.json
2023-11-11 12:32:07 --------------------------------------------------------------------
2023-11-11 12:32:07 Analysis started on commit: 91cf95f9ec921938e8467ee81a1e154814946c4a
2023-11-11 12:32:07 Java files found in commit: 70
2023-11-11 12:32:08 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/91cf95f9ec921938e8467ee81a1e154814946c4a.json
2023-11-11 12:32:08 --------------------------------------------------------------------
2023-11-11 12:32:08 Analysis started on commit: 5bf0d8d032a0e5e12624acfe2969a1cd9384e022
2023-11-11 12:32:08 Java files found in commit: 74
2023-11-11 12:32:08 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5bf0d8d032a0e5e12624acfe2969a1cd9384e022.json
2023-11-11 12:32:08 --------------------------------------------------------------------
2023-11-11 12:32:08 Analysis started on commit: 918288378db1dae2bf10d483cd015214abebfc7e
2023-11-11 12:32:08 Java files found in commit: 74
2023-11-11 12:32:09 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/918288378db1dae2bf10d483cd015214abebfc7e.json
2023-11-11 12:32:09 --------------------------------------------------------------------
2023-11-11 12:32:09 Analysis started on commit: 1f5a497eaa0e09c410bf1bd0db2ccd1f8ba6e7c3
2023-11-11 12:32:09 Java files found in commit: 78
2023-11-11 12:32:09 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1f5a497eaa0e09c410bf1bd0db2ccd1f8ba6e7c3.json
2023-11-11 12:32:09 --------------------------------------------------------------------
2023-11-11 12:32:09 Analysis started on commit: a78a46319bd030dab0e2e7010624d4a5d1a9bc36
2023-11-11 12:32:09 Java files found in commit: 79
2023-11-11 12:32:10 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/a78a46319bd030dab0e2e7010624d4a5d1a9bc36.json
2023-11-11 12:32:10 --------------------------------------------------------------------
2023-11-11 12:32:10 Analysis started on commit: ac3e5f0ff85829ecbc3d45fe392f1a867049ca78
2023-11-11 12:32:10 Java files found in commit: 80
2023-11-11 12:32:10 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/ac3e5f0ff85829ecbc3d45fe392f1a867049ca78.json
2023-11-11 12:32:10 --------------------------------------------------------------------
2023-11-11 12:32:10 Analysis started on commit: 94a8c087461c1b140522f7c3901384a40057e697
2023-11-11 12:32:10 Java files found in commit: 80
2023-11-11 12:32:10 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/94a8c087461c1b140522f7c3901384a40057e697.json
2023-11-11 12:32:10 --------------------------------------------------------------------
2023-11-11 12:32:10 Analysis started on commit: dd09c7644121abad07db06fd09faff5092b55b6f
2023-11-11 12:32:10 Java files found in commit: 80
2023-11-11 12:32:11 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/dd09c7644121abad07db06fd09faff5092b55b6f.json
2023-11-11 12:32:11 --------------------------------------------------------------------
2023-11-11 12:32:11 Analysis started on commit: 1c64df247beb502b8dd415eb55fe678169a8ecb3
2023-11-11 12:32:11 Java files found in commit: 94
2023-11-11 12:32:11 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1c64df247beb502b8dd415eb55fe678169a8ecb3.json
2023-11-11 12:32:11 --------------------------------------------------------------------
2023-11-11 12:32:11 Analysis started on commit: c4f70fbec584c797af6725cd56d1362a62c1c500
2023-11-11 12:32:11 Java files found in commit: 96
2023-11-11 12:32:12 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/c4f70fbec584c797af6725cd56d1362a62c1c500.json
2023-11-11 12:32:12 --------------------------------------------------------------------
2023-11-11 12:32:12 Analysis started on commit: e5dc8298f6ac057f6039848aea18d57166a2e379
2023-11-11 12:32:12 Java files found in commit: 98
2023-11-11 12:32:12 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e5dc8298f6ac057f6039848aea18d57166a2e379.json
2023-11-11 12:32:12 --------------------------------------------------------------------
2023-11-11 12:32:12 Analysis started on commit: 2b9a1b61fa8ea4987cbd02b872aa0d86fb56cb49
2023-11-11 12:32:12 Java files found in commit: 113
2023-11-11 12:32:13 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2b9a1b61fa8ea4987cbd02b872aa0d86fb56cb49.json
2023-11-11 12:32:13 --------------------------------------------------------------------
2023-11-11 12:32:13 Analysis started on commit: dcf148c6f73cf6d7d1c3b8c766ce9ad652315f0b
2023-11-11 12:32:13 Java files found in commit: 114
2023-11-11 12:32:13 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/dcf148c6f73cf6d7d1c3b8c766ce9ad652315f0b.json
2023-11-11 12:32:13 --------------------------------------------------------------------
2023-11-11 12:32:13 Analysis started on commit: a50374492b7682e8c14530b81344b1eca87a2412
2023-11-11 12:32:13 Java files found in commit: 115
2023-11-11 12:32:14 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/a50374492b7682e8c14530b81344b1eca87a2412.json
2023-11-11 12:32:14 --------------------------------------------------------------------
2023-11-11 12:32:14 Analysis started on commit: f84e56f3431c7f4b96b31ae7f9dc7ca6f7725632
2023-11-11 12:32:14 Java files found in commit: 115
2023-11-11 12:32:14 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/f84e56f3431c7f4b96b31ae7f9dc7ca6f7725632.json
2023-11-11 12:32:14 --------------------------------------------------------------------
2023-11-11 12:32:14 Analysis started on commit: 77db8e7280295442a592518d53e1ca7d73f3ce48
2023-11-11 12:32:14 Java files found in commit: 117
2023-11-11 12:32:15 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/77db8e7280295442a592518d53e1ca7d73f3ce48.json
2023-11-11 12:32:15 --------------------------------------------------------------------
2023-11-11 12:32:15 Analysis started on commit: 2375e645a39796b87313fe626e6a4963cff7e313
2023-11-11 12:32:15 Java files found in commit: 117
2023-11-11 12:32:15 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2375e645a39796b87313fe626e6a4963cff7e313.json
2023-11-11 12:32:15 --------------------------------------------------------------------
2023-11-11 12:32:15 Analysis started on commit: c149a29b4c05483a909d2dd6654e6f373969e19c
2023-11-11 12:32:15 Java files found in commit: 117
2023-11-11 12:32:16 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/c149a29b4c05483a909d2dd6654e6f373969e19c.json
2023-11-11 12:32:16 --------------------------------------------------------------------
2023-11-11 12:32:16 Analysis started on commit: 8a55a1e14d0ee253ca4cd2915a3a8e07c97b3cb0
2023-11-11 12:32:16 Java files found in commit: 119
2023-11-11 12:32:16 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/8a55a1e14d0ee253ca4cd2915a3a8e07c97b3cb0.json
2023-11-11 12:32:16 --------------------------------------------------------------------
2023-11-11 12:32:16 Analysis started on commit: 25bb4b596f734a3dc77c431a9eff4b4536273f76
2023-11-11 12:32:16 Java files found in commit: 121
2023-11-11 12:32:17 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/25bb4b596f734a3dc77c431a9eff4b4536273f76.json
2023-11-11 12:32:17 --------------------------------------------------------------------
2023-11-11 12:32:17 Analysis started on commit: bcc5fa444bc16b6fbc4d1b88255f063172dfcc13
2023-11-11 12:32:17 Java files found in commit: 123
2023-11-11 12:32:17 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/bcc5fa444bc16b6fbc4d1b88255f063172dfcc13.json
2023-11-11 12:32:17 --------------------------------------------------------------------
2023-11-11 12:32:17 Analysis started on commit: 9e1e72d0e4633a27175c358501932195e3e809e6
2023-11-11 12:32:17 Java files found in commit: 123
2023-11-11 12:32:18 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9e1e72d0e4633a27175c358501932195e3e809e6.json
2023-11-11 12:32:18 --------------------------------------------------------------------
2023-11-11 12:32:18 Analysis started on commit: 2ad007ac3d78649ef4b1d1dfb1530d1dc8bbcbbb
2023-11-11 12:32:18 Java files found in commit: 124
2023-11-11 12:32:18 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2ad007ac3d78649ef4b1d1dfb1530d1dc8bbcbbb.json
2023-11-11 12:32:18 --------------------------------------------------------------------
2023-11-11 12:32:18 Analysis started on commit: 94bb4da8076a15ca679849dbe7baeef98be2a5d9
2023-11-11 12:32:18 Java files found in commit: 124
2023-11-11 12:32:19 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/94bb4da8076a15ca679849dbe7baeef98be2a5d9.json
2023-11-11 12:32:19 --------------------------------------------------------------------
2023-11-11 12:32:19 Analysis started on commit: ef141d402ad2eed4a2b7a74ac15c22d57f920eec
2023-11-11 12:32:19 Java files found in commit: 174
2023-11-11 12:32:19 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/ef141d402ad2eed4a2b7a74ac15c22d57f920eec.json
2023-11-11 12:32:19 --------------------------------------------------------------------
2023-11-11 12:32:19 Analysis started on commit: 2b5716dd7e28ff45abecf3364028fe193df85b14
2023-11-11 12:32:19 Java files found in commit: 174
2023-11-11 12:32:20 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2b5716dd7e28ff45abecf3364028fe193df85b14.json
2023-11-11 12:32:20 --------------------------------------------------------------------
2023-11-11 12:32:20 Analysis started on commit: 38d9df62b83af07adccd24ae97458543029b4c62
2023-11-11 12:32:20 Java files found in commit: 174
2023-11-11 12:32:20 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/38d9df62b83af07adccd24ae97458543029b4c62.json
2023-11-11 12:32:20 --------------------------------------------------------------------
2023-11-11 12:32:20 Analysis started on commit: e427595c2cc1b94b753ccd3a6dbb9b0e5eb248a6
2023-11-11 12:32:20 Java files found in commit: 174
2023-11-11 12:32:21 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e427595c2cc1b94b753ccd3a6dbb9b0e5eb248a6.json
2023-11-11 12:32:21 --------------------------------------------------------------------
2023-11-11 12:32:21 Analysis started on commit: b617c01388477b0ff88e36c43dfef162632ceaca
2023-11-11 12:32:21 Java files found in commit: 174
2023-11-11 12:32:21 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/b617c01388477b0ff88e36c43dfef162632ceaca.json
2023-11-11 12:32:21 --------------------------------------------------------------------
2023-11-11 12:32:21 Analysis started on commit: d520c518ee47e2c7fb56005f8e4c44e9709e6952
2023-11-11 12:32:21 Java files found in commit: 174
2023-11-11 12:32:22 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d520c518ee47e2c7fb56005f8e4c44e9709e6952.json
2023-11-11 12:32:22 --------------------------------------------------------------------
2023-11-11 12:32:22 Analysis started on commit: 1ce9e470b6c5096c539793ecfbb84d5b90852330
2023-11-11 12:32:22 Java files found in commit: 174
2023-11-11 12:32:22 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1ce9e470b6c5096c539793ecfbb84d5b90852330.json
2023-11-11 12:32:22 --------------------------------------------------------------------
2023-11-11 12:32:22 Analysis started on commit: 0cf53ca67a631cbb667f2cb5b59b7b10c6473809
2023-11-11 12:32:22 Java files found in commit: 174
2023-11-11 12:32:23 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/0cf53ca67a631cbb667f2cb5b59b7b10c6473809.json
2023-11-11 12:32:23 --------------------------------------------------------------------
2023-11-11 12:32:23 Analysis started on commit: bed3968f4c89a18d5fe2f443eb04fb03e9993563
2023-11-11 12:32:23 Java files found in commit: 173
2023-11-11 12:32:23 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/bed3968f4c89a18d5fe2f443eb04fb03e9993563.json
2023-11-11 12:32:23 --------------------------------------------------------------------
2023-11-11 12:32:23 Analysis started on commit: 739ea290ded9f4e69d38ac4abde3f7255754e3da
2023-11-11 12:32:23 Java files found in commit: 173
2023-11-11 12:32:24 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/739ea290ded9f4e69d38ac4abde3f7255754e3da.json
2023-11-11 12:32:24 --------------------------------------------------------------------
2023-11-11 12:32:24 Analysis started on commit: fa45f92247f4318b7df96732c0f6f170d2616b09
2023-11-11 12:32:24 Java files found in commit: 173
2023-11-11 12:32:24 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/fa45f92247f4318b7df96732c0f6f170d2616b09.json
2023-11-11 12:32:24 --------------------------------------------------------------------
2023-11-11 12:32:24 Analysis started on commit: 3613e15edd8feb3c572927ba8ddba42830062663
2023-11-11 12:32:24 Java files found in commit: 173
2023-11-11 12:32:25 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/3613e15edd8feb3c572927ba8ddba42830062663.json
2023-11-11 12:32:25 --------------------------------------------------------------------
2023-11-11 12:32:25 Analysis started on commit: 201f6982b41f5c565d77532d29d68aae5ee58eaa
2023-11-11 12:32:25 Java files found in commit: 173
2023-11-11 12:32:25 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/201f6982b41f5c565d77532d29d68aae5ee58eaa.json
2023-11-11 12:32:25 --------------------------------------------------------------------
2023-11-11 12:32:25 Analysis started on commit: 14a3ca3957d2dfadd4409f0298870a092e2bc3c2
2023-11-11 12:32:25 Java files found in commit: 173
2023-11-11 12:32:26 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/14a3ca3957d2dfadd4409f0298870a092e2bc3c2.json
2023-11-11 12:32:26 --------------------------------------------------------------------
2023-11-11 12:32:26 Analysis started on commit: 40777faba66a813a8e525bb4052c5b42ee8b4163
2023-11-11 12:32:26 Java files found in commit: 173
2023-11-11 12:32:26 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/40777faba66a813a8e525bb4052c5b42ee8b4163.json
2023-11-11 12:32:26 --------------------------------------------------------------------
2023-11-11 12:32:26 Analysis started on commit: 3ce2908ed3c6fdbd714646c1536433f61efc2046
2023-11-11 12:32:26 Java files found in commit: 173
2023-11-11 12:32:27 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/3ce2908ed3c6fdbd714646c1536433f61efc2046.json
2023-11-11 12:32:27 --------------------------------------------------------------------
2023-11-11 12:32:27 Analysis started on commit: 8544d76a08403311f80666acf719998f33f3c146
2023-11-11 12:32:27 Java files found in commit: 173
2023-11-11 12:32:27 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/8544d76a08403311f80666acf719998f33f3c146.json
2023-11-11 12:32:27 --------------------------------------------------------------------
2023-11-11 12:32:27 Analysis started on commit: e4de60cf9627bedab3006a705b9693b24e13ca24
2023-11-11 12:32:27 Java files found in commit: 173
2023-11-11 12:32:28 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e4de60cf9627bedab3006a705b9693b24e13ca24.json
2023-11-11 12:32:28 --------------------------------------------------------------------
2023-11-11 12:32:28 Analysis started on commit: 2e57730dbb88d9a349593e8a5e7f1c3df7b172a9
2023-11-11 12:32:28 Java files found in commit: 173
2023-11-11 12:32:28 PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2e57730dbb88d9a349593e8a5e7f1c3df7b172a9.json
2023-11-11 12:32:28 Step 2 Execution Completed!
2023-11-11 12:32:28 Step 2 Execution Time: 50472 ms
2023-11-11 12:32:28 Final JSON Object:
2023-11-11 12:32:28 {"location":"/app/pmd-analyzer-projects/interview-preparation-kit","stat_of_repository":{"number_of_commits":112,"avg_of_num_warnings":185.54,"avg_of_num_java_files":70.73},"stat_of_warnings":{"UseEqualsToCompareStrings":136,"UseUtilityClass":3753,"LooseCoupling":332,"LocalVariableNamingConventions":676,"UnusedPrivateMethod":213,"FormalParameterNamingConventions":270,"UnnecessaryLocalBeforeReturn":61,"UnnecessaryFullyQualifiedName":62,"ForLoopCanBeForeach":510,"CloseResource":467,"SwitchStmtsShouldHaveDefault":82,"DoNotExtendJavaLangThrowable":78,"UselessParentheses":728,"ControlStatementBraces":1496,"MethodNamingConventions":10330,"SimplifyBooleanReturns":93,"AvoidBranchingStatementAsLastInLoop":62,"LiteralsFirstInComparisons":238,"OneDeclarationPerLine":515,"CompareObjectsWithEquals":136,"UseCollectionIsEmpty":122,"UnusedLocalVariable":34,"UncommentedEmptyConstructor":97,"UnnecessaryImport":289}}
```

## Testing

You can test the tool with the [https://github.com/apache/commons-lang](https://github.com/apache/commons-lang)
repository as suggested in Requirement R11.

Happy coding! Life is Logically programmed