package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Cleaning;
import com.example.exa863_management_system_2023.model.Installation;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class InstallationArchiveImplementation implements InstallationDAO {
    private List<Installation> listOfInstallations;
    private FileManager<String> fileManager;

    public InstallationArchiveImplementation() {
        fileManager = new FileManager<>("installations.dat");
        listOfInstallations = FileManager.readListFromFile("installations.dat");
    }

    @Override
    public Installation create(Installation installation) {
        installation.setID(Generator.generateID());
        listOfInstallations.add(installation);
        FileManager.writeListToFile(listOfInstallations, "installations.dat");
        return installation;
    }

    @Override
    public List<Installation> findMany() {
        return FileManager.readListFromFile("installations.dat");
    }

    @Override
    public Installation findByID(String id) {
        for (Installation installation : this.listOfInstallations) {
            if (installation.getID().equals(id)) {
                return installation;
            }
        }
        return null;
    }

    @Override
    public List<Installation> findByWorkOrderID(String workOrderID) {
        List<Installation> orderInstallationList = new ArrayList<>();
        for (Installation installation : this.listOfInstallations) {
            if (installation.getWorkOrderID().equals(workOrderID)) {
                orderInstallationList.add(installation);
            }
        }
        return orderInstallationList;
    }

    @Override
    public void update(Installation installation) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (this.listOfInstallations.get(i).getID().equals(installation.getID())) {
                this.listOfInstallations.set(i, installation);
                FileManager.writeListToFile(listOfInstallations, "installations.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (listOfInstallations.get(i).getID().equals(id)) {
                listOfInstallations.remove(i);
                FileManager.writeListToFile(listOfInstallations, "installations.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    @Override
    public void deleteMany() {
        listOfInstallations = new ArrayList<>();
        FileManager.writeListToFile(listOfInstallations, "installations.dat");
    }

    @Override
    public double getPriceByServices(String workOrderID) {
        double servicesPrice = 0;
        for (Installation installation : this.listOfInstallations) {
            if(installation.getWorkOrderID().equals(workOrderID)) {
                servicesPrice += installation.getPrice();
            }
        }
        return servicesPrice;
    }

    @Override
    public double getCostByServices(String workOrderID) {
        double servicesCost = 0;
        for (Installation installation : this.listOfInstallations) {
            if(installation.getWorkOrderID().equals(workOrderID)) {
                servicesCost += installation.getCost();
            }
        }
        return servicesCost;
    }
}
