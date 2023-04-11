package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Employee;

import java.util.List;

public interface EmployeeDAO extends CRUD<Employee, Exception> {

    public List<Employee> findByLogin(String login);
}
