package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Cleaning;

import java.util.List;

public interface CleaningDAO extends CRUD<Cleaning, Exception> {
    public List<Cleaning> findByWorkOrderID(String workOrderID);
}
