package com.example.exa863_management_system_2023.model;

import java.util.Date;
import java.util.List;
public class WorkOrder {

    private String id;
    private String clientID;
    private String technicianID;
    private String status;
    private List<Service> services;
    private String description;
    private Date createdAt;
    private Date finishedAt;
    private int clientSatisfaction;
    private String paymentMethod;

    public WorkOrder(String id, String clientID) {
        this.id = id;
        this.clientID = clientID;
        this.technicianID = null;
    }

    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }

    public String getClientID() {
        return clientID;
    }
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getTechnicianID() {
        return technicianID;
    }
    public void setTechnicianID(String technicianID) {
        this.technicianID = technicianID;
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

    public Date getFinishedAt() {
        return finishedAt;
    }
    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    public int getClientSatisfaction() {
        return clientSatisfaction;
    }
    public void setClientSatisfaction(int clientSatisfaction) {
        this.clientSatisfaction = clientSatisfaction;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void addBuildingService(Building building) {
        this.services.add(building);
    }

    public void addCleaningService(Cleaning cleaning) {
        this.services.add(cleaning);
    }

    public void addInstallationService(Installation installation) {
        this.services.add(installation);
    }


}
