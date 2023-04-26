package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.ComputerComponent;

import java.util.List;

public interface ComputerComponentDAO extends CRUD<ComputerComponent, Exception> {
    public List<ComputerComponent> findByName(String name);
}
