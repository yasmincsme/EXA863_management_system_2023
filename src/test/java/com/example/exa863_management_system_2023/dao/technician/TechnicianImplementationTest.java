package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Technician;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TechnicianImplementationTest {
    private Technician technician1;
    private Technician technician2;

    @BeforeEach
    public void setUp() {
        technician1 = DAO.getTechnician().create(new Technician("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        technician2 = DAO.getTechnician().create(new Technician("Jane Doe", "jane.doe@example.com", "janeDoe", "password123"));
    }

    @AfterEach
    public void tearDown() {
        DAO.getTechnician().deleteMany();
    }

    @Test
    public void testCreate() {
        Technician actual = DAO.getTechnician().create(new Technician("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        Technician expected = DAO.getTechnician().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<Technician> technicianList = DAO.getTechnician().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, technicianList.size());
    }

    @Test
    public void testFindByID() {
        Technician actual1 = DAO.getTechnician().findByID(technician1.getID());
        assertEquals(technician1, actual1);

        Technician actual2 = DAO.getTechnician().findByID((technician2.getID()));
        assertEquals(technician2, actual2);
    }

    @Test
    public void testFindByName() {
        List<Technician> actual1 = DAO.getTechnician().findByName(technician1.getName());
        assertEquals(technician1, actual1.get(0));

        List<Technician> actual2 = DAO.getTechnician().findByName(technician2.getName());
        assertEquals(technician2, actual2.get(0));
    }

    @Test
    public void testUpdate() {
        String technician1ID = technician1.getID();
        Technician newTechnician1 = DAO.getTechnician().create(new Technician("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "newPassword123"));
        newTechnician1.setID(technician1ID);

        try {
            DAO.getTechnician().update(newTechnician1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newTechnician1, DAO.getTechnician().findByID(technician1ID));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getTechnician().delete(technician1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<Technician> technicianList = DAO.getTechnician().findMany();
        int expectedLength = 1;
        assertEquals(1, technicianList.size());
        assertEquals(technician2, technicianList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getTechnician().deleteMany();
        List<Technician> technicianList = DAO.getTechnician().findMany();
        assertEquals(0, technicianList.size());
    }
}