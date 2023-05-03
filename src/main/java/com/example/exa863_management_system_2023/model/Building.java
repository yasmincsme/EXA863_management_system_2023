package com.example.exa863_management_system_2023.model;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Building implements Serializable {

    private String id;
    private String workOrderID;
    private final String type = "BUILDING";
    private String description;
    private double price;
    private double cost;
    private List<ComputerComponent> usedComponents;

    /**
     *
     * @param description Description of the Building
     * @param price Price of the Building
     * @param cost Cost of the Building
     */
    public Building(String description, String workOrderID, double price, double cost) {
        this.id = null;
        this.workOrderID = workOrderID;
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
     * @return ID of the work order that it belongs
     */
    public String getWorkOrderID() {
        return workOrderID;
    }

    /**
     *
     * @param workOrderID New value to work order's ID
     */
    public void setWorkOrderID(String workOrderID) {
        this.workOrderID = workOrderID;
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
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price New value to price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return Return Service's cost
     */
    public double getCost() {
        return cost;
    }

    /**
     *
     * @param cost New value to cost
     */
    public void setCost(double cost) {
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

    public void addComponent(ComputerComponent component) {
        this.usedComponents.add(component);
        increasePrice();
        increaseCost();
    }

    public void removeComponent(String componentID) throws ObjectNotFoundException {
        for (ComputerComponent component : this.usedComponents) {
            if (component.getID().equals(componentID)) {
                decreasePrice();
                decreaseCost();
                this.usedComponents.remove(component);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed component is not registered in the system");
    }

    /**
     * Update the subtotal based on the list of components
     */
    public void increasePrice() {
       double price = 0;
       for (ComputerComponent component : this.usedComponents) {
            price += component.getUnitPrice() * component.getQuantity();
       }
       double newPrice = this.getPrice() + price;
       this.setPrice(newPrice);
    }

    public void increaseCost() {
        double cost = 0;
        for (ComputerComponent component : this.usedComponents) {
            cost += component.getUnitCost() * component.getQuantity();
        }
        double newCost = this.getCost() + cost;
        this.setCost(newCost);
    }

    public void decreasePrice() {
        double price = 0;
        for (ComputerComponent component : this.usedComponents) {
            price += component.getUnitPrice() * component.getQuantity();
        }
        double newPrice = this.getPrice() - price;
        this.setPrice(newPrice);
    }

    public void decreaseCost() {
        double cost = 0;
        for (ComputerComponent component : this.usedComponents) {
            cost += component.getUnitCost() * component.getQuantity();
        }
        double newCost = this.getCost() - cost;
        this.setCost(newCost);
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
        return "Type: " + this.type + ", ID: " + this.id + ", Order's ID: " + this.workOrderID + ", Description: " + this.description + ", Price: " + this.price + ", Cost: " + this.cost + ", Used Components: " + this.usedComponents;
    }
}
