package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest{

    @Test
    public void testConstructor() {
        Employee employee = new Employee("Julia Ortega", "julia.ortega@example.com", "juliaOrtega", "password");

        assertEquals("Julia Ortega", employee.getName());
        assertEquals("julia.ortega@example.com", employee.getEmail());
        assertEquals("juliaOrtega", employee.getLogin());
        assertEquals("password", employee.getPassword());
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
        Employee employee = new Employee("Julia Ortega", "julia.ortega@example.com", "juliaOrtega", "password");
        employee.setID("5a071186-dc9f-11ed");
        String expected = "ID: 5a071186-dc9f-11ed, Name: Julia Ortega, Email: julia.ortega@example.com, Login: juliaOrtega, Password: password, Role: Employee";
        String actual = employee.toString();
        assertEquals(expected, actual);
    }
}