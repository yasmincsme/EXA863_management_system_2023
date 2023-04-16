package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.model.Cleaning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CleaningListImplementationTest {

    private CleaningDAO cleaningDAO;
    private Cleaning cleaning;

    @BeforeEach
    void setUp() {
        cleaningDAO = new CleaningListImplementation();
        cleaning = new Cleaning("Bathroom cleaning");
    }

    @Test
    void createTest() {
        cleaningDAO.create(cleaning);
        Cleaning createdCleaning = cleaningDAO.findByID(cleaning.getID());
        assertEquals(cleaning, createdCleaning);
    }

    @Test
    void findManyTest() {
        List<Cleaning> cleaningList = new ArrayList<>();
        cleaningList.add(cleaning);
        cleaningDAO.create(cleaning);
        List<Cleaning> foundCleaningList = cleaningDAO.findMany();
        assertEquals(cleaningList, foundCleaningList);
    }

    @Test
    void findByIDTest() {
        cleaningDAO.create(cleaning);
        Cleaning foundCleaning = cleaningDAO.findByID(cleaning.getID());
        assertEquals(cleaning, foundCleaning);
    }

    @Test
    void updateTest() throws Exception {
        cleaningDAO.create(cleaning);
        cleaning.setName("Kitchen cleaning");
        cleaningDAO.update(cleaning);
        Cleaning updatedCleaning = cleaningDAO.findByID(cleaning.getID());
        assertEquals(cleaning, updatedCleaning);
    }

    @Test
    void deleteTest() {
        cleaningDAO.create(cleaning);
        cleaningDAO.delete(cleaning.getID());
        Cleaning deletedCleaning = cleaningDAO.findByID(cleaning.getID());
        assertNull(deletedCleaning);
    }

    @Test
    void deleteManyTest() {
        cleaningDAO.create(cleaning);
        cleaningDAO.deleteMany();
        List<Cleaning> foundCleaningList = cleaningDAO.findMany();
        assertEquals(new ArrayList<Cleaning>(), foundCleaningList);
    }
}
