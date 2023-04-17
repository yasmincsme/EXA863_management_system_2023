package com.example.exa863_management_system_2023.model;

public abstract class Service {

    private String id;
    private String name;
    private String description;
    private long price;
    private long cost;

    /**
     *
     * @param name Name of the Service
     * @param description Description of the Service
     * @param price Price of the Service
     * @param cost Cost of the Service
     */
    public Service(String name, String description, long price, long cost) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.cost = cost;
    }

    /**
     *
     * @param name Name of the Service
     * @param description Description of the Service
     */
    public Service(String name, String description) {
        this.name = name;
        this.description = description;
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
     * @return Return Service's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name New value to name
     */
    public void setName(String name) {
        this.name = name;
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
    public long getPrice() {
        return price;
    }

    /**
     *
     * @param price New value to price
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     *
     * @return Return Service's cost
     */
    public long getCost() {
        return cost;
    }

    /**
     *
     * @param cost New value to cost
     */
    public void setCost(long cost) {
        this.cost = cost;
    }

    /**
     *
     * @return Return a short formatted description of the object
     */
    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Description: " + this.description + ", Price: " + this.price + ", Cost: " + this.cost;
    }
}

