package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Cleaning;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class CleaningListImplementation implements CleaningDAO {

    private List<Cleaning> listOfCleanings;

    public CleaningListImplementation() {
        this.listOfCleanings = new ArrayList<Cleaning>();
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param cleaning Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public Cleaning create(Cleaning cleaning) {
        cleaning.setID(Generator.generateID());
        this.listOfCleanings.add(cleaning);
        return cleaning;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<Cleaning> findMany() {
        return listOfCleanings;
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public Cleaning findByID(String id) {
        for (Cleaning cleaning : this.listOfCleanings) {
            if (cleaning.getID().equals(id)) {
                return cleaning;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna os serviços do tipo "cleaning" que contém o ID da mesma ordem de serviço.
     * @param workOrderID ID da ordem de serviço
     * @return Lista com todos os serviços do tipo "cleaning" que pertencem a uma mesma ordem de serviço
     */
    @Override
    public List<Cleaning> findByWorkOrderID(String workOrderID) {
        List<Cleaning> orderCleaningList = new ArrayList<>();
        for (Cleaning cleaning : this.listOfCleanings) {
            if (cleaning.getWorkOrderID().equals(workOrderID)) {
                orderCleaningList.add(cleaning);
            }
        }
        return orderCleaningList;
    }

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param cleaning Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void update(Cleaning cleaning) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfCleanings.size(); i++) {
            if (this.listOfCleanings.get(i).getID().equals(cleaning.getID())) {
                this.listOfCleanings.set(i, cleaning);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    /**
     * Percorre a lista e deleta o objeto informado.
     * @param id ID do objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfCleanings.size(); i++) {
            if (listOfCleanings.get(i).getID().equals(id)) {
                listOfCleanings.remove(i);
                FileManager.writeListToFile(listOfCleanings, "cleanings.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    /**
     * Deleta todos os elementos da lista
     */
    @Override
    public void deleteMany() {
        this.listOfCleanings = new ArrayList<Cleaning>();
    }

    /**
     * Percorre a lista e retorna o preço de todos os serviços do tipo "cleaning" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Preço de todos os serviços do tipo "cleaning" de uma ordem de serviço
     */
    @Override
    public double getPriceByServices(String workOrderID) {
        double servicesPrice = 0;
        for (Cleaning cleaning : this.listOfCleanings) {
            if(cleaning.getWorkOrderID().equals(workOrderID)) {
                servicesPrice += cleaning.getPrice();
            }
        }
        return servicesPrice;
    }

    /**
     * Percorre a lista e retorna o custo de todos os serviços do tipo "cleaning" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Custo de todos os serviços do tipo "cleaning" de uma ordem de serviço
     */
    @Override
    public double getCostByServices(String workOrderID) {
        double servicesCost = 0;
        for (Cleaning cleaning : this.listOfCleanings) {
            if(cleaning.getWorkOrderID().equals(workOrderID)) {
                servicesCost += cleaning.getCost();
            }
        }
        return servicesCost;
    }
}
