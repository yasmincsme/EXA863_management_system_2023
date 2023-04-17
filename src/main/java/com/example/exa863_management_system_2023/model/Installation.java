package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Installation extends Service {

    private List<String> programs;
    private String operatingSystem;

    /**
     *
     * @param name Name of the Installation
     * @param description Description of the Installation
     * @param price Price of the Installation
     * @param cost Cost of the Installation
     * @param operatingSystem Operating system of the Installation
     */
    public Installation(String name, String description, long price, long cost, String operatingSystem) {
        super(name, description, price, cost);
        this.programs = new ArrayList<>();
        this.operatingSystem = operatingSystem;
    }

    /**
     *
     * @return Return Installation's programs
     */
    public List<String> getPrograms() {
        return programs;
    }

    /**
     *
     * @param programs new value to programs
     */
    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }

    /**
     *
     * @return Return Installation's operating system
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     *
     * @param operatingSystem New value to operating System
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * Add a new program to the program list
     * @param program New program
     */
    public void addProgram(String program) {
        this.programs.add(program);
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Manager object, or false if they are not the same
     */
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

    /**
     *
     * @return Return a short formatted description of the object
     */
    @Override
    public String toString() {
        return super.toString() + ", Service: Installation" + ", Programs: " + this.programs + ", Operating System: " + this.operatingSystem;
    }
}
