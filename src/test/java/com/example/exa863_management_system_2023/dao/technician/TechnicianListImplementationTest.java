package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.model.Technician;
import com.example.exa863_management_system_2023.model.User;
import com.example.exa863_management_system_2023.model.WorkOrder;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TechnicianListImplementationTest {

    private static TechnicianDAO technicianDAO;

    @BeforeAll
    static void setUp() {
        technicianDAO = new TechnicianListImplementation();
    }

    @BeforeEach
    void init() {
        technicianDAO.deleteMany();
    }

    @Test
    void testCreate() {
        Technician technician = new Technician("John Doe");
        technician = technicianDAO.create(technician);

        assertNotNull(technician.getID());
        assertEquals("John Doe", technician.getName());
        assertNull(technician.getWorkorder());
    }

    @Test
    void testFindMany() {
        Technician technician1 = new Technician("John Doe");
        Technician technician2 = new Technician("Jane Smith");

        technicianDAO.create(technician1);
        technicianDAO.create(technician2);

        List<Technician> technicians = technicianDAO.findMany();
        assertEquals(2, technicians.size());
        assertTrue(technicians.contains(technician1));
        assertTrue(technicians.contains(technician2));
    }

    @Test
    void testFindByID() {
        Technician technician1 = new Technician("John Doe");
        Technician technician2 = new Technician("Jane Smith");

        technicianDAO.create(technician1);
        technicianDAO.create(technician2);

        Technician foundTechnician = technicianDAO.findByID(technician1.getID());
        assertEquals(technician1, foundTechnician);
    }

    @Test
    void testFindByName() {
        Technician technician1 = new Technician("John Doe");
        Technician technician2 = new Technician("Jane Smith");

        technicianDAO.create(technician1);
        technicianDAO.create(technician2);

        List<Technician> technicians = technicianDAO.findByName("John Doe");
        assertEquals(1, technicians.size());
        assertTrue(technicians.contains(technician1));
    }

    @Test
    void testUpdate() throws Exception {
        Technician technician = new Technician("John Doe");
        technicianDAO.create(technician);

        technician.setWorkOrder(new WorkOrder("WO001", "Repair printer", new User("Alice")));
        technicianDAO.update(technician);

        Technician updatedTechnician = technicianDAO.findByID(technician.getID());
        assertNotNull(updatedTechnician.getWorkorder());
        assertEquals("WO001", updatedTechnician.getWorkorder().getID());
        assertEquals("Repair printer", updatedTechnician.getWorkorder().getDescription());
        assertEquals("Alice", updatedTechnician.getWorkorder().getAssignee().getName());
    }

    @Test
    void testDelete() throws Exception {
        Technician technician1 = new Technician("John Doe");
        Technician technician2 = new Technician("Jane Smith");

        technicianDAO.create(technician1);
        technicianDAO.create(technician2);

        technicianDAO.delete(technician1.getID());

        assertNull(technicianDAO.findByID(technician1.getID()));
        assertNotNull(technicianDAO.findByID(technician2.getID()));
    }

    @Test
    void testDeleteMany() {
        Technician technician1 = new Technician("John Doe");
        Technician technician2 = new Technician("Jane Smith");

        technicianDAO.create(technician1);
        technicianDAO.create(technician2);

        technicianDAO.deleteMany();

