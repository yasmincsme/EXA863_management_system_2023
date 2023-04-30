package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.model.Client;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class ClientListImplementation implements ClientDAO {

    private List<Client> listOfClients;

    public ClientListImplementation() {
        this.listOfClients = new ArrayList<Client>();
    }

    @Override
    public Client create(Client client) {
        client.setID(Generator.generateID());
        this.listOfClients.add(client);
        return client;
    }

    @Override
    public List<Client> findMany() {
        return listOfClients;
    }

    @Override
    public Client findByID(String id) {
        for (Client client : this.listOfClients) {
            if (client.getID().equals(id)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> findByName(String name) {
        List<Client> clientList = new ArrayList<Client>();
        for (Client client : this.listOfClients) {
            if (client.getName().equals(name)) {
                clientList.add(client);
            }
        }
        return clientList;
    }

    @Override
    public void update(Client client) {
        for (int i = 0; i < this.listOfClients.size(); i++) {
            if (this.listOfClients.get(i).getID().equals(client.getID())) {
                this.listOfClients.set(i, client);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < this.listOfClients.size(); i++) {
            if (this.listOfClients.get(i).getID().equals(id)) {
                this.listOfClients.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfClients = new ArrayList<>();
    }
}
