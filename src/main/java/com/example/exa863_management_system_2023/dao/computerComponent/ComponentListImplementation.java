package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.model.ComputerComponent;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ComponentListImplementation implements ComputerComponentDAO {

    private List<ComputerComponent> stock;
    private String nextID;

    public ComponentListImplementation() {
        this.stock = new ArrayList<ComputerComponent>();
        this.nextID = Generator.generateID();
    }

    @Override
    public ComputerComponent create(ComputerComponent component) {
        component.setID(this.nextID);
        this.nextID = Generator.generateID();
        this.stock.add(component);
        return component;
    }

    @Override
    public List<ComputerComponent> findMany() {
        List<ComputerComponent> computerComponentList = new ArrayList<>();
        for(ComputerComponent component : this.stock) {
            computerComponentList.add(component);
        }
        return computerComponentList;
    }

    @Override
    public ComputerComponent findByID(String id) {
        for (ComputerComponent component : this.stock) {
            if (component.getID().equals(id)) {
                return component;
            }
        }
        return null;
    }

    @Override
    public List<ComputerComponent> findByName(String name) {
        List<ComputerComponent> componentList = new ArrayList<ComputerComponent>();
        for (ComputerComponent component : this.stock) {
            if(component.getName().equals(name)) {
                componentList.add(component);
            }
        }
        return componentList;
    }

    @Override
    public void update(ComputerComponent component) throws Exception{
        for (int i = 0; i < this.stock.size(); i++) {
            if (this.stock.get(i).getID().equals(component.getID())) {
                this.stock.set(i, component);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < this.stock.size(); i++) {
            if (this.stock.get(i).getID().equals(id)) {
                this.stock.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.stock = new ArrayList<>();
        this.nextID = null;
    }
}
