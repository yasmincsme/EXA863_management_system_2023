package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class BuildingListImplementation implements BuildingDAO {

    private List<Building> listOfBuildings;
    private String nextID;

    public BuildingListImplementation() {
        this.listOfBuildings = new ArrayList<Building>();
        this.nextID = Generator.generateID();
    }

    @Override
    public Building create(Building building) {
        building.setID(this.nextID);
        this.nextID = Generator.generateID();
        this.listOfBuildings.add(building);
        return building;
    }

    @Override
    public List<Building> findMany() {
        List<Building> buildingList = new ArrayList<Building>();
        for (Building building : this.listOfBuildings) {
            buildingList.add(building);
        }
        return buildingList;
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
    public void update(Building building) throws Exception {
        for (int i = 0; i < this.listOfBuildings.size(); i++) {
            if (this.listOfBuildings.get(i).getID().equals(building.getID())) {
                this.listOfBuildings.set(i, building);
                return;
            }
        }
    }

    @Override
    public void delete(String id) throws Exception {
        for (int i = 0; i < this.listOfBuildings.size(); i++) {
            if (this.listOfBuildings.get(i).getID().equals(id)) {
                this.listOfBuildings.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfBuildings = new ArrayList<>();
        this.nextID = null;
    }
}
