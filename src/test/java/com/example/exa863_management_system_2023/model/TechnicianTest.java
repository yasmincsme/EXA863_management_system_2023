package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TechnicianTest{

    @Test
    public void testConstructor() {
        Technician technician = new Technician("Matthew Delgado", "math.delgado@example.com", "mathDelgado", "password123");

        assertNull(technician.getID());
        assertEquals("Matthew Delgado", technician.getName());
        assertEquals("math.delgado@example.com", technician.getEmail());
        assertEquals("mathDelgado", technician.getLogin());
        assertEquals("password123", technician.getPassword());
    }

    @Test
    public void testEquals() {
        Technician technician1 = new Technician("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123");
        technician1.setID("a908ffa4-dd37-11ed");
        Technician technician2 = new Technician("Jane Doe", "jane.doe@example.com", "janeDoe", "password123");
        technician2.setID("ed198b64-dd37-11ed");
        Technician technician3 = new Technician("John Smith", "john.smith@example.com", "johnSmith", "password123");
        technician3.setID("a908ffa4-dd37-11ed");


        //Verify that two clients with the same ID are equal
        assertEquals(technician1, technician3);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(technician1, technician2);

        //Null object
        assertNotEquals(null, technician1);

        //Same object
        assertEquals(technician1, technician1);
        assertEquals(technician2, technician2);
        assertEquals(technician3, technician3);
    }

    @Test
    public void testToString() {
        Technician technician = new Technician("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123");
        technician.setID("a908ffa4-dd37-11ed");
        String expected = "Role: TECHNICIAN, ID: a908ffa4-dd37-11ed, Name: Lionel Craig, Email: lionel.craig@example.com, Login: lionelCraig, Password: password123";
        String actual = technician.toString();
        assertEquals(expected, actual);
    }
}