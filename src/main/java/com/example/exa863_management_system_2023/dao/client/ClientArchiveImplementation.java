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

    /**
     * Cria um novo objeto do tipo especificado.
     * @param client Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public Client create(Client client) {
        client.setID(Generator.generateID());
        listOfClients.add(client);
        FileManager.writeListToFile(listOfClients, "clients.dat");
        return client;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<Client> findMany() {
        return FileManager.readListFromFile("clients.dat");
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public Client findByID(String id) {
        for (Client client : this.listOfClients) {
            if (client.getID().equals(id)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna o objeto Cliente correspondente ao nome informado.
     * @param name Nome do Cliente que se deseja encontrar
     * @return Lista com os clientes que possuem o nome informado
     */
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

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param client Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
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

    /**
     * Percorre a lista e deleta o objeto informado.
     * @param id ID do objeto que será atualizado
     * @throws ObjectNotFoundException
     */
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

    /**
     * Deleta todos os elementos da lista
     */
    @Override
    public void deleteMany() {
        listOfClients = new ArrayList<>();
        FileManager.writeListToFile(listOfClients, "clients.dat");
    }
}
