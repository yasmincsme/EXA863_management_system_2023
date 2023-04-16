package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Cleaning extends Service{

    private List<String> components;

    public Cleaning(long price, long cost) {
        this.price = price;
        this.cost = cost;
        this.components = new ArrayList<>();
    }

    public List<String> getComponents() {
        return components;
    }
    public void setComponents(List<String> components) {
        this.components = components;
    }
}
