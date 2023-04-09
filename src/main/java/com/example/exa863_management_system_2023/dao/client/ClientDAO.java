package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Client;

import java.util.List;

public interface ClientDAO extends CRUD<Client, Exception> {

    public List<Client> findByName(String name);
    public Client findByID(int id);
}
