package com.example.exa863_management_system_2023.model;

public abstract class Service {

    private String name;
    private String id;
    private String description;
    private long price;
    private long cost;

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getID() { return id;}
    public void setID(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }

    public long getCost() {
        return cost;
    }
    public void setCost(long cost) {
        this.cost = cost;
    }
}

