package com.example.exa863_management_system_2023.model;

public class Manager extends User{

    public Manager(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Manager";
    }
}
