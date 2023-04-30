package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Installation;

import java.util.List;

public interface InstallationDAO extends CRUD<Installation, Exception> {
    public List<Installation> findByWorkOrderID(String workOrderID);
    public double getPriceByServices(String workOrderID);
    public double getCostByServices(String workOrderID);
}
