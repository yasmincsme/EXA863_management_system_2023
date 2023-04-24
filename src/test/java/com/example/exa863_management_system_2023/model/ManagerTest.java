package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public void testConstructor() {
        Manager manager = new Manager("Matthew Delgado", "math.delgado@example.com", "mathDelgado", "password123");

        assertNull(manager.getID());
        assertEquals("Matthew Delgado", manager.getName());
        assertEquals("math.delgado@example.com", manager.getEmail());
        assertEquals("mathDelgado", manager.getLogin());
        assertEquals("password123", manager.getPassword());
    }

    @Test
    public void testEquals() {
        Manager manager1 = new Manager("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123");
        manager1.setID("a908ffa4-dd37-11ed");
        Manager manager2 = new Manager("Jane Doe", "jane.doe@example.com", "janeDoe", "password123");
        manager2.setID("ed198b64-dd37-11ed");
        Manager manager3 = new Manager("John Smith", "john.smith@example.com", "johnSmith", "password123");
        manager3.setID("a908ffa4-dd37-11ed");


        //Verify that two clients with the same ID are equal
        assertEquals(manager1, manager3);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(manager1, manager2);

        //Null object
        assertNotEquals(null, manager1);

        //Same object
        assertEquals(manager1, manager1);
        assertEquals(manager2, manager2);
        assertEquals(manager3, manager3);
    }

    @Test
    public void testToString() {
        Manager manager = new Manager("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123");
        manager.setID("a908ffa4-dd37-11ed");
        String expected = "Role: MANAGER, ID: a908ffa4-dd37-11ed, Name: Lionel Craig, Email: lionel.craig@example.com, Login: lionelCraig, Password: password123";
        String actual = manager.toString();
        assertEquals(expected, actual);
    }
}