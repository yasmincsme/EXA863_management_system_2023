package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class EmployeeListImplementation implements EmployeeDAO {

    private List<Employee> listOfEmployees;
    private String nextID;

    public EmployeeListImplementation() {
        this.listOfEmployees = new ArrayList<Employee>();
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();

    }

    @Override
    public Employee create(Employee employee) {
        employee.setID(this.nextID);
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
        this.listOfEmployees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> findMany() {
        List<Employee> employeeList = new ArrayList<Employee>();
        for (Employee employee : this.listOfEmployees) {
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public Employee findByID(String id) {
        for (Employee employee : this.listOfEmployees) {
            if (employee.getID().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> findByLogin(String login) {
        List<Employee> employeeList = new ArrayList<Employee>();
        for (Employee employee : this.listOfEmployees) {
            if (employee.getLogin().equals(login)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public void update(Employee employee) {
        for (int i = 0; i < this.listOfEmployees.size(); i++) {
            if (this.listOfEmployees.get(i).getID().equals(employee.getID())) {
                this.listOfEmployees.set(i, employee);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < this.listOfEmployees.size(); i++) {
            if (this.listOfEmployees.get(i).getID().equals(id)) {
                this.listOfEmployees.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfEmployees = new ArrayList<Employee>();
        this.nextID = null;
    }
}
