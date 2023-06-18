package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Technician;

import java.util.List;

public interface TechnicianDAO extends CRUD<Technician, Exception> {

    /**
     * Percorre a lista e retorna o objeto Técnico correspondente ao nome informado.
     * @param name Nome do Técnico que se deseja encontrar
     * @return Lista com os técnicos que possuem o nome informado
     */
    public List<Technician> findByName(String name);

    public List<Technician> findByLogin(String login);
}
