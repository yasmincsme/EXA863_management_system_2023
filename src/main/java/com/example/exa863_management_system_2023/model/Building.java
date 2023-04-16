package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Building extends Service{

    private List<ComputerComponent> usedComponents;

    public Building() {
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
}
