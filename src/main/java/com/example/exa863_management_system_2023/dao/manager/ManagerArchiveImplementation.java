package com.example.exa863_management_system_2023.dao.manager;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;


import java.util.ArrayList;
import java.util.List;

public class ManagerArchiveImplementation implements ManagerDAO{
    private List<Manager> listOfManagers;
    private FileManager<String> fileManager;

    public ManagerArchiveImplementation() {
        fileManager = new FileManager<>("managers.dat");
        listOfManagers = FileManager.readListFromFile("managers.dat");
    }

    @Override
    public Manager create(Manager manager) {
        manager.setID(Generator.generateID());
        listOfManagers.add(manager);
        FileManager.writeListToFile(listOfManagers, "managers.dat");
        return manager;
    }

    @Override
    public List<Manager> findMany() {
        return FileManager.readListFromFile("managers.dat");
    }

    @Override
    public Manager findByID(String id) {
        for (Manager manager : this.listOfManagers) {
            if (manager.getID().equals(id)) {
                return manager;
            }
        }
        return null;
    }

    @Override
    public List<Manager> findByLogin(String login) {
        List<Manager> managerList = new ArrayList<>();
        for (Manager manager : this.listOfManagers) {
            if (manager.getLogin().equals(login)) {
                managerList.add(manager);
            }
        }
        return managerList;
    }

    @Override
    public void update(Manager manager) throws ObjectNotFoundException {
        for (int i = 0; i < listOfManagers.size(); i++) {
            if (listOfManagers.get(i).getID().equals(manager.getID())) {
                listOfManagers.set(i, manager);
                FileManager.writeListToFile(listOfManagers, "managers.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed manager is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfManagers.size(); i++) {
            if (listOfManagers.get(i).getID().equals(id)) {
                listOfManagers.remove(i);
                FileManager.writeListToFile(listOfManagers, "managers.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed manager is not registered in the system");
    }

    @Override
    public void deleteMany() {
        listOfManagers = new ArrayList<>();
        FileManager.writeListToFile(listOfManagers, "managers.dat");
    }
}
