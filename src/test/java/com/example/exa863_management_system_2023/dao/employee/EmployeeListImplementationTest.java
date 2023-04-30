package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
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
        Employee actual1 = DAO.getEmployee().findByID(employee1.getID());
        assertEquals(employee1, actual1);

        Employee actual2 = DAO.getEmployee().findByID((employee2.getID()));
        assertEquals(employee2, actual2);
    }

    @Test
    public void testFindByLogin() {
        List<Employee> actual1 = DAO.getEmployee().findByLogin(employee1.getLogin());
        assertEquals(employee1, actual1.get(0));

        List<Employee> actual2 = DAO.getEmployee().findByLogin(employee2.getLogin());
        assertEquals(employee2, actual2.get(0));
    }

    @Test
    public void testUpdate() {
        String employee1ID = employee1.getID();
        Employee newEmployee1 = DAO.getEmployee().create(new Employee("Lionel Craig", "lionel.craig@example.com", "lionelCraig", "newPassword123"));
        newEmployee1.setID(employee1ID);

        try {
            DAO.getEmployee().update(newEmployee1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newEmployee1, DAO.getEmployee().findByID(employee1ID));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getEmployee().delete(employee1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<Employee> employeeList = DAO.getEmployee().findMany();
        int expectedLength = 1;
        assertEquals(1, employeeList.size());
        assertEquals(employee2, employeeList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getEmployee().deleteMany();
        List<Employee> employeeList = DAO.getEmployee().findMany();
        assertEquals(0, employeeList.size());
    }
}