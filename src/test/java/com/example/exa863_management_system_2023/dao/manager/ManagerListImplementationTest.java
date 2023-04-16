package com.example.exa863_management_system_2023.dao.manager;

import static org.junit.jupiter.api.Assertions.*;

import com.example.exa863_management_system_2023.model.Manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ManagerListImplementationTest {

    private ManagerDAO managerDAO;

    @BeforeEach
    public void setUp() {
        managerDAO = new ManagerListImplementation();
    }

    @Test
    public void testCreate() {
        Manager manager = new Manager("1", "manager1", "password1");
        Manager createdManager = managerDAO.create(manager);

        assertEquals(manager, createdManager, "Created manager should match original manager");
    }

    @Test
    public void testFindMany() {
        Manager manager1 = new Manager("1", "manager1", "password1");
        Manager manager2 = new Manager("2", "manager2", "password2");
        managerDAO.create(manager1);
        managerDAO.create(manager2);

        List<Manager> managers = managerDAO.findMany();

        assertTrue(managers.contains(manager1), "Manager list should contain manager1");
        assertTrue(managers.contains(manager2), "Manager list should contain manager2");
    }

    @Test
    public void testFindByID() {
        Manager manager1 = new Manager("1", "manager1", "password1");
        Manager manager2 = new Manager("2", "manager2", "password2");
        managerDAO.create(manager1);
        managerDAO.create(manager2);

        Manager foundManager = managerDAO.findByID("1");

        assertEquals(manager1, foundManager, "Found manager should match original manager1");
    }

    @Test
    public void testFindByLogin() {
        Manager manager1 = new Manager("1", "manager1", "password1");
        Manager manager2 = new Manager("2", "manager2", "password2");
        Manager manager3 = new Manager("3", "manager1", "password3");
        managerDAO.create(manager1);
        managerDAO.create(manager2);
        managerDAO.create(manager3);

        List<Manager> managers = managerDAO.findByLogin("manager1");

        assertTrue(managers.contains(manager1), "Manager list should contain manager1");
        assertFalse(managers.contains(manager2), "Manager list should not contain manager2");
        assertTrue(managers.contains(manager3), "Manager list should contain manager3");
    }

    @Test
    public void testUpdate() {
        Manager manager = new Manager("1", "manager1", "password1");
        managerDAO.create(manager);

        Manager updatedManager = new Manager("1", "updatedManager1", "updatedPassword1");
        managerDAO.update(updatedManager);

        Manager foundManager = managerDAO.findByID("1");
        assertEquals(updatedManager, foundManager, "Found manager should match updated manager");
    }

    @Test
    public void testDelete() {
        Manager manager = new Manager("1", "manager1", "password1");
        managerDAO.create(manager);

        managerDAO.delete("1");

        Manager foundManager = managerDAO.findByID("1");
        assertNull(foundManager, "Deleted manager should not be found");
    }

    @Test
    public void testDeleteMany() {
        Manager manager1 = new Manager("1", "manager1", "password1");
        Manager manager2 = new Manager("2", "manager2", "password2");
        managerDAO.create(manager1);
        managerDAO.create(manager2);

        managerDAO.deleteMany();

        List<Manager> managers = managerDAO.findMany();

