package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class ComponentListImplementation implements ComputerComponentDAO {

    private List<ComputerComponent> stock;

    public ComponentListImplementation() {
        this.stock = new ArrayList<ComputerComponent>();
    }

    @Override
    public ComputerComponent create(ComputerComponent component) {
        component.setID(Generator.generateID());
        this.stock.add(component);
        return component;
    }

    @Override
    public List<ComputerComponent> findMany() {
        return stock;
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
    public void update(ComputerComponent component) throws ObjectNotFoundException {
        for (int i = 0; i < this.stock.size(); i++) {
            if (this.stock.get(i).getID().equals(component.getID())) {
                this.stock.set(i, component);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed component is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.stock.size(); i++) {
            if (this.stock.get(i).getID().equals(id)) {
                this.stock.remove(i);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed component is not registered in the system");
    }

    @Override
    public void deleteMany() {
        this.stock = new ArrayList<>();
    }
}
