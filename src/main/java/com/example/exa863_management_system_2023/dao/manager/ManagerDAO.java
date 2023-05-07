package com.example.exa863_management_system_2023.dao.manager;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;

import java.util.List;

public interface ManagerDAO extends CRUD<Manager, Exception> {

    /**
     * Percorre a lista e retorna o objeto Técnico correspondente ao login informado.
     * @param login Login do gerente que se deseja encontrar
     * @return Lista com os gerentes que possuem o login informado
     */
    public List<Manager> findByLogin(String login);
}
