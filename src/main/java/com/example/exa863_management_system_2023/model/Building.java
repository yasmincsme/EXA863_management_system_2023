package com.example.exa863_management_system_2023.model;

import java.util.List;

public class Building extends Service{

    private List<ComputerComponent> usedComponents;

    public Building(String name) {
        super(name);
    }

    public List<ComputerComponent> getUsedComponents() {
        return usedComponents;
    }
    public void setUsedComponents() {
        this.usedComponents = usedComponents;
    }
}
