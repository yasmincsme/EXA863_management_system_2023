package com.example.exa863_management_system_2023.model;

public class ComputerComponent {

    private String name;
    private String manufacturer;
    private String serialNumber;
    private Double cost;
    private Double price;

    public ComputerComponent(Double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer() {
        this.manufacturer = manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber() {
        this.serialNumber = serialNumber;
    }

    public Double getCost() {
        return cost;
    }
    public void setCost() {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice() {
        this.price = price;
    }
}
