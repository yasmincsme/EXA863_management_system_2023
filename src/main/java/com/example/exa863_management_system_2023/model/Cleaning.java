package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Cleaning extends Service{

    private List<ComputerComponent> components;

    public Cleaning(String name, String description, long price, long cost) {
        super(name, description, price, cost);
        this.components = new ArrayList<>();
    }

    public List<ComputerComponent> getComponents() {
        return components;
    }
    public void setComponents(List<ComputerComponent> components) {
        this.components = components;
    }

    public void addComponent(ComputerComponent component) {
        this.components.add(component);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Cleaning) {
            Cleaning cleaning = (Cleaning) object;
            if (this.getID().equals(cleaning.getID())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Service: Cleaning" + ", Components: " + this.components;
    }
}
