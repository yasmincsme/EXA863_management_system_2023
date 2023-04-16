package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.model.Installation;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstallationListImplementationTest {

    private InstallationDAO dao;

    @BeforeEach
    void setUp() {
        dao = new InstallationListImplementation();
    }

    @AfterEach
    void tearDown() {
        dao.deleteMany();
    }

    @Test
    void testCreate() {
        Installation installation = new Installation("Test Installation");
        installation.setPrograms(Arrays.asList("Program 1", "Program 2"));
        installation.setOperatingSystem("Windows 10");
        Installation createdInstallation = dao.create(installation);
        assertNotNull(createdInstallation.getID());
        assertEquals(installation.getName(), createdInstallation.getName());
        assertEquals(installation.getPrograms(), createdInstallation.getPrograms());
        assertEquals(installation.getOperatingSystem(), createdInstallation.getOperatingSystem());
    }

    @Test
    void testFindMany() {
        Installation installation1 = new Installation("Installation 1");
        Installation installation2 = new Installation("Installation 2");
        dao.create(installation1);
        dao.create(installation2);
        List<Installation> installations = dao.findMany();
        assertEquals(2, installations.size());
        assertTrue(installations.contains(installation1));
        assertTrue(installations.contains(installation2));
    }

    @Test
    void testFindByID() {
        Installation installation = new Installation("Test Installation");
        dao.create(installation);
        String id = installation.getID();
        Installation foundInstallation = dao.findByID(id);
        assertEquals(installation, foundInstallation);
    }

    @Test
    void testUpdate() throws Exception {
        Installation installation = new Installation("Test Installation");
        dao.create(installation);
        String id = installation.getID();
        Installation updatedInstallation = new Installation("Updated Installation");
        updatedInstallation.setID(id);
        updatedInstallation.setPrograms(Arrays.asList("Program 3", "Program 4"));
        updatedInstallation.setOperatingSystem("Windows 11");
        dao.update(updatedInstallation);
        Installation foundInstallation = dao.findByID(id);
        assertEquals(updatedInstallation, foundInstallation);
    }

    @Test
    void testDelete() throws Exception {
        Installation installation = new Installation("Test Installation");
        dao.create(installation);
        String id = installation.getID();
        dao.delete(id);
        assertNull(dao.findByID(id));
    }

    @Test
    void testDeleteMany() {
        Installation installation1 = new Installation("Installation 1");
        Installation installation2 = new Installation("Installation 2");
        dao.create(installation1);
        dao.create(installation2);
        dao.deleteMany();
        assertEquals(0, dao.findMany().size());
    }

}
