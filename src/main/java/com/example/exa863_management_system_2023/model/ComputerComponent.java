package com.example.exa863_management_system_2023.model;

import java.util.Objects;

public class ComputerComponent {

    private String name;
    private String id;
    private String buildingID;
    private String manufacturer;
    private String serialNumber;
    private double unitPrice;
    private double unitCost;
    private int quantity;

    /**
     *
     * @param name Component's name
     * @param manufacturer Component's manufacturer
     * @param serialNumber Component's serial number
     * @param unitPrice Component's unit price
     * @param unitCost Component's unit cost
     * @param quantity Component's quantity
     */
    public ComputerComponent(String name, String manufacturer, String serialNumber, double unitPrice, double unitCost, int quantity) {
        this.name = name;
        this.buildingID = null;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }

    /**
     *
     * @return Return Component's name
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
     * @return Return Component's ID
     */
    public String getID() {
        return id;
    }

    /**
     *
     * @param id New value to ID
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     *
     * @return Return building's ID
     */
    public String getBuildingID() {
        return buildingID;
    }

    /**
     *
     * @param buildingID New value to building's ID
     */
    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    /**
     *
     * @return Return Component's manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     *
     * @param manufacturer New value to manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     *
     * @return Return Component's serial number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     *
     * @param serialNumber New value to serial number
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     *
     * @return Return Component's unit price
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     *
     * @param unitPrice New value to unit price
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     *
     * @return Return Component's unit cost
     */
    public double getUnitCost() {
        return unitCost;
    }

    /**
     *
     * @param unitCost New value to unit cost
     */
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    /**
     *
     * @return Return Component's quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity New value to quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;}

    /**
     *
     * @return Return the result of the multiplication between the unit cost and the quantity
     */
    public double getCost() {
        return this.getUnitCost() * this.getQuantity();
    }

    /**
     *
     * @return Return the result of the multiplication between the unit price and the quantity
     */
    public double getPrice() {
        return this.getUnitPrice() * this.getQuantity();
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Manager object, or false if they are not the same
     */
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

    /**
     *
     * @return Return a short formatted description of the object
     */
    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Manufacturer: " + this.manufacturer + ", Serial Number: " + this.serialNumber + ", Unit Price: " + this.unitPrice + ", Unit Cost: " + this.unitCost + ", Quantity: " + this.quantity;
    }
}
