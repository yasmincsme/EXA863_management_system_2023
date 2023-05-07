package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class BuildingArchiveImplementation implements BuildingDAO {
    private List<Building> listOfBuildings;
    private FileManager<String> fileManager;

    public BuildingArchiveImplementation() {
        fileManager = new FileManager<>("buildings.dat");
        listOfBuildings = FileManager.readListFromFile("buildings.dat");
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param building Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public Building create(Building building) {
        building.setID(Generator.generateID());
        listOfBuildings.add(building);
        FileManager.writeListToFile(listOfBuildings, "buildings.dat");
        return building;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<Building> findMany() {
        return FileManager.readListFromFile("buildings.dat");
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public Building findByID(String id) {
        for (Building building : this.listOfBuildings) {
            if (building.getID().equals(id)) {
                return building;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna os serviços do tipo "building" que contém o ID da mesma ordem de serviço.
     * @param workOrderID ID da ordem de serviço
     * @return Lista com todos os serviços do tipo "building" que pertencem a uma mesma ordem de serviço
     */
    @Override
    public List<Building> findByWorkOrderID(String workOrderID) {
        List<Building> orderBuildingList = new ArrayList<>();
        for (Building building : this.listOfBuildings) {
            if (building.getWorkOrderID().equals(workOrderID)) {
                orderBuildingList.add(building);
            }
        }
        return orderBuildingList;
    }

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param building Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void update(Building building) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfBuildings.size(); i++) {
            if (this.listOfBuildings.get(i).getID().equals(building.getID())) {
                this.listOfBuildings.set(i, building);
                FileManager.writeListToFile(listOfBuildings, "buildings.dat");
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
        for (int i = 0; i < this.listOfBuildings.size(); i++) {
            if (listOfBuildings.get(i).getID().equals(id)) {
                listOfBuildings.remove(i);
                FileManager.writeListToFile(listOfBuildings, "buildings.dat");
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
        listOfBuildings = new ArrayList<>();
        FileManager.writeListToFile(listOfBuildings, "buildings.dat");
    }

    /**
     * Percorre a lista e retorna o preço de todos os serviços do tipo "building" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Preço de todos os serviços do tipo "building" de uma ordem de serviço
     */
    @Override
    public double getPriceByServices(String workOrderID) {
        double servicesPrice = 0;
        for (Building building : this.listOfBuildings) {
            if(building.getWorkOrderID().equals(workOrderID)) {
                servicesPrice += building.getPrice();
            }
        }
        return servicesPrice;
    }

    /**
     * Percorre a lista e retorna o custo de todos os serviços do tipo "building" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Custo de todos os serviços do tipo "building" de uma ordem de serviço
     */
    @Override
    public double getCostByServices(String workOrderID) {
        double servicesCost = 0;
        for (Building building : this.listOfBuildings) {
            if(building.getWorkOrderID().equals(workOrderID)) {
                servicesCost += building.getCost();
            }
        }
        return servicesCost;
    }
}
