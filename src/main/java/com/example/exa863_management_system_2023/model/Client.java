package com.example.exa863_management_system_2023.model;

import java.util.List;

public class Client extends Person {

    private String address;
    private String phone;
    private List<WorkOrder> workOrderList;

    public Client(String name, String email, String address, String phone) {
        super(name, email);
        this.address = address;
        this.phone = phone;
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

    @Override
    public String toString() {
        return super.toString() + ", Address: " + this.address + ", Phone: " + this.phone;
    }
}
