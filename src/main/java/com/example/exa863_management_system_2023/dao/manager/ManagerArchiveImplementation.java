package com.example.exa863_management_system_2023.dao.manager;

import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;


import java.util.ArrayList;
import java.util.List;

public class ManagerArchiveImplementation implements ManagerDAO {
    private List<Manager> listOfManagers;
    private FileManager<String> fileManager;

    public ManagerArchiveImplementation() {
        fileManager = new FileManager<>("managers.dat");
        listOfManagers = FileManager.readListFromFile("managers.dat");
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param manager Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public Manager create(Manager manager) {
        manager.setID(Generator.generateID());
        listOfManagers.add(manager);
        FileManager.writeListToFile(listOfManagers, "managers.dat");
        return manager;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<Manager> findMany() {
        return FileManager.readListFromFile("managers.dat");
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public Manager findByID(String id) {
        for (Manager manager : this.listOfManagers) {
            if (manager.getID().equals(id)) {
                return manager;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna o objeto Técnico correspondente ao login informado.
     * @param login Login do gerente que se deseja encontrar
     * @return Lista com os gerentes que possuem o login informado
     */
    @Override
    public List<Manager> findByLogin(String login) {
        List<Manager> managerList = new ArrayList<>();
        for (Manager manager : this.listOfManagers) {
            if (manager.getLogin().equals(login)) {
                managerList.add(manager);
            }
        }
        return managerList;
    }

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param manager Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void update(Manager manager) throws ObjectNotFoundException {
        for (int i = 0; i < listOfManagers.size(); i++) {
            if (listOfManagers.get(i).getID().equals(manager.getID())) {
                listOfManagers.set(i, manager);
                FileManager.writeListToFile(listOfManagers, "managers.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed manager is not registered in the system");
    }

    /**
     * Percorre a lista e deleta o objeto informado.
     * @param id ID do objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfManagers.size(); i++) {
            if (listOfManagers.get(i).getID().equals(id)) {
                listOfManagers.remove(i);
                FileManager.writeListToFile(listOfManagers, "managers.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed manager is not registered in the system");
    }

    /**
     * Deleta todos os elementos da lista
     */
    @Override
    public void deleteMany() {
        listOfManagers = new ArrayList<>();
        FileManager.writeListToFile(listOfManagers, "managers.dat");
    }
}
