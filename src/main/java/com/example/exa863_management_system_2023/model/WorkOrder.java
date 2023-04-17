package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class WorkOrder {

    private String id;
    private String clientID;
    private String technicianID;
    private String status;
    private List<Building> buildingList;
    private List<Cleaning> cleaningList;
    private List<Installation> installationList;
    private String description;
    private Date createdAt;
    private Date finishedAt;
    private int clientSatisfaction;
    private String paymentMethod;

    public WorkOrder(String clientID, String description) {
        this.clientID = clientID;
        this.technicianID = null;
        this.status = "This work order is still active";
        this.buildingList = new ArrayList<>();
        this.cleaningList = new ArrayList<>();
        this.buildingList = new ArrayList<>();
        this.description = description;
        this.createdAt = new Date();
        this.clientSatisfaction = 0;
        this.paymentMethod = null;
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

    public List<Building> getBuildindList() {
        return buildingList;
    }
    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public List<Cleaning> getCleaningList() {
        return cleaningList;
    }
    public void setCleaningList(List<Cleaning> cleaningList) {
        this.cleaningList = cleaningList;
    }

    public List<Installation> getInstallationList() {
        return installationList;
    }
    public void setInstallationList(List<Installation> installationList) {
        this.installationList = installationList;
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
        this.buildingList.add(building);
    }

    public void addCleaningService(Cleaning cleaning) {
        this.cleaningList.add(cleaning);
    }

    public void addInstallationService(Installation installation) {
        this.installationList.add(installation);
    }

    public long getBuildingListPrice() {
        long price = 0;
        for(Building building : buildingList) {
            price += building.getPrice();
        }
        return price;
    }

    public long getCleaningListPrice() {
        long price = 0;
        for(Cleaning cleaning : cleaningList) {
            price += cleaning.getPrice();
        }
        return price;
    }

    public long getInstallationListPrice() {
        long price = 0;
        for(Cleaning cleaning : cleaningList) {
            price += cleaning.getPrice();
        }
        return price;
    }

    public boolean isFinished() {
        return this.status.equals("This work order has been completed.");
    }

    public boolean isCanceled() {
        return this.status.equals("This work order has been cancelled");
    }

    public boolean isOnGoing() {
        return this.status.equals("This work order is still active");
    }

    public void finish() {
        this.status = "This work order has been completed.";
        this.finishedAt = new Date();
    }

    public void cancel() {
        this.status = "This work order has been cancelled";
        this.finishedAt = new Date();
    }
}
