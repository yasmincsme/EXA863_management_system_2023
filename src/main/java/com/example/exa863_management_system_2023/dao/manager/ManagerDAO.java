package com.example.exa863_management_system_2023.dao.manager;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;

import java.util.List;

public interface ManagerDAO extends CRUD<Manager, Exception> {

    public List<Manager> findByLogin(String login);
}
