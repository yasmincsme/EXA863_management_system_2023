package com.example.exa863_management_system_2023.model;

public abstract class Service {

    private String name;
    private int id;
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

    public int getId() { return id;}
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCost() {
        return cost;
    }
    public void setCost(Double price) {
        this.cost = cost;
    }
}

