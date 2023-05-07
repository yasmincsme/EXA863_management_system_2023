package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Client;

import java.util.List;

public interface ClientDAO extends CRUD<Client, Exception> {

    /**
     * Percorre a lista e retorna o objeto Cliente correspondente ao nome informado.
     * @param name Nome do Cliente que se deseja encontrar
     * @return Lista com os clientes que possuem o nome informado
     */
    public List<Client> findByName(String name);
}
