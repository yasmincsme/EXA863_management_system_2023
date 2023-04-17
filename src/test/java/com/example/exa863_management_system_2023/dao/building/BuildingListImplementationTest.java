package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.model.Building;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildingListImplementationTest {

    private BuildingDAO buildingDAO;
    private List<Building> buildings;

    @BeforeEach
    void setUp() {
        buildingDAO = new BuildingListImplementation();
        buildings = new ArrayList<>();
    }

    @Test
    void testCreate() {
        Building building1 = new Building("Change de Hard Disk", "Safely remove the old hard disk and install a new one", 120, 60);
        building1.setID("68e7e64c-dd4b-11ed");
        Building createdBuilding1 = buildingDAO.create(building1);
        assertNotNull(createdBuilding1.getID());
        assertEquals(building1.getID(), createdBuilding1.getID());
        assertEquals(building1.getName(), createdBuilding1.getName());
        assertEquals(building1.getDescription(), createdBuilding1.getDescription());
        assertEquals(building1.getPrice(), createdBuilding1.getPrice());
        assertEquals(building1.getCost(), createdBuilding1.getCost());

        buildings.add(createdBuilding1);

        Building building2 = new Building("RAM Upgrade", "Install additional RAM modules to increase memory capacity", 60, 30);
        building1.setID("72980f1e-dd4b-11ed");
        Building createdBuilding2 = buildingDAO.create(building2);
        assertNotNull(createdBuilding2.getID());
        assertEquals(building2.getID(), createdBuilding2.getID());
        assertEquals(building2.getName(), createdBuilding2.getName());
        assertEquals(building2.getDescription(), createdBuilding2.getDescription());
        assertEquals(building2.getPrice(), createdBuilding2.getPrice());
        assertEquals(building2.getCost(), createdBuilding2.getCost());

        buildings.add(createdBuilding2);

        // Test creating a building with a null argument and ensure it throws an exception.
        assertThrows(NullPointerException.class, () -> buildingDAO.create(null));
    }

    @Test
    void testFindMany() {
        // Test finding all buildings in the list of buildings.
        List<Building> foundBuildings = buildingDAO.findMany();
        assertTrue(foundBuildings.isEmpty());

        // Test finding many buildings and ensure the returned list contains all of them.
        Building building1 = new Building("Change de Hard Disk", "Safely remove the old hard disk and install a new one", 120, 60);
        Building createdBuilding1 = buildingDAO.create(building1);
        buildings.add(createdBuilding1);
        Building building2 = new Building("RAM Upgrade", "Install additional RAM modules to increase memory capacity", 60, 30);
        Building createdBuilding2 = buildingDAO.create(building2);
        buildings.add(createdBuilding2);
        foundBuildings = buildingDAO.findMany();
        assertEquals(2, foundBuildings.size());
        assertTrue(foundBuildings.containsAll(buildings));

        // Test finding buildings when the list is empty and ensure it returns an empty list.
        buildingDAO.deleteMany();
        foundBuildings = buildingDAO.findMany();
        assertTrue(foundBuildings.isEmpty());
    }

    @Test
    void testFindByID() {
        Building building1 = new Building("Change Hard Disk", "Safely remove the old hard disk and install a new one", 120, 60);
        Building createdBuilding1 = buildingDAO.create(building1);
        buildings.add(createdBuilding1);
        Building building2 = new Building("RAM Upgrade", "Install additional RAM modules to increase memory capacity", 60, 30);
        Building createdBuilding2 = buildingDAO.create(building2);
        buildings.add(createdBuilding2);

        // Test finding a building by its ID and ensure it returns the correct building.
        Building foundBuilding1 = buildingDAO.findByID(createdBuilding1.getID());
        assertEquals(createdBuilding1, foundBuilding1);

        // Test finding a building that does not exist and ensure it returns null.
        Building foundBuilding3 = buildingDAO.findByID("invalid_id");
        assertNull(foundBuilding3);
    }

    // Test update() method updates an existing building
    @Test
    public void testUpdate() throws Exception {
        BuildingDAO buildingDAO1 = new BuildingListImplementation();
        Building building = new Building("RAM Upgrade", "Install additional RAM modules to increase memory capacity", 60, 30);
        building.setID("68e7e64c-dd4b-11ed");
        buildingDAO1.create(building);

        Building updatedBuilding = new Building("Change Hard Disk", "Safely remove the old hard disk and install a new one", 200, 100);
        updatedBuilding.setID("68e7e64c-dd4b-11ed");

        buildingDAO1.update(updatedBuilding);

        assertEquals(updatedBuilding, buildingDAO1.findByID("68e7e64c-dd4b-11ed"));
    }

    // Test delete() method removes an existing building
    @Test
    public void testDelete() throws Exception {
        BuildingDAO buildingDAO = new BuildingListImplementation();
        Building building = new Building("RAM Upgrade", "Install additional RAM modules to increase memory capacity", 60, 30);
        Building createdBuilding = buildingDAO.create(building);
        buildingDAO.delete(createdBuilding.getID());
        Building foundBuilding = buildingDAO.findByID(createdBuilding.getID());
        assertNull(foundBuilding);
    }

    // Test deleteMany() method removes all buildings from the list
    @Test
    public void testDeleteMany() {
        BuildingDAO buildingDAO = new BuildingListImplementation();
        buildingDAO.create(new Building("RAM Upgrade", "Install additional RAM modules to increase memory capacity", 60, 30));
        buildingDAO.create(new Building("Install Hard Disk", "Safely remove the old hard disk and install a new one", 200, 100));
        buildingDAO.deleteMany();
        List<Building> buildings = buildingDAO.findMany();
        assertEquals(0, buildings.size());
    }
}