package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Building extends Service{

    private List<ComputerComponent> usedComponents;

    /**
     *
     * @param name Name of the Building
     * @param description Description of the Building
     * @param price Price of the Building
     * @param cost Cost of the Building
     */
    public Building(String name, String description, long price, long cost) {
        super(name, description, price, cost);
        this.usedComponents = new ArrayList<>();
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
    public long increasePrice() {
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
    public long increaseCost() {
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
        return super.toString() + ", Service: Building" + ", Components: " + this.usedComponents;
    }
}
