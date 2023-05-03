package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Installation;
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

    @Override
    public Building create(Building building) {
        building.setID(Generator.generateID());
        listOfBuildings.add(building);
        FileManager.writeListToFile(listOfBuildings, "buildings.dat");
        return building;
    }

    @Override
    public List<Building> findMany() {
        return FileManager.readListFromFile("buildings.dat");
    }

    @Override
    public Building findByID(String id) {
        for (Building building : this.listOfBuildings) {
            if (building.getID().equals(id)) {
                return building;
            }
        }
        return null;
    }

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

    @Override
    public void deleteMany() {
        listOfBuildings = new ArrayList<>();
        FileManager.writeListToFile(listOfBuildings, "buildings.dat");
    }

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
