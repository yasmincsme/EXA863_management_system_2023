package com.example.exa863_management_system_2023.dao.manager;

import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ManagerListImplementation implements ManagerDAO {

    private List<Manager> listOfManagers;
    private String nextID;

    public ManagerListImplementation() {
        this.listOfManagers = new ArrayList<Manager>();
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
    }

    @Override
    public Manager create(Manager manager) {
        manager.setID(this.nextID);
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
        this.listOfManagers.add(manager);
        return manager;
    }

    @Override
    public List<Manager> findMany() {
        List<Manager> managerList = new ArrayList<Manager>();
        for (Manager manager : this.listOfManagers) {
            managerList.add((Manager) manager);
        }
        return managerList;
    }

    @Override
    public Manager findByID(String id) {
        for (Manager manager : this.listOfManagers) {
            if (Objects.equals(manager.getID(), id)) {
                return manager;
            }
        }
        return null;
    }

    @Override
    public List<Manager> findByLogin(String login) {
        List<Manager> managerList = new ArrayList<Manager>();
        for (Manager manager : this.listOfManagers) {
            if (Objects.equals(manager.getLogin(), login)) {
                managerList.add(manager);
            }
        }
        return managerList;
    }

    @Override
    public void update(Manager manager) {
        for (int i = 0; i < this.listOfManagers.size(); i++) {
            if (Objects.equals(this.listOfManagers.get(i).getID(), manager.getID())) {
                this.listOfManagers.set(i, manager);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < this.listOfManagers.size(); i++) {
            if(Objects.equals(this.listOfManagers.get(i).getID(), id)) {
                this.listOfManagers.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfManagers = new ArrayList<Manager>();
        this.nextID = null;
    }
}
