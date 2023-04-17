package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testConstructor() {
        Client client = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");

        assertEquals("Matthew Delgado", client.getName());
        assertEquals("matthew.delgado@example.com", client.getEmail());
        assertEquals("Belmont, California(CA), 94002", client.getAddress());
        assertEquals("(262) 633-9393", client.getPhone());
    }

    @Test
    public void testEquals() {
        Employee employee1 = new Employee("John Smith", "john.smith@example.com", "johnsmith", "password");
        employee1.setID("EMPL001");
        Employee employee2 = new Employee("Jane Doe", "jane.doe@example.com", "janedoe", "password");
        employee2.setID("EMPL002");
        Employee employee3 = new Employee("John Smith", "john.smith@example.com", "johnsmith", "password");
        employee3.setID("EMPL001");
        Employee employee4 = new Employee("John Smith", "john.smith@example.com", "johndoe", "password");
        employee4.setID("EMPL004");

        // Verify that two employees with the same ID are equal
        assertEquals(employee1, employee3);

        // Verify that two employees with different IDs are not equal
        assertNotEquals(employee1, employee2);

        // same name and email, but different login ID
        assertNotEquals(employee1, employee4);

        // Null object
        assertNotEquals(null, employee1);
    }

    @Test
    public void testToString() {
        Client client = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        client.setID("6e056406-dc97-11ed");
        String expected = "ID: 6e056406-dc97-11ed, Name: Matthew Delgado, Email: matthew.delgado@example.com, Address: Belmont, California(CA), 94002, Phone: (262) 633-9393";
        String actual = client.toString();
        assertEquals(expected, actual);
    }
}