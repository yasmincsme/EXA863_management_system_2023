package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.model.Building;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class BuildingListImplementation implements BuildingDAO {

    private List<Building> listOfBuilding;
    private String nextID;

    public BuildingListImplementation() {
        this.listOfBuilding = new ArrayList<Building>();
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
    }

    @Override
    public Building create(Building building) {
        building.setID(this.nextID);
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
        this.listOfBuilding.add(building);
        return building;
    }

    @Override
    public List<Building> findMany() {
        List<Building> buildingList = new ArrayList<Building>();
        for (Building building : this.listOfBuilding) {
            buildingList.add(building);
        }
        return buildingList;
    }

    @Override
    public Building findByID(String id) {
        for (Building building : this.listOfBuilding) {
            if (building.getID().equals(id)) {
                return building;
            }
        }
        return null;
    }

    @Override
    public void update(Building building) throws Exception {
        for (int i = 0; i < this.listOfBuilding.size(); i++) {
            if (this.listOfBuilding.get(i).getID().equals(building.getID())) {
                this.listOfBuilding.set(i, building);
                return;
            }
        }
    }

    @Override
    public void delete(String id) throws Exception {
        for (int i = 0; i < this.listOfBuilding.size(); i++) {
            if (this.listOfBuilding.get(i).getID().equals(id)) {
                this.listOfBuilding.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfBuilding = new ArrayList<>();
        this.nextID = null;
    }
}
