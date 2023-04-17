package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Installation extends Service {

    private List<String> programs;
    private String operatingSystem;

    public Installation(String name, String description, long price, long cost, String operatingSystem) {
        super(name, description, price, cost);
        this.programs = new ArrayList<>();
        this.operatingSystem = operatingSystem;
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

    public void addProgram(String program) {
        this.programs.add(program);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Installation) {
            Installation installation = (Installation) object;
            if (this.getID().equals(installation.getID())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Service: Installation" + ", Programs: " + this.programs + ", Operating System: " + this.operatingSystem;

    }
}
