package com.example.exa863_management_system_2023.model;

public class Client extends Person {

    public Client(String name) {
        super(name);
    }

    private String address;
    private String phone;
    private String email;

    public String getAddress() {
        return address;
    }
    public void setAddress() {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone() {
        this.phone = phone;
    }

}
