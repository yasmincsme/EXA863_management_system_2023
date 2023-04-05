package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.model.Client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClientListImplementation implements ClientDAO {

    private List<Client> listOfClients;
    private int nextID;

    public ClientListImplementation() {
        this.listOfClients = new ArrayList<Client>();
        this.nextID = 0;
    }

}
