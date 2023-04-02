package com.example.exa863_management_system_2023.model;

import java.util.Date;
import java.util.List;
public class WorkOrder {

    private int id;
    private Client client;
    private Technician technician;
    private String status;
    private List<Service> services;
    private String description;
    private Date createdAt;
    private Date finishedAt;

    public WorkOrder(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }
    public void setClient() {
        this.client = client;
    }

    public Technician getTechnician() {
        return technician;
    }
    public void setTechnician() {
        this.technician = technician;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus() {
        this.status = status;
    }

    public List<Service> getServices() {
        return services;
    }
    public void setServices() {
        this.services = services;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription() {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt() {
        this.createdAt = createdAt;
    }

    public Date getFinishedAtdAt() {
        return finishedAt;
    }
    public void setFinishedAt() {
        this.finishedAt = finishedAt;
    }
}
