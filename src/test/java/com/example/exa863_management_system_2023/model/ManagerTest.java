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
        Manager manager1 = new Manager("John", "john@example.com", "john123", "pass123");
        manager1.setID("MAN001");
        Manager manager2 = new Manager("Jane", "jane@example.com", "jane456", "pass456");
        manager2.setID("MAN002");
        Manager manager3 = new Manager("John", "john@example.com", "john789", "pass789");
        manager3.setID("MAN001");

        //Verify that two managers with the same ID are equal
        assertEquals(manager1, manager3);

        //Verify that two managers with different IDs are not equal
        assertNotEquals(manager1, manager2);
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