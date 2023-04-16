package com.example.exa863_management_system_2023.model;

public class Employee extends User {

    public Employee(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Employee) {
            Employee employee = (Employee) object;
            if (this.getID().equals(employee.getID())) {
                return true;
            }
         }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Employee";
    }
}
