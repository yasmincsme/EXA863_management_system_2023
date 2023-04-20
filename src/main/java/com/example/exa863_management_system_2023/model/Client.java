package com.example.exa863_management_system_2023.model;

import java.util.List;

public class Client {

    private String id;
    private final String type = "CLIENT";
    private String name;
    private String email;
    private String address;
    private String phone;


    /**
     *
     * @param name Name of the User
     * @param email Email of the User
     * @param login Login of the User
     * @param password Password of the User
     */
    public Client(String name, String email, String address, String phone) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
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
        return "Role: " + this.type + "ID: " + this.id + ", Name: " + this.name + ", Email: " + this.email + ", Login: " + this.login + ", Password: " + this.password;
    }
}
