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
        Technician technician1 = new Technician("John Smith", "john.smith@example.com", "johnsmith", "password");
        technician1.setID("a908ffa4-dd37-11ed");
        Technician technician2 = new Technician("Jane Doe", "jane.doe@example.com", "janedoe", "password");
        technician2.setID("ed198b64-dd37-11ed");
        Technician technician3 = new Technician("John Smith", "john.smith@example.com", "johnsmith", "password");
        technician3.setID("a908ffa4-dd37-11ed");
        Technician technician4 = new Technician("John Smith", "john.smith@example.com", "johndoe", "password");
        technician4.setID("f89174f2-dd37-11ed");

        //Verify that two technicians with the same ID are equal
        assertEquals(technician1, technician3);

        //Verify that two technicians with different IDs are not equal
        assertNotEquals(technician1, technician2);
        assertNotEquals(technician1, technician4);

        //Same name and email, but different ID
        assertNotEquals(technician1, technician4);

        //Null object
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
