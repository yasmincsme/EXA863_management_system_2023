package com.example.exa863_management_system_2023.model;

import java.util.Date;
import java.util.List;
public class WorkOrder {

    private String id;
    private Client client;
    private Technician technician;
    private String status;
    private List<Service> services;
    private String description;
    private Date createdAt;
    private Date finishedAt;

    public WorkOrder(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Technician getTechnician() {
        return technician;
    }
    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<Service> getServices() {
        return services;
    }
    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getFinishedAtdAt() {
        return finishedAt;
    }
    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }
}
