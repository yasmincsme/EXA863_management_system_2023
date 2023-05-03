package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import com.example.exa863_management_system_2023.model.Installation;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class ComponentArchiveImplementation implements ComputerComponentDAO {
    private List<ComputerComponent> stock;
    private FileManager<String> fileManager;

    public ComponentArchiveImplementation() {
        fileManager = new FileManager<>("components.dat");
        stock = FileManager.readListFromFile("components.dat");
    }

    @Override
    public ComputerComponent create(ComputerComponent component) {
        component.setID(Generator.generateID());
        stock.add(component);
        FileManager.writeListToFile(stock, "components.dat");
        return component;
    }

    @Override
    public List<ComputerComponent> findMany() {
        return FileManager.readListFromFile("components.dat");
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
                FileManager.writeListToFile(stock, "components.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed component is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.stock.size(); i++) {
            if (stock.get(i).getID().equals(id)) {
                stock.remove(i);
                FileManager.writeListToFile(stock, "components.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed component is not registered in the system");
    }

    @Override
    public void deleteMany() {
        stock = new ArrayList<>();
        FileManager.writeListToFile(stock, "components.dat");
    }
}
