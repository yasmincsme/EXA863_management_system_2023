package com.example.exa863_management_system_2023.model;

import java.io.Serializable;

public class Technician implements Serializable {

    private String id;
    private final String type = "TECHNICIAN";
    private String name;
    private String email;
    private String login;
    private String password;

    /**
     *
     * @param name Technician's name
     * @param email Technician's email
     * @param login Technician's login
     * @param password Technician's password
     */
    public Technician(String name, String email, String login, String password) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    /**
     *
     * @return Return Technician's ID
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
     * @return Return Technician's name
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
     * @return Return Technician's email
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
     * @return Return Technician's login
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login New value to login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return Return Technician's password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password New value to password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Technician object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Technician) {
            Technician technician = (Technician) object;
            if(this.getID().equals(technician.getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return Return a short formatted description of the object
     */
    @Override
    public String toString() {
        return "Role: " + this.type + ", ID: " + this.id + ", Name: " + this.name + ", Email: " + this.email + ", Login: " + this.login + ", Password: " + this.password;
    }
}
