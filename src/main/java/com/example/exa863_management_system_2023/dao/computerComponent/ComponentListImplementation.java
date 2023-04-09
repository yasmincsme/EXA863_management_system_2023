package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.model.Client;
import com.example.exa863_management_system_2023.model.ComputerComponent;

import java.util.ArrayList;
import java.util.List;

public class ComponentListImplementation implements ComputerComponentLDAO {

    private List<ComputerComponent> stock;
    private int nextID;

    public ComponentListImplementation() {
        this.stock = new ArrayList<ComputerComponent>();
        this.nextID = 0;
    }

    @Override
    public ComputerComponent create(ComputerComponent component) {
        component.setId(this.nextID);
        this.nextID++;
        this.stock.add(component);
        return component;
    }

    @Override
    public List<ComputerComponent> findMany() {
        List<ComputerComponent> computerComponentList = new ArrayList<>();
        for(Object component : this.stock) {
            computerComponentList.add((ComputerComponent) component);
        }
        return computerComponentList;
    }

    @Override
    public ComputerComponent findByID(int id) {
        for (ComputerComponent component : this.stock) {
            if (component.getId() == id) {
                return component;
            }
        }
        return null;
    }

    @Override
    public List<ComputerComponent> findByName(String name) {
        List<ComputerComponent> componentList = new ArrayList<ComputerComponent>();
        for (ComputerComponent component : this.stock) {
            if(component.getName() == name) {
                componentList.add(component);
            }
        }
        return componentList;
    }

    @Override
    public void update(ComputerComponent component) throws Exception{
        for (int i = 0; i < this.stock.size(); i++) {
            if (this.stock.get(i).getId() == component.getId()) {
                this.stock.set(i, component);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.stock.size(); i++) {
            if (this.stock.get(i).getId() == id) {
                this.stock.remove(i);
            }
        }
    }

    @Override
    public void deleteMany() {
        this.stock = new ArrayList<>();
        this.nextID = 0;
    }

    public void deleteSome(int id, int quantity) {
        for (int i = 0; i< this.stock.size(); i++) {
            if(this.stock.get(i).getId() == id) {
                int currentQuantity = this.stock.get(i).getQuantity();
                this.stock.get(i).setQuantity(currentQuantity - quantity);
                return;
            }
        }
    }

}
