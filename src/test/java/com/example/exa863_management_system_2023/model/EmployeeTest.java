package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest{

    @Test
    public void testConstructor() {
        Employee employee = new Employee("Matthew Delgado", "math.delgado@example.com", "mathDelgado", "password123");

        assertNull(employee.getID());
        assertEquals("Matthew Delgado", employee.getName());
        assertEquals("math.delgado@example.com", employee.getEmail());
        assertEquals("mathDelgado", employee.getLogin());
        assertEquals("password123", employee.getPassword());
    }

    @Test
    public void testEquals() {
        Employee employee1 = new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123");
        employee1.setID("a908ffa4-dd37-11ed");
        Employee employee2 = new Employee("Jane Doe", "jane.doe@example.com", "janeDoe", "password123");
        employee2.setID("ed198b64-dd37-11ed");
        Employee employee3 = new Employee("John Smith", "john.smith@example.com", "johnSmith", "password123");
        employee3.setID("a908ffa4-dd37-11ed");


        //Verify that two clients with the same ID are equal
        assertEquals(employee1, employee1);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(employee1, employee2);

        //Null object
        assertNotEquals(null, employee1);

        //Same object
        assertEquals(employee1, employee1);
        assertEquals(employee2, employee2);
        assertEquals(employee3, employee3);
    }

    @Test
    public void testToString() {
        Employee employee = new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123");
        employee.setID("a908ffa4-dd37-11ed");
        String expected = "Role: EMPLOYEE, ID: a908ffa4-dd37-11ed, Name: Lionel Craig, Email: lionel.craig@example.com, Login: lionelCraig, Password: password123";
        String actual = employee.toString();
        assertEquals(expected, actual);
    }
}