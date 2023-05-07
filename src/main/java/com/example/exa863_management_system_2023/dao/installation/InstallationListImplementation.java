package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Installation;
import com.example.exa863_management_system_2023.utils.Generator;
import java.util.ArrayList;
import java.util.List;

public class InstallationListImplementation implements InstallationDAO {

    private List<Installation> listOfInstallations;

    public InstallationListImplementation() {
        this.listOfInstallations = new ArrayList<Installation>();
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param installation Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public Installation create(Installation installation) {
        installation.setID(Generator.generateID());
        this.listOfInstallations.add(installation);
        return installation;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<Installation> findMany() {
        return listOfInstallations;
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public Installation findByID(String id) {
        for (Installation installation : this.listOfInstallations) {
            if (installation.getID().equals(id)) {
                return installation;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna os serviços do tipo "installation" que contém o ID da mesma ordem de serviço.
     * @param workOrderID ID da ordem de serviço
     * @return Lista com todos os serviços do tipo "installation" que pertencem a uma mesma ordem de serviço
     */
    @Override
    public List<Installation> findByWorkOrderID(String workOrderID) {
        List<Installation> orderInstallationList = new ArrayList<>();
        for (Installation installation : this.listOfInstallations) {
            if (installation.getWorkOrderID().equals(workOrderID)) {
                orderInstallationList.add(installation);
            }
        }
        return orderInstallationList;
    }

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param installation Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void update(Installation installation) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (this.listOfInstallations.get(i).getID().equals(installation.getID())) {
                this.listOfInstallations.set(i, installation);
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
        for (int i = 0; i < this.listOfInstallations.size(); i++) {
            if (this.listOfInstallations.get(i).getID().equals(id)) {
                this.listOfInstallations.remove(i);
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
        this.listOfInstallations = new ArrayList<>();
    }

    /**
     * Percorre a lista e retorna o preço de todos os serviços do tipo "installation" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Preço de todos os serviços do tipo "installation" de uma ordem de serviço
     */
    @Override
    public double getPriceByServices(String workOrderID) {
        double servicesPrice = 0;
        for (Installation installation : this.listOfInstallations) {
            if(installation.getWorkOrderID().equals(workOrderID)) {
                servicesPrice += installation.getPrice();
            }
        }
        return servicesPrice;
    }

    /**
     * Percorre a lista e retorna o custo de todos os serviços do tipo "installation" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Custo de todos os serviços do tipo "installation" de uma ordem de serviço
     */
    @Override
    public double getCostByServices(String workOrderID) {
        double servicesCost = 0;
        for (Installation installation : this.listOfInstallations) {
            if(installation.getWorkOrderID().equals(workOrderID)) {
                servicesCost += installation.getCost();
            }
        }
        return servicesCost;
    }
}
