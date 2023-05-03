package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Client;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class ClientArchiveImplementation implements ClientDAO{

    private List<Client> listOfClients;
    private FileManager<String> fileManager;

    public ClientArchiveImplementation() {
        fileManager = new FileManager<>("clients.dat");
        listOfClients = FileManager.readListFromFile("clients.dat");
    }

    @Override
    public Client create(Client client) {
        client.setID(Generator.generateID());
        listOfClients.add(client);
        FileManager.writeListToFile(listOfClients, "clients.dat");
        return client;
    }

    @Override
    public List<Client> findMany() {
        return FileManager.readListFromFile("clients.dat");
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
    public void update(Client client) throws ObjectNotFoundException {
        for (int i = 0; i < listOfClients.size(); i++) {
            if (listOfClients.get(i).getID().equals(client.getID())) {
                listOfClients.set(i, client);
                FileManager.writeListToFile(listOfClients, "clients.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed client is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfClients.size(); i++) {
            if (listOfClients.get(i).getID().equals(id)) {
                listOfClients.remove(i);
                FileManager.writeListToFile(listOfClients, "clients.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed client is not registered in the system");
    }

    @Override
    public void deleteMany() {
        listOfClients = new ArrayList<>();
        FileManager.writeListToFile(listOfClients, "clients.dat");
    }
}
