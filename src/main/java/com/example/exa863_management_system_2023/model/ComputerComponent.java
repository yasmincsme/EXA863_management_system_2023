package com.example.exa863_management_system_2023.model;

public class ComputerComponent {

    private String name;
    private String description;
    private String manufacturer;
    private int id;
    private String serialNumber;
    private Double cost;
    private Double unitPrice;
    private int quantity;

    public ComputerComponent(Double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription() {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer() {
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setPrice() {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
}
