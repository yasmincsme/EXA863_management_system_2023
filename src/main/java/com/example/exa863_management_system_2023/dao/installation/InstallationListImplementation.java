package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.model.Installation;

public class InstallationListImplementation implements InstallationDAO {

    private Installation installationService;

    public InstallationListImplementation() {
        this.installationService = new Installation()
    }
}
