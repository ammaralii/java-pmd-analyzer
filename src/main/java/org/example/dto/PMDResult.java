package org.example.dto;

import java.util.HashMap;
import java.util.Map;

public class PMDResult {
    private String location;
    private PMDRepositoryStats stat_of_repository;

    private Map<String, Integer> stat_of_warnings;

    public PMDResult(String location) {
        this.location = location;
        stat_of_warnings = new HashMap<>();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PMDRepositoryStats getStat_of_repository() {
        return stat_of_repository;
    }

    public void setStat_of_repository(PMDRepositoryStats stat_of_repository) {
        this.stat_of_repository = stat_of_repository;
    }

    public Map<String, Integer> getStat_of_warnings() {
        return stat_of_warnings;
    }

    public void setStat_of_warnings(Map<String, Integer> stat_of_warnings) {
        this.stat_of_warnings = stat_of_warnings;
    }
}
