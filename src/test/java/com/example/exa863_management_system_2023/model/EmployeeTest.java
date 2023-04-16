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
    public void testToString() {
        Employee employee = new Employee("Julia Ortega", "julia.ortega@example.com", "juliaOrtega", "password");
        employee.setID("5a071186-dc9f-11ed");
        String expected = "ID: 5a071186-dc9f-11ed, Name: Julia Ortega, Email: julia.ortega@example.com, Login: juliaOrtega, Password: password, Role: Employee";
        String actual = employee.toString();
        assertEquals(expected, actual);
    }
}