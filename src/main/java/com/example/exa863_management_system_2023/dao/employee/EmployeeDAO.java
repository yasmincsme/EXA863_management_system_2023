package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Employee;

import java.util.List;

public interface EmployeeDAO extends CRUD<Employee, Exception> {

    /**
     * Percorre a lista e retorna o objeto Funcionário correspondente ao login informado.
     * @param login Login do Funcionário que se deseja encontrar
     * @return Lista com os funcionários que possuem o login informado
     */
    public List<Employee> findByLogin(String login);
}
