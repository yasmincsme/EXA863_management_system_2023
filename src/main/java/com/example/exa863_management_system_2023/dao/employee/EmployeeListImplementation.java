package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;


public class EmployeeListImplementation implements EmployeeDAO {

    private List<Employee> listOfEmployees;

    public EmployeeListImplementation() {
        this.listOfEmployees = new ArrayList<Employee>();
    }

    @Override
    public Employee create(Employee employee) {
        employee.setID(Generator.generateID());
        this.listOfEmployees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> findMany() {
        return listOfEmployees;
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
    public void update(Employee employee) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfEmployees.size(); i++) {
            if (this.listOfEmployees.get(i).getID().equals(employee.getID())) {
                this.listOfEmployees.set(i, employee);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed employee is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException{
        for (int i = 0; i < this.listOfEmployees.size(); i++) {
            if (this.listOfEmployees.get(i).getID().equals(id)) {
                this.listOfEmployees.remove(i);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed employee is not registered in the system");
    }

    @Override
    public void deleteMany() {
        this.listOfEmployees = new ArrayList<Employee>();
    }
}
