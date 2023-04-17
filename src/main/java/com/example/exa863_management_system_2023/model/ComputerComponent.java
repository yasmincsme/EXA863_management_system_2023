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

    /**
     *
     * @param name Name of the Component
     * @param description Description of the Component
     * @param manufacturer Manufacturer of the Component
     * @param serialNumber Serial number of the Component
     * @param unitCost Unit cost of the Component
     * @param unitPrice Unit price of the Component
     * @param quantity Quantity of the Component
     */
    public ComputerComponent(String name, String description, String manufacturer, String serialNumber, long unitCost, long unitPrice, int quantity) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.unitCost = unitCost;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    /**
     *
     * @param name Name of the Component
     * @param description Description of the Component
     * @param manufacturer Manufacturer of the Component
     */
    public ComputerComponent(String name, String description, String manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
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
     * @return Return Component's description
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
     * @return Return Component's unit cost
     */
    public long getUnitCost() {
        return unitCost;
    }

    /**
     *
     * @param unitCost New value to unit cost
     */
    public void setUnitCost(long unitCost) {
        this.unitCost = unitCost;
    }

    /**
     *
     * @return Return Component's unit price
     */
    public long getUnitPrice() {
        return unitPrice;
    }

    /**
     *
     * @param unitPrice New value to unit price
     */
    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
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
    public long getCost() {
        return this.getUnitCost() * this.getQuantity();
    }

    /**
     *
     * @return Return the result of the multiplication between the unit price and the quantity
     */
    public long getPrice() {
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
        return "ID: " + this.id + ", Name: " + this.name + ", Description: " + this.description + ", Manufacturer: " + this.manufacturer + ", Serial Number: " + this.serialNumber + ", Unit Cost: " + this.unitCost + ", Unit Price: " + this.unitPrice + ", Quantity: " + this.quantity;
    }
}
