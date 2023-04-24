package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Cleaning {

    private String id;
    private String workOrderID;
    private final String type = "CLEANING";
    private String description;
    private double price;
    private double cost;

    /**
     * @param description Description of the Cleaning
     * @param price       Price of the Cleaning
     * @param cost        Cost og the Cleaning
     */
    public Cleaning(String description, String workOrderID, double price, double cost) {
        this.id = null;
        this.workOrderID = workOrderID;
        this.description = description;
        this.price = price;
        this.cost = cost;
    }

    /**
     * @return Return Service's ID
     */
    public String getID() {
        return id;
    }

    /**
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
     * @return Return Service's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description New value to description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Return Service's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price New value to price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return Return Service's cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost New value to cost
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Cleaning object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Cleaning) {
            Cleaning cleaning = (Cleaning) object;
            if (this.getID().equals(cleaning.getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return Return a short formatted description of the object
     */
    @Override
    public String toString() {
        return "Type: " + this.type + ", ID: " + this.id + ", Order's ID: " + this.workOrderID + ", Description: " + this.description + ", Price: " + this.price + ", Cost: " + this.cost;
    }
}
