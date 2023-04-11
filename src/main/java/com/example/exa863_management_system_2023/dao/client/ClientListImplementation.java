package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ClientListImplementation implements ClientDAO {

    private List<Client> listOfClients;
    private String nextID;

    public ClientListImplementation() {
        this.listOfClients = new ArrayList<Client>();
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
    }

    @Override
    public Client create(Client client) {
        client.setID(this.nextID);
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
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
    public Client findByID(String id) {
        for (Client client : this.listOfClients) {
            if(Objects.equals(client.getID(), id)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> findByName(String name) {
        List<Client> clientList = new ArrayList<Client>();
        for (Client client : this.listOfClients) {
            if (Objects.equals(client.getName(), name)) {
                clientList.add(client);
            }
        }
        return clientList;
    }

    @Override
    public void update(Client client) {
        for (int i = 0; i < this.listOfClients.size(); i++) {
            if (Objects.equals(this.listOfClients.get(i).getID(), client.getID())) {
                this.listOfClients.set(i, client);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < this.listOfClients.size(); i++) {
            if (Objects.equals(this.listOfClients.get(i).getID(), id)) {
                this.listOfClients.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfClients = new ArrayList<>();
        this.nextID = null;
    }
}
