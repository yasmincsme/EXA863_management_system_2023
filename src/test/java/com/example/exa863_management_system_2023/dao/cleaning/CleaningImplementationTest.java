package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Cleaning;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CleaningImplementationTest {

    private Cleaning cleaning1;
    private Cleaning cleaning2;

    @BeforeEach
    public void setUp() {
        cleaning1 = DAO.getCleaning().create(new Cleaning("CPU cooler cleaning", "f28c7bbe-dd45-11ed", 70.00, 25.00));
        cleaning2 = DAO.getCleaning().create(new Cleaning("Clean keyboard", "f28c7bbe-dd45-11ed", 35.00, 5.00));
    }

    @AfterEach
    public void tearDown() {
        DAO.getCleaning().deleteMany();
    }

    @Test
    public void testCreate() {
        Cleaning actual = DAO.getCleaning().create(new Cleaning("Clean keyboard", "f28c7bbe-dd45-11ed", 35.00, 5.00));
        Cleaning expected = DAO.getCleaning().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<Cleaning> cleaningList = DAO.getCleaning().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, cleaningList.size());
    }

    @Test
    public void testFindByID() {
        Cleaning actual1 = DAO.getCleaning().findByID(cleaning1.getID());
        assertEquals(cleaning1, actual1);

        Cleaning actual2 = DAO.getCleaning().findByID(cleaning2.getID());
        assertEquals(cleaning2, actual2);
    }

    @Test
    public void testFindByWorkOrderID() {
        List<Cleaning> actual1 = DAO.getCleaning().findByWorkOrderID(cleaning1.getWorkOrderID());
        assertEquals(cleaning1, actual1.get(0));

        List<Cleaning> actual2 = DAO.getCleaning().findByWorkOrderID(cleaning2.getWorkOrderID());
        assertEquals(cleaning2, actual2.get(1));
    }

    @Test
    public void testUpdate() {
        Cleaning newCleaning1 = DAO.getCleaning().create(new Cleaning("CPU cooler cleaning", "f28c7bbe-dd45-11ed", 70.00, 25.00));
        newCleaning1.setID(cleaning1.getID());

        try {
            DAO.getCleaning().update(newCleaning1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newCleaning1, DAO.getCleaning().findByID(cleaning1.getID()));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getCleaning().delete(cleaning1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<Cleaning> cleaningList = DAO.getCleaning().findMany();
        int expectedLength = 1;
        assertEquals(1, cleaningList.size());
        assertEquals(cleaning2, cleaningList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getCleaning().deleteMany();
        List<Cleaning> cleaningList = DAO.getCleaning().findMany();
        assertEquals(0, cleaningList.size());
    }

    @Test
    public void testGetPriceByServices() {
        double actual = DAO.getCleaning().getPriceByServices("f28c7bbe-dd45-11ed");
        assertEquals(105.0, actual);
    }

    @Test
    public void testGetCostByServices() {
        double actual = DAO.getCleaning().getCostByServices("f28c7bbe-dd45-11ed");
        assertEquals(30.0, actual);
    }
}