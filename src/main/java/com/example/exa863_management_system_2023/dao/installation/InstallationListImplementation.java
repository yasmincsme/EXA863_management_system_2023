package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.model.Installation;

import java.util.ArrayList;
import java.util.List;

public class InstallationListImplementation implements InstallationDAO {

    private List<Installation> listOfInstallations;
    private int nextID;

    public InstallationListImplementation() {
        this.listOfInstallations = new ArrayList<Installation>();
        this.nextID = 0;
    }

    @Override
    public Installation create(Installation installation) {
        installation.setId(this.nextID);
        this.nextID++;
        this.listOfInstallations.add(installation);
        return installation;
    }

    @Override
    public List<Installation> findMany() {
        List<Installation> installationList = new ArrayList<Installation>();
        for (Object installation : this.listOfInstallations) {
            installationList.add((Installation) installation);
        }
        return installationList;
    }

    @Override
    public Installation findByID(int id) {
        for (Installation installation : this.listOfInstallations) {
            if (installation.getId() == id) {
                return installation;
            }
        }
        return null;
    }

    @Override
    public void update(Installation installation) throws Exception {
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (this.listOfInstallations.get(i).getId() == installation.getId()) {
                this.listOfInstallations.set(i, installation);
                return;
            }
        }
    }

    @Override
    public void delete(int id) throws Exception {
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (this.listOfInstallations.get(i).getId() == id) {
                this.listOfInstallations.remove(i);
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfInstallations = new ArrayList<>();
        this.nextID = 0;
    }
}
