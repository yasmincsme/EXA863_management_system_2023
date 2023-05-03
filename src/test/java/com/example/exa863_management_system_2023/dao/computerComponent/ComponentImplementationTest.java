package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class ComponentImplementationTest {

    private ComputerComponent component1;
    private ComputerComponent component2;

    @BeforeEach
    public void setUp() {
        component1 = DAO.getComponent().create(new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 5));
        component2 = DAO.getComponent().create(new ComputerComponent("RAM", "Intel", "XYZ456", 300.60, 259.00, 2));
    }

    @AfterEach
    public void tearDown() {
        DAO.getComponent().deleteMany();
    }

    @Test
    public void testCreate() {
        ComputerComponent actual = DAO.getComponent().create(new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 5));
        ComputerComponent expected = DAO.getComponent().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<ComputerComponent> componentList = DAO.getComponent().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, componentList.size());
    }

    @Test
    public void testFindByID() {
        ComputerComponent actual1 = DAO.getComponent().findByID(component1.getID());
        assertEquals(component1, actual1);

        ComputerComponent actual2 = DAO.getComponent().findByID(component2.getID());
        assertEquals(component2, actual2);
    }

    @Test
    public void testFindByName() {
        List<ComputerComponent> actual1 = DAO.getComponent().findByName(component1.getName());
        assertEquals(component1, actual1.get(0));

        List<ComputerComponent> actual2 = DAO.getComponent().findByName(component2.getName());
        assertEquals(component2, actual2.get(0));
    }

    @Test
    public void testUpdate() {
        String componentID = component1.getID();
        ComputerComponent newComponent1 = DAO.getComponent().create(new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 0));
        newComponent1.setID(componentID);

        try {
            DAO.getComponent().update(newComponent1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newComponent1, DAO.getComponent().findByID(componentID));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getComponent().delete(component1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<ComputerComponent> componentList = DAO.getComponent().findMany();
        int expectedLength = 1;
        assertEquals(1, componentList.size());
        assertEquals(component2, componentList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getComponent().deleteMany();
        List<ComputerComponent> componentList = DAO.getComponent().findMany();
        assertEquals(0, componentList.size());
    }
}