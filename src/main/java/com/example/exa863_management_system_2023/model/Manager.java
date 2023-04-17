package com.example.exa863_management_system_2023.model;

public class Manager extends User{

    public Manager(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Manager) {
            Manager manager = (Manager) object;
            if (this.getID().equals(manager.getID())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Manager";
    }
}
