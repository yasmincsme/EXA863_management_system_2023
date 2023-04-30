package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Client;
import com.example.exa863_management_system_2023.model.ComputerComponent;

import java.util.List;

public interface BuildingDAO extends CRUD<Building, Exception> {
    public List<Building> findByWorkOrderID(String workOrderID);
    public double getPriceByServices(String workOrderID);
    public double getCostByServices(String workOrderID);
}
