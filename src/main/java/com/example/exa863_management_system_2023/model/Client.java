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
     * @param name Client's name
     * @param email Client's email
     * @param address Client's address
     * @param phone Client's phone
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
     * @return Return Client's ID
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
     * @return Return Client's name
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
     * @return Return Client's email
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
     * @return Client's address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address New value to address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return Client's phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone New value to phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Client object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if(object instanceof Client) {
            Client client = (Client) object;
            if (this.getID().equals(client.getID())) {
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
        return "Role: " + this.type + ", ID: " + this.id + ", Name: " + this.name + ", Email: " + this.email + ", Address: " + this.address + ", Phone: " + this.phone;
    }
}
