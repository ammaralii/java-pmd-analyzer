package org.example.dto;

public class PMDRepositoryStats {
    private Integer number_of_commits;
    private Double avg_of_num_java_files;
    private Double avg_of_num_warnings;

    public Integer getNumber_of_commits() {
        return number_of_commits;
    }

    public void setNumber_of_commits(Integer number_of_commits) {
        this.number_of_commits = number_of_commits;
    }

    public Double getAvg_of_num_java_files() {
        return avg_of_num_java_files;
    }

    public void setAvg_of_num_java_files(Double avg_of_num_java_files) {
        this.avg_of_num_java_files = Double.valueOf(String.format("%.2f", avg_of_num_java_files));
    }

    public Double getAvg_of_num_warnings() {
        return avg_of_num_warnings;
    }

    public void setAvg_of_num_warnings(Double avg_of_num_warnings) {
        this.avg_of_num_warnings = Double.valueOf(String.format("%.2f", avg_of_num_warnings));
    }
}
