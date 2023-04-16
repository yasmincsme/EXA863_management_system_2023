package com.example.exa863_management_system_2023.model;

public abstract class Person {

    private String id;
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email =email;
    }

    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Email: " + this.email;
    }
}

