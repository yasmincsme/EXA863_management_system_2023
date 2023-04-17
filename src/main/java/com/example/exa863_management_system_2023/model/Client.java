package com.example.exa863_management_system_2023.model;

import java.util.List;

public class Client extends Person {

    private String address;
    private String phone;
    private List<WorkOrder> workOrderList;

    /**
     *
     * @param name Name of the Person
     * @param email Email of the Person
     * @param address Address of the Person
     * @param phone Phone of the Person
     */
    public Client(String name, String email, String address, String phone) {
        super(name, email);
        this.address = address;
        this.phone = phone;
    }

    /**
     *
     * @return Return Client's address
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
     * @return Return Client's phone
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
     * @param object Receive a random object;
     * @return Return true if the given object is equal to the current Client object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Client) {
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
        return super.toString() + ", Address: " + this.address + ", Phone: " + this.phone;
    }
}
