package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.model.Building;

import java.util.ArrayList;
import java.util.List;

public class BuildingListImplementation implements BuildingDAO {

    private List<Building> listOfBuilding;
    private int nextID;

    public BuildingListImplementation() {
        this.listOfBuilding = new ArrayList<Building>();
        this.nextID = 0;
    }

    @Override
    public Building create(Building building) {
        building.setId(this.nextID);
        this.nextID++;
        this.listOfBuilding.add(building);
        return building;
    }

    @Override
    public List<Building> findMany() {
        List<Building> buildingList = new ArrayList<Building>();
        for (Object building : this.listOfBuilding) {
            buildingList.add((Building) building);
        }
        return buildingList;
    }

    @Override
    public Building findByID(int id) {
        for (Building building : this.listOfBuilding) {
            if (building.getId() == id) {
                return building;
            }
        }
        return null;
    }

    @Override
    public void update(Building building) throws Exception {
        for (int i = 0; i < this.listOfBuilding.size(); i++) {
            this.listOfBuilding.set(i, building);
            return;
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.listOfBuilding.size(); i++) {
            if (this.listOfBuilding.get(i).getId() == id) {
                this.listOfBuilding.remove(i);
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfBuilding = new ArrayList<>();
        this.nextID = 0;
    }
}
