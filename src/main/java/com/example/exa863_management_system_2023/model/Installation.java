package com.example.exa863_management_system_2023.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Installation implements Serializable {

    private String id;
    private String workOrderID;
    private final String type = "INSTALLATION";
    private String description;
    private double price;
    private double cost;
    private String operatingSystem;

    /**
     *
     * @param description Description of the Installation
     * @param price Price of the Installation
     * @param cost Cost of the Installation
     * @param operatingSystem Hardware's operating system
     */
    public Installation(String description, String workOrderID, double price, double cost, String operatingSystem) {
        this.id = null;
        this.workOrderID = workOrderID;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.operatingSystem = operatingSystem;
    }

    /**
     *
     * @return Return Service's ID
     */
    public String getID() { return id;}

    /**
     *
     * @param id New value to ID
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     *
     * @return ID of the work order that it belongs
     */
    public String getWorkOrderID() {
        return workOrderID;
    }

    /**
     *
     * @param workOrderID New value to work order's ID
     */
    public void setWorkOrderID(String workOrderID) {
        this.workOrderID = workOrderID;
    }

    /**
     *
     * @return Return Service's description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description New value to description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return Return Service's price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price New value to price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return Return Service's cost
     */
    public double getCost() {
        return cost;
    }

    /**
     *
     * @param cost New value to cost
     */
    public void setCost(double cost) {
        this.cost = cost;
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
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Installation object, or false if they are not the same
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
        return "Type: " + this.type + ", ID: " + this.id + ", Order's ID: " + this.workOrderID + ", Description: " + this.description + ", Price: " + this.price + ", Cost: " + this.cost + ", Operating System: " + this.operatingSystem;
    }
}
