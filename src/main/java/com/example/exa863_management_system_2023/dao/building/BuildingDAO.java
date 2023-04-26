package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Client;

import java.util.List;

public interface BuildingDAO extends CRUD<Building, Exception> {
    public List<Building> findByWorkOrderID(String workOrderID);
}
