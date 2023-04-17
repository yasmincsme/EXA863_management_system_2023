package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public void testConstructor() {
        Manager manager = new Manager("Jenna Mars", "jenna.mars@example.com", "jenMars", "password");

        assertEquals("Jenna Mars", manager.getName());
        assertEquals("jenna.mars@example.com", manager.getEmail());
        assertEquals("jenMars", manager.getLogin());
        assertEquals("password", manager.getPassword());
    }

    @Test
    public void testEquals() {
        Manager manager1 = new Manager("John Smith", "john.smith@example.com", "johnsmith", "password");
        manager1.setID("7913cf6a-dd3a-11ed");
        Manager manager2 = new Manager("Jane", "jane.doe@example.com", "janedoe", "password");
        manager2.setID("84fc3fba-dd3a-11ed");
        Manager manager3 = new Manager("John Smith", "john.smith@example.com", "johnsmith", "password");
        manager3.setID("7913cf6a-dd3a-11ed");
        Manager manager4 = new Manager("John Smith", "john.smith@example.com", "johndoe", "password");
        manager4.setID("f89174f2-dd37-11ed");

        //Verify that two managers with the same ID are equal
        assertEquals(manager1, manager3);

        //Verify that two managers with different IDs are not equal
        assertNotEquals(manager1, manager2);
        assertNotEquals(manager1, manager4);

        //Same name and email,but different ID
        assertNotEquals(manager1, manager4);

        //Null object
        assertNotEquals(null, manager1);
    }

    @Test
    public void testToString() {
        Manager manager = new Manager("Jenna Mars", "jenna.mars@example.com", "jenMars", "password");
        manager.setID("6c5c766e-dc9f-11ed");
        String expected = "ID: 6c5c766e-dc9f-11ed, Name: Jenna Mars, Email: jenna.mars@example.com, Login: jenMars, Password: password, Role: Manager";
        String actual = manager.toString();
        assertEquals(expected, actual);
    }
}