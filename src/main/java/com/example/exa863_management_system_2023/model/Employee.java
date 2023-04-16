package com.example.exa863_management_system_2023.model;

public class Employee extends User {

    public Employee(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Employee";
    }
}
