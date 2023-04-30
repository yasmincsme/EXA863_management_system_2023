package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Installation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstallationListImplementationTest {

    private Installation installation1;
    private Installation installation2;

    @BeforeEach
    public void setUp() {
        installation1 = DAO.getInstallation().create(new Installation("Install Windows 10", "c28c7bbe-dd45-11ed", 70.00, 25.00, "Windows 8"));
        installation2 = DAO.getInstallation().create(new Installation("Install Quartus", "c28c7bbe-dd45-11ed", 70.00, 25.00, "Xubuntu"));
    }

    @AfterEach
    public void tearDown() {
        DAO.getInstallation().deleteMany();
    }

    @Test
    public void testCreate() {
        Installation actual = DAO.getInstallation().create(new Installation("Install Windows 10", "f28c7bbe-dd45-11ed", 70.00, 25.00, "Windows 8"));
        Installation expected = DAO.getInstallation().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<Installation> installationList = DAO.getInstallation().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, installationList.size());
    }

    @Test
    public void testFindByID() {
        Installation actual1 = DAO.getInstallation().findByID(installation1.getID());
        assertEquals(installation1, actual1);

        Installation actual2 = DAO.getInstallation().findByID(installation2.getID());
        assertEquals(installation2, actual2);
    }

    @Test
    public void testFindByWorkOrderID() {
        List<Installation> actual1 = DAO.getInstallation().findByWorkOrderID(installation1.getWorkOrderID());
        assertEquals(installation1, actual1.get(0));

        List<Installation> actual2 = DAO.getInstallation().findByWorkOrderID(installation2.getWorkOrderID());
        assertEquals(installation2, actual2.get(1));
    }

    @Test
    public void testUpdate() {
        Installation newInstallation1 = DAO.getInstallation().create(new Installation("Install Windows 10", "f28c7bbe-dd45-11ed", 70.00, 25.00, "Windows 8"));
        newInstallation1.setID(installation1.getID());

        try {
            DAO.getInstallation().update(newInstallation1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newInstallation1, DAO.getInstallation().findByID(installation1.getID()));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getInstallation().delete(installation1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<Installation> installationList = DAO.getInstallation().findMany();
        int expectedLength = 1;
        assertEquals(1, installationList.size());
        assertEquals(installation2, installationList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getInstallation().deleteMany();
        List<Installation> installationList = DAO.getInstallation().findMany();
        assertEquals(0, installationList.size());
    }

    @Test
    public void testGetPriceByServices() {
        double actual = DAO.getInstallation().getPriceByServices(installation1.getWorkOrderID());
        assertEquals(140.0, actual);
    }

    @Test
    public void testGetCostByServices() {
        double actual = DAO.getInstallation().getCostByServices("c28c7bbe-dd45-11ed");
        assertEquals(50.0, actual);
    }
}