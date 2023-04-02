package com.example.exa863_management_system_2023.model;

public abstract class Service {

    private String name;
    private String description;
    private Double price;
    private Double cost;

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription() {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice() {
        this.price = price;
    }

    public Double getCost() {
        return cost;
    }
    public void setCost() {
        this.cost = cost;
    }
}

