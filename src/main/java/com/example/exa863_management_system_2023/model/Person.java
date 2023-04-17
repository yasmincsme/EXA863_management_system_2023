package com.example.exa863_management_system_2023.model;

public abstract class Person {

    private String id;
    private String name;
    private String email;

    /**
     *
     * @param name Name of the Person
     * @param email Email of the Person
     */
    public Person(String name, String email) {
        this.name = name;
        this.email =email;
    }

    /**
     *
     * @return Return the Person's ID
     */
    public String getID() {
        return id;
    }

    /**
     *
     * @param id New value to ID
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     *
     * @return Return the Person's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name New value to name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Return the Person's email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email New value to email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return Return a short formatted description of the object
     */
    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", Email: " + this.email;
    }
}

