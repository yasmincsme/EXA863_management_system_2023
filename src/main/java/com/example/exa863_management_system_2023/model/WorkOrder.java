package com.example.exa863_management_system_2023.model;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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

    /**
     *
     * @param clientID Client ID of the WorkOrder
     * @param description Description of the WorkOrder
     */
    public WorkOrder(String clientID, String description) {
        this.clientID = clientID;
        this.technicianID = null;
        this.status = "This work order is still active";
        this.buildingList = new ArrayList<>();
        this.cleaningList = new ArrayList<>();
        this.installationList = new ArrayList<>();
        this.description = description;
        this.createdAt = new Date();
        this.clientSatisfaction = 0;
        this.paymentMethod = null;
    }

    /**
     *
     * @return Return WorkOrder's ID
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
     * @return Return WorkOrder's client ID
     */
    public String getClientID() {
        return clientID;
    }

    /**
     *
     * @param clientID New value to client ID
     */
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     *
     * @return Return WorkOrder's technician ID
     */
    public String getTechnicianID() {
        return technicianID;
    }

    /**
     *
     * @param technicianID New value to technician ID
     */
    public void setTechnicianID(String technicianID) {
        this.technicianID = technicianID;
    }

    /**
     *
     * @return Return WorkOrder's status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status New value to status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return Return WorkOrder's building list
     */
    public List<Building> getBuildindList() {
        return buildingList;
    }

    /**
     *
     * @param buildingList New value to building list
     */
    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }


    /**
     *
     * @return Return WorkOrder's cleaning list
     */
    public List<Cleaning> getCleaningList() {
        return cleaningList;
    }

    /**
     *
     * @param cleaningList New value to cleaning list
     */
    public void setCleaningList(List<Cleaning> cleaningList) {
        this.cleaningList = cleaningList;
    }

    /**
     *
     * @return Return WorkOrder's installation list
     */
    public List<Installation> getInstallationList() {
        return installationList;
    }

    /**
     *
     * @param installationList New value to installation list
     */
    public void setInstallationList(List<Installation> installationList) {
        this.installationList = installationList;
    }

    /**
     *
     * @return Return WorkOrder's description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description New value to description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return Return WorkOrder's initial date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt New value to initial date
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return Return WorkOrder's final date
     */
    public Date getFinishedAt() {
        return finishedAt;
    }

    /**
     *
     * @param finishedAt New value to final date
     */
    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    /**
     *
     * @return Return
     */
    public int getClientSatisfaction() {
        return clientSatisfaction;
    }

    /**
     *
     * @param clientSatisfaction New value to client satisfaction
     */
    public void setClientSatisfaction(int clientSatisfaction) {
        this.clientSatisfaction = clientSatisfaction;
    }

    /**
     *
     * @return Return WorkOrder's payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     *
     * @param paymentMethod New value to payment method
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Add a new Building to the Building list
     * @param building New Building
     */
    public void addBuildingService(Building building) {
        this.buildingList.add(building);
    }

    /**
     * Add a new Cleaning to the Cleaning list
     * @param cleaning New Cleaning
     */
    public void addCleaningService(Cleaning cleaning) {
        this.cleaningList.add(cleaning);
    }

    /**
     * Add a new Installation to the installation list
     * @param installation New Installation
     */
    public void addInstallationService(Installation installation) {
        this.installationList.add(installation);
    }

    /**
     * Get the price of all the Buildings
     * @return Return the price of all the Buildings
     */
    public long getBuildingListPrice() {
        long price = 0;
        for(Building building : buildingList) {
            price += building.getPrice();
        }
        return price;
    }

    /**
     * Get the price of all the Installations
     * @return Return the price of all the Installations
     */
    public long getCleaningListPrice() {
        long price = 0;
        for(Cleaning cleaning : cleaningList) {
            price += cleaning.getPrice();
        }
        return price;
    }

    /**
     * Get the price of all the Installations
     * @return Return the price of all the Installations
     */
    public long getInstallationListPrice() {
        long price = 0;
        for(Installation installation: installationList) {
            price += installation.getPrice();
        }
        return price;
    }

    /**
     * Get the price of all the Services
     * @return Return the price of all the Services
     */
    public long getPrice() {
        return this.getBuildingListPrice() + this.getCleaningListPrice() + this.getInstallationListPrice();
    }

    /**
     * Get the cost of all the Buildings
     * @return Return the cost of all the Buildings
     */
    public long getBuildingListCost() {
        long cost = 0;
        for(Building building : buildingList) {
            cost += building.getCost();
        }
        return cost;
    }

    /**
     * Get the cost of all the Cleanings
     * @return Return the cost of all the Cleanings
     */
    public long getCleaningListCost() {
        long cost = 0;
        for(Cleaning cleaning : cleaningList) {
            cost += cleaning.getCost();
        }
        return cost;
    }

    /**
     * Get the cost of all the Installations
     * @return Return the cost of all the Installations
     */
    public long getInstallationListCost() {
        long cost = 0;
        for(Installation installation : installationList) {
            cost += installation.getCost();
        }
        return cost;
    }

    /**
     * Get the cost of all the Services
     * @return Return the cost of all the Services
     */
    public long getCost() {
        return this.getBuildingListCost() + this.getCleaningListCost() + this.getInstallationListCost();
    }

    /**
     * Indicates that the WorkOrder is finished
     * @return Return the status of the WorkOrder
     */
    public boolean isFinished() {
        return this.status.equals("This work order has been completed.");
    }

    /**
     * Indicates that the WorkOrder is canceled
     * @return Return the status of the WorkOrder
     */
    public boolean isCanceled() {
        return this.status.equals("This work order has been cancelled");
    }

    /**
     * Indicates that the WorkOrder is on going
     * @return Return the status of the WorkOrder
     */
    public boolean isOnGoing() {
        return this.status.equals("This work order is still active");
    }

    /**
     * Finalize the WorkOrder
     */
    public void finish() {
        this.status = "This work order has been completed.";
        this.finishedAt = new Date();
    }

    /**
     * Cancel the WorkOrder
     */
    public void cancel() {
        this.status = "This work order has been cancelled";
        this.finishedAt = new Date();
    }

    /**
     * Get the time between the initial date and the final date of a WordOrder
     * @return Return the time between two dates in days
     */
    public long getWaitingTime() {
        LocalDate createdAt = LocalDate.ofInstant(this.createdAt.toInstant(), ZoneId.systemDefault());
        LocalDate finishedAt = LocalDate.ofInstant(this.finishedAt.toInstant(), ZoneId.systemDefault());
        return ChronoUnit.DAYS.between(createdAt, finishedAt);
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current WorkOrder object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof WorkOrder) {
           WorkOrder workOrder = (WorkOrder) object;
           if (this.getID().equals(workOrder.getID())) {
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
        return "ID: " + this.id + ", Client ID: " + this.clientID + ", Technician ID: " + this.technicianID + ", Status: " + this.status + ", Building List: " + this.buildingList + ", Cleaning List: " + this.cleaningList + "Installation List: " + this.installationList + ", Description: " + this.description + ", Creation Date: " + this.createdAt + ", Completion Date: " + this.finishedAt + ", Satisfaction Score: " + this.clientSatisfaction + ", Payment Method: " + this.paymentMethod;
    }
}
