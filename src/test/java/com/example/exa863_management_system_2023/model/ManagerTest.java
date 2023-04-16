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
    public void testToString() {
        Manager manager = new Manager("Jenna Mars", "jenna.mars@example.com", "jenMars", "password");
        manager.setID("6c5c766e-dc9f-11ed");
        String expected = "ID: 6c5c766e-dc9f-11ed, Name: Jenna Mars, Email: jenna.mars@example.com, Login: jenMars, Password: password, Role: Manager";
        String actual = manager.toString();
        assertEquals(expected, actual);
    }
}