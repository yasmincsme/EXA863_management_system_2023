package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class EmployeeArchiveImplementation implements EmployeeDAO {
    private List<Employee> listOfEmployees;
    private FileManager<String> fileManager;

    public EmployeeArchiveImplementation() {
        fileManager = new FileManager<>("employees.dat");
        listOfEmployees = FileManager.readListFromFile("employees.dat");
    }

    @Override
    public Employee create(Employee employee) {
        employee.setID(Generator.generateID());
        listOfEmployees.add(employee);
        FileManager.writeListToFile(listOfEmployees, "employees.dat");
        return employee;
    }

    @Override
    public List<Employee> findMany() {
        return FileManager.readListFromFile("employees.dat");
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
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : this.listOfEmployees) {
            if (employee.getLogin().equals(login)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public void update(Employee employee) throws ObjectNotFoundException {
        for (int i = 0; i < listOfEmployees.size(); i++) {
            if (listOfEmployees.get(i).getID().equals(employee.getID())) {
                listOfEmployees.set(i, employee);
                FileManager.writeListToFile(listOfEmployees, "employees.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed employee is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfEmployees.size(); i++) {
            if (listOfEmployees.get(i).getID().equals(id)) {
                listOfEmployees.remove(i);
                FileManager.writeListToFile(listOfEmployees, "employees.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed employee is not registered in the system");
    }

    @Override
    public void deleteMany() {
        listOfEmployees = new ArrayList<>();
        FileManager.writeListToFile(listOfEmployees, "employees.dat");
    }
}
