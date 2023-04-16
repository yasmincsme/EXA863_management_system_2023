package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BuildingListImplementationTest {

    private BuildingDAO buildingDAO;
    private Building building1;
    private Building building2;

    @BeforeEach
    void setUp() {
        buildingDAO = new BuildingListImplementation();
        building1 = new Building("Building 1");
        building2 = new Building("Building 2");
    }

    @AfterEach
    void tearDown() {
        buildingDAO.deleteMany();
    }

    @Test
    void testCreate() {
        assertNull(building1.getID());
        building1 = buildingDAO.create(building1);
        assertNotNull(building1.getID());
        assertEquals(building1, buildingDAO.findByID(building1.getID()));
    }

    @Test
    void testFindMany() {
        assertTrue(buildingDAO.findMany().isEmpty());

        buildingDAO.create(building1);
        buildingDAO.create(building2);

        List<Building> buildingList = buildingDAO.findMany();
        assertEquals(2, buildingList.size());
        assertTrue(buildingList.contains(building1));
        assertTrue(buildingList.contains(building2));
    }

    @Test
    void testFindByID() {
        assertNull(buildingDAO.findByID("non-existing-id"));

        buildingDAO.create(building1);
        buildingDAO.create(building2);

        assertEquals(building1, buildingDAO.findByID(building1.getID()));
        assertEquals(building2, buildingDAO.findByID(building2.getID()));
    }

    @Test
    void testUpdate() throws Exception {
        buildingDAO.create(building1);

        String newBuildingName = "New Building Name";
        building1.setName(newBuildingName);

        buildingDAO.update(building1);
        assertEquals(newBuildingName, buildingDAO.findByID(building1.getID()).getName());
    }

    @Test
    void testDelete() throws Exception {
        buildingDAO.create(building1);

        buildingDAO.delete(building1.getID());
        assertNull(buildingDAO.findByID(building1.getID()));
    }

    @Test
    void testDeleteMany() {
        buildingDAO.create(building1);
        buildingDAO.create(building2);

        assertFalse(buildingDAO.findMany().isEmpty());

        buildingDAO.deleteMany();

        assertTrue(buildingDAO.findMany().isEmpty());
    }

    @Test
    void testSetAndGetUsedComponents() {
        List<ComputerComponent> components = new ArrayList<>();
        ComputerComponent component1 = new ComputerComponent("Component 1");
        ComputerComponent component2 = new ComputerComponent("Component 2");
        components.add(component1);
        components.add(component2);

        building1.setUsedComponents(components);
        assertEquals(components, building1.getUsedComponents());
    }
}
