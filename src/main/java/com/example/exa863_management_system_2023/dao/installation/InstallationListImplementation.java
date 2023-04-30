package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Installation;
import com.example.exa863_management_system_2023.utils.Generator;
import java.util.ArrayList;
import java.util.List;

public class InstallationListImplementation implements InstallationDAO {

    private List<Installation> listOfInstallations;

    public InstallationListImplementation() {
        this.listOfInstallations = new ArrayList<Installation>();
    }

    @Override
    public Installation create(Installation installation) {
        installation.setID(Generator.generateID());
        this.listOfInstallations.add(installation);
        return installation;
    }

    @Override
    public List<Installation> findMany() {
        return listOfInstallations;
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
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (this.listOfInstallations.get(i).getID().equals(id)) {
                this.listOfInstallations.remove(i);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    @Override
    public void deleteMany() {
        this.listOfInstallations = new ArrayList<>();
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
