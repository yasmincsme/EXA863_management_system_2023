package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Employee;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeListImplementationTest {

    private static EmployeeDAO employeeDAO;
    private static String nextID;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp() {
        employeeDAO = new EmployeeListImplementation();

        employee1 = new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123");
        employee1.setID("a908ffa4-dd37-11ed");
        employee2 = new Employee("Jane Doe", "jane.doe@example.com", "janeDoe", "password123");
        employee2.setID("ed198b64-dd37-11ed");
    }

    @AfterEach
    public void tearDown() {
        employeeDAO.deleteMany();
    }

    @Test
    public void testCreate() {

    }
}