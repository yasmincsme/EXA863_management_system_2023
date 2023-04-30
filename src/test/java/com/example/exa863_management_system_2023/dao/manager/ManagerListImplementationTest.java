package com.example.exa863_management_system_2023.dao.manager;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Manager;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerListImplementationTest {
    private Manager manager1;
    private Manager manager2;

    @BeforeEach
    public void setUp() {
        manager1 = DAO.getManager().create(new Manager("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        manager2 = DAO.getManager().create(new Manager("Jane Doe", "jane.doe@example.com", "janeDoe", "password123"));
    }

    @AfterEach
    public void tearDown() {
        DAO.getManager().deleteMany();
    }

    @Test
    public void testCreate() {
        Manager actual = DAO.getManager().create(new Manager("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        Manager expected = DAO.getManager().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<Manager> managerList = DAO.getManager().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, managerList.size());
    }

    @Test
    public void testFindByID() {
        Manager actual1 = DAO.getManager().findByID(manager1.getID());
        assertEquals(manager1, actual1);

        Manager actual2 = DAO.getManager().findByID((manager2.getID()));
        assertEquals(manager2, actual2);
    }

    @Test
    public void testFindByLogin() {
        List<Manager> actual1 = DAO.getManager().findByLogin(manager1.getLogin());
        assertEquals(manager1, actual1.get(0));

        List<Manager> actual2 = DAO.getManager().findByLogin(manager2.getLogin());
        assertEquals(manager2, actual2.get(0));
    }

    @Test
    public void testUpdate() {
        Manager newManager1 = DAO.getManager().create(new Manager("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "newPassword123"));
        newManager1.setID(manager1.getID());

        try {
            DAO.getManager().update(newManager1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newManager1, DAO.getManager().findByID(manager1.getID()));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getManager().delete(manager1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<Manager> managerList = DAO.getManager().findMany();
        int expectedLength = 1;
        assertEquals(1, managerList.size());
        assertEquals(manager2, managerList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getManager().deleteMany();
        List<Manager> managerList = DAO.getManager().findMany();
        assertEquals(0, managerList.size());
    }
}