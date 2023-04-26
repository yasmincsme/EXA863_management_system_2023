package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Installation;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class InstallationListImplementation implements InstallationDAO {

    private List<Installation> listOfInstallations;
    private String nextID;

    public InstallationListImplementation() {
        this.listOfInstallations = new ArrayList<Installation>();
        this.nextID = Generator.generateID();
    }

    @Override
    public Installation create(Installation installation) {
        installation.setID(this.nextID);
        this.nextID = Generator.generateID();
        this.listOfInstallations.add(installation);
        return installation;
    }

    @Override
    public List<Installation> findMany() {
        List<Installation> installationList = new ArrayList<Installation>();
        for (Installation installation : this.listOfInstallations) {
            installationList.add(installation);
        }
        return installationList;
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
    public void update(Installation installation) throws Exception {
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (this.listOfInstallations.get(i).getID().equals(installation.getID())) {
                this.listOfInstallations.set(i, installation);
                return;
            }
        }
    }

    @Override
    public void delete(String id) throws Exception {
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (this.listOfInstallations.get(i).getID().equals(id)) {
                this.listOfInstallations.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfInstallations = new ArrayList<>();
        this.nextID = null;
    }
}
