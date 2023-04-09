package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientListImplementation implements ClientDAO {

    private List<Client> listOfClients;
    private int nextID;

    public ClientListImplementation() {
        this.listOfClients = new ArrayList<Client>();
        this.nextID = 0;
    }

    @Override
    public Client create(Client client) {
        client.setId(this.nextID);
        this.nextID++;
        this.listOfClients.add(client);
        return client;
    }

    @Override
    public List<Client> findMany() {
        List<Client> clientList = new ArrayList<Client>();
        for (Object client : this.listOfClients) {
            clientList.add((Client) client);
        }
        return clientList;
    }

    @Override
    public Client findByID(int id) {
        for (Client client : this.listOfClients) {
            if(client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> findByName(String name) {
        List<Client> clientList = new ArrayList<Client>();
        for (Client client : this.listOfClients) {
            if (client.getName() == name) {
                clientList.add(client);
            }
        }
        return clientList;
    }

    @Override
    public void update(Client client) {
        for (int i = 0; i < this.listOfClients.size(); i++) {
            if (this.listOfClients.get(i).getId() == client.getId()) {
                this.listOfClients.set(i, client);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.listOfClients.size(); i++) {
            if (this.listOfClients.get(i).getId() == id) {
                this.listOfClients.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfClients = new ArrayList<>();
        this.nextID = 0;
    }
}
