package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TechnicianTest{

    @Test
    public void testConstructor() {
        Technician technician = new Technician( "John Doe", "john.doe@example.com", "johnDoe", "password");

        assertEquals("John Doe", technician.getName());
        assertEquals("john.doe@example.com", technician.getEmail());
        assertEquals("johnDoe", technician.getLogin());
        assertEquals("password", technician.getPassword());
    }

    @Test
    public void testEquals() {
        Technician technician1 = new Technician("John", "john@example.com", "john123", "password");
        technician1.setID("TECH001");
        Technician technician2 = new Technician("Mike", "mike@example.com", "mike123", "password");
        technician2.setID("TECH002");
        Technician technician3 = new Technician("John", "john@example.com", "john123", "password");
        technician3.setID("TECH001");

        // Verify that two technicians with the same ID are equal
        assertEquals(technician1, technician3);

        // Verify that two technicians with different IDs are not equal
        assertNotEquals(technician1, technician2);

        // Null object
        assertNotEquals(null, technician1);
    }
    @Test
    public void testToString() {
        Technician technician = new Technician("John Doe", "john.doe@example.com", "johnDoe", "password");
        technician.setID("915e9532-dc9f-11ed");
        String expected = "ID: 915e9532-dc9f-11ed, Name: John Doe, Email: john.doe@example.com, Login: johnDoe, Password: password, Role: Technician";
        String actual = technician.toString();
        assertEquals(expected, actual);
    }
}
