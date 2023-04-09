package com.example.exa863_management_system_2023.model;

public class Technician extends Person {

    private WorkOrder workOrder;

    public Technician(String name) {
        super(name);
    }

    public WorkOrder getWorkorder() {
        return workOrder;
    }
    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }
}
