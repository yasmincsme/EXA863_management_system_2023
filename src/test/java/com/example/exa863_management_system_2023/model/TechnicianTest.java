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
    public void testToString() {
        Technician technician = new Technician("John Doe", "john.doe@example.com", "johnDoe", "password");
        technician.setID("915e9532-dc9f-11ed");
        String expected = "ID: 915e9532-dc9f-11ed, Name: John Doe, Email: john.doe@example.com, Login: johnDoe, Password: password, Role: Technician";
        String actual = technician.toString();
        assertEquals(expected, actual);
    }
}
