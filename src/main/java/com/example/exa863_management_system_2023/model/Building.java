package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private String id;
    private final String type = "BUILDING";
    private String description;
    private Double price;
    private Double cost;
    private List<ComputerComponent> usedComponents;

    /**
     *
     * @param description Description of the Building
     * @param price Price of the Building
     * @param cost Cost of the Building
     */
    public Building(String description, Double price, Double cost) {
        this.id = null;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.usedComponents = new ArrayList<>();
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
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @param price New value to price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     *
     * @return Return Service's cost
     */
    public Double getCost() {
        return cost;
    }

    /**
     *
     * @param cost New value to cost
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     *
     * @return Return Building's used components
     */
    public List<ComputerComponent> getUsedComponents() {
        return usedComponents;
    }

    /**
     *
     * @param usedComponents new value to used components
     */
    public void setUsedComponents(List<ComputerComponent> usedComponents) {
        this.usedComponents = usedComponents;
    }

    /**
     * Add a new component to the component list
     * @param component New component
     */
    public void addComputerComponent(ComputerComponent component) {
        this.usedComponents.add(component);
    }

    /**
     * Add the price of the used components to the subtotal
     * @return Return the price that was fixed to the Building plus the additional price of the components
     */
    public Double increasePrice() {
       long price = 0;
       for (ComputerComponent component : this.usedComponents) {
            price += component.getUnitPrice() * component.getQuantity();
       }
       return price + this.getPrice();
    }

    /**
     * Add the cost of the used components to the subtotal
     * @return Return the cost that was fixed to the Building plus the additional cost of the components
     */
    public Double increaseCost() {
        long cost = 0;
        for (ComputerComponent component : this.usedComponents) {
            cost += component.getUnitCost() * component.getQuantity();
        }
        return cost + this.getCost();
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Building object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Building) {
            Building building = (Building) object;
            if(this.getID().equals(building.getID())) {
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
        return "Type: " + this.type + ", ID: " + this.id + ", Description: " + this.description + ", Price: " + this.price + ", Cost: " + this.cost + ", Used Components: " + this.usedComponents;
    }
}
