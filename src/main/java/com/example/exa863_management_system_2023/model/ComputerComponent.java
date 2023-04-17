package com.example.exa863_management_system_2023.model;

import java.util.Objects;

public class ComputerComponent {

    private String name;
    private String id;
    private String description;
    private String manufacturer;
    private String serialNumber;
    private long unitCost;
    private long unitPrice;
    private int quantity;

    public ComputerComponent(String name, String description, String manufacturer, String serialNumber, long unitCost, long unitPrice, int quantity) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.unitCost = unitCost;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }

    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getUnitCost() {
        return unitCost;
    }
    public void setUnitCost(long unitCost) {
        this.unitCost = unitCost;
    }

    public long getUnitPrice() {
        return unitPrice;
    }
    public void setPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;}

    public long getCost() {
        return this.getUnitCost() * this.getQuantity();
    }

    public long getPrice() {
        return this.getUnitPrice() * this.getQuantity();
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof ComputerComponent) {
            ComputerComponent component = (ComputerComponent) object;
            if (this.getID().equals(component.getID())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "ID: " + this.id + ", Description: " + this.description + ", Manufacturer: " + this.manufacturer + ", Serial Number: " + this.serialNumber + ", Unit Cost: " + this.unitCost + ", Unit Price: " + this.unitPrice + ", Quantity: " + this.quantity;
    }
}
