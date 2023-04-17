package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Building extends Service{

    private List<ComputerComponent> usedComponents;

    public Building(String name, String description) {
        super(name, description);
        this.usedComponents = new ArrayList<>();
    }

    public List<ComputerComponent> getUsedComponents() {
        return usedComponents;
    }
    public void setUsedComponents(List<ComputerComponent> usedComponents) {
        this.usedComponents = usedComponents;
    }

    public void addComputerComponent(ComputerComponent component) {
        this.usedComponents.add(component);
    }

    @Override
    public long getPrice() {
       long price = 0;
       for (ComputerComponent component : this.usedComponents) {
            price += component.getUnitPrice() * component.getQuantity();
       }
       return price;
    }

    @Override
    public long getCost() {
        long cost = 0;
        for (ComputerComponent component : this.usedComponents) {
            cost += component.getUnitCost() * component.getQuantity();
        }
        return cost;
    }

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

    @Override
    public String toString() {
        return super.toString() + ", Service: Building" + ", Components: " + this.usedComponents;
    }
}
