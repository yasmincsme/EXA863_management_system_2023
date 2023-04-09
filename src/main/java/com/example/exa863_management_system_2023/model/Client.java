package com.example.exa863_management_system_2023.model;

public class Client extends Person {

    private String address;
    private String phone;
    private String email;

    public Client(String name) {
        super(name);
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
