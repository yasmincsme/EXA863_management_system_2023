package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Technician;

import java.util.List;

public interface TechnicianDAO extends CRUD<Technician, Exception> {
    public List<Technician> findByName(String name);
}
