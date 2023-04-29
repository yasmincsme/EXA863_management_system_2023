package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Employee;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeListImplementationTest {
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp() {
        employee1 = DAO.getEmployee().create(new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        employee2 = DAO.getEmployee().create(new Employee("Jane Doe", "jane.doe@example.com", "janeDoe", "password123"));
    }

    @AfterEach
    public void tearDown() {
        DAO.getEmployee().deleteMany();
    }

    @Test
    public void testCreate() {
        Employee actual = DAO.getEmployee().create(new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "password123"));
        Employee expected = DAO.getEmployee().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<Employee> employeeList = DAO.getEmployee().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, employeeList.size());
    }

    @Test
    public void testFindByID() {
        Employee actual = DAO.getEmployee().findByID(employee1.getID());
        assertEquals(employee1, actual);
    }
}