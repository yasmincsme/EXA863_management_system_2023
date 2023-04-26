package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Employee;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeListImplementationTest {
    private static Employee employee1;
    private static Employee employee2;

    @BeforeAll
    public static void setUp() {
        employee1 = DAO.getEmployee().create(new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        employee2 = DAO.getEmployee().create(new Employee("Jane Doe", "jane.doe@example.com", "janeDoe", "password123"));
    }

    /*@AfterAll
    public static void tearDown() {
        DAO.getEmployee().deleteMany();
    }*/

    @Test
    public void testFindMany() {

        employee1 = DAO.getEmployee().create(new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        employee2 = DAO.getEmployee().create(new Employee("Jane Doe", "jane.doe@example.com", "janeDoe", "password123"));

        System.out.println(DAO.getEmployee().findMany());
        System.out.println(employee1);
        System.out.println(DAO.getEmployee().findByLogin("janeDoe"));
        System.out.println(DAO.getEmployee().findByLogin("lionelCraig"));

        System.out.println(employee2);
        List<Employee> employeeList = DAO.getEmployee().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, employeeList.size());
    }

    @Test
    public void testFindByID() {
        Employee expected = DAO.getEmployee().create(new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        String expectedID = expected.getID();
        Employee actual = DAO.getEmployee().findByID(expectedID);

        assertEquals(expected, actual);
    }
}