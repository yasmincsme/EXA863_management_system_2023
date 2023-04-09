package com.example.exa863_management_system_2023.model;

import java.util.List;

public class Installation extends Service {

    private List<String> programs;
    private String operatingSystem;

    public Installation(String name) {
        super(name);
    }

    public List<String> getPrograms() {
        return programs;
    }
    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
