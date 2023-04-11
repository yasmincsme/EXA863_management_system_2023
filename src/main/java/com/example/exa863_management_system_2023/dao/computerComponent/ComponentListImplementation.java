package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.model.Client;
import com.example.exa863_management_system_2023.model.ComputerComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ComponentListImplementation implements ComputerComponentLDAO {

    private List<ComputerComponent> stock;
    private String nextID;

    public ComponentListImplementation() {
        this.stock = new ArrayList<ComputerComponent>();
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
    }

    @Override
    public ComputerComponent create(ComputerComponent component) {
        component.setID(this.nextID);
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
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
    public ComputerComponent findByID(String id) {
        for (ComputerComponent component : this.stock) {
            if (Objects.equals(component.getID(), id)) {
                return component;
            }
        }
        return null;
    }

    @Override
    public List<ComputerComponent> findByName(String name) {
        List<ComputerComponent> componentList = new ArrayList<ComputerComponent>();
        for (ComputerComponent component : this.stock) {
            if(Objects.equals(component.getName(), name)) {
                componentList.add(component);
            }
        }
        return componentList;
    }

    @Override
    public void update(ComputerComponent component) throws Exception{
        for (int i = 0; i < this.stock.size(); i++) {
            if (Objects.equals(this.stock.get(i).getID(), component.getID())) {
                this.stock.set(i, component);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < this.stock.size(); i++) {
            if (Objects.equals(this.stock.get(i).getID(), id)) {
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

    public void deleteSome(String id, int quantity) {
        for (ComputerComponent component : this.stock) {
            if (Objects.equals(component.getID(), id)) {
                int currentQuantity = component.getQuantity();
                component.setQuantity(currentQuantity - quantity);
                return;
            }
        }
    }

}
