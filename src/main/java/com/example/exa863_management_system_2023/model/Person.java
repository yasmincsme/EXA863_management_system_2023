package com.example.exa863_management_system_2023.model;

public abstract class Person {

    private String id;
    private String name;
    private String email;

    public Person(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public void setEmail() {
        this.email = email;
    }
}

