package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Building;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class BuildingImplementationTest {

    private Building building1;
    private Building building2;

    @BeforeEach
    public void setUp() {
        building1 = DAO.getBuilding().create(new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00));
        building2 = DAO.getBuilding().create(new Building("Switch the CPU", "c28c7bbe-dd45-11ed", 300.00, 120.00));
    }

    @AfterEach
    public void tearDown() {
        DAO.getBuilding().deleteMany();
    }

    @Test
    public void testCreate() {
        Building actual = DAO.getBuilding().create(new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00));
        Building expected = DAO.getBuilding().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<Building> buildingList = DAO.getBuilding().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, buildingList.size());
    }

    @Test
    public void testFindByID() {
        Building actual1 = DAO.getBuilding().findByID(building1.getID());
        assertEquals(building1, actual1);

        Building actual2 = DAO.getBuilding().findByID(building2.getID());
        assertEquals(building2, actual2);
    }

    @Test
    public void testFindByWorkOrderID() {
        List<Building> actual1 = DAO.getBuilding().findByWorkOrderID(building1.getWorkOrderID());
        assertEquals(building1, actual1.get(0));

        List<Building> actual2 = DAO.getBuilding().findByWorkOrderID(building2.getWorkOrderID());
        assertEquals(building2, actual2.get(1));
    }

    @Test
    public void testUpdate() {
        Building newBuilding1 = DAO.getBuilding().create(new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00));
        newBuilding1.setID(building1.getID());

        try {
            DAO.getBuilding().update(newBuilding1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newBuilding1, DAO.getBuilding().findByID(building1.getID()));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getBuilding().delete(building1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<Building> buildingList = DAO.getBuilding().findMany();
        int expectedLength = 1;
        assertEquals(1, buildingList.size());
        assertEquals(building2, buildingList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getBuilding().deleteMany();
        List<Building> buildingList = DAO.getBuilding().findMany();
        assertEquals(0, buildingList.size());
    }

    @Test
    public void testGetPriceByServices() {
        double actual = DAO.getBuilding().getPriceByServices("c28c7bbe-dd45-11ed");
        assertEquals(370.0, actual);
    }

    @Test
    public void testGetCostByServices() {
        double actual = DAO.getBuilding().getCostByServices("c28c7bbe-dd45-11ed");
        assertEquals(145.0, actual);
    }
}