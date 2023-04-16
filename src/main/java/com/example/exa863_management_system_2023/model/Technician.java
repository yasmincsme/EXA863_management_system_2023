package com.example.exa863_management_system_2023.model;

public class Technician extends User {

    public Technician(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Technician) {
            Technician technician = (Technician) object;
            if (this.getID().equals(technician.getID())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Role: Technician";
    }
}
