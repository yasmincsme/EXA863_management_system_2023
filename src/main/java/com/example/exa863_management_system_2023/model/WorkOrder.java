package com.example.exa863_management_system_2023.model;

import com.example.exa863_management_system_2023.Exceptions.InvalidSatisfactionScore;
import com.example.exa863_management_system_2023.Exceptions.WorkOrderWithoutTechnician;

import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class WorkOrder {

    private String id;
    private String clientID;
    private String technicianID;
    private String status;
    private String description;
    private String createdAt;
    private String finishedAt;
    private int clientSatisfaction;
    private double price;
    private double cost;
    private String paymentMethod;

    /**
     *
     * @param clientID Client ID of the WorkOrder
     * @param description Description of the WorkOrder
     */
    public WorkOrder(String clientID, String description) {
        this.id = null;
        this.clientID = clientID;
        this.technicianID = null;
        this.status = "OPEN";
        this.description = description;
        this.createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S").format(Calendar.getInstance().getTime());
        this.finishedAt = null;
        this.clientSatisfaction = 0;
        this.price = 0.00;
        this.cost = 0.00;
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
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt New value to initial date
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return Return WorkOrder's final date
     */
    public String getFinishedAt() {
        return finishedAt;
    }

    /**
     *
     * @param finishedAt New value to final date
     */
    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    /**
     *
     * @return Return client's satisfaction
     */
    public int getClientSatisfaction() {
        return clientSatisfaction;
    }

    /**
     *
     * @param clientSatisfaction New value to client satisfaction
     */
    public void setClientSatisfaction(int clientSatisfaction) throws InvalidSatisfactionScore {
        if (clientSatisfaction < 0 || clientSatisfaction > 10) {
            throw new InvalidSatisfactionScore("Please enter a valid value for the customer satisfaction level");
        }
        this.clientSatisfaction = clientSatisfaction;
    }

    /**
     *
     * @return Return work order's price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price New value to price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return Return work order's cost
     */
    public double getCost() {
        return cost;
    }

    /**
     *
     * @param cost New value to cost
     */
    public void setCost(double cost) {
        this.cost = cost;
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
     * Indicates that the WorkOrder is on going
     * @return Return the status of the WorkOrder
     */
    public void reopen() {
        this.setStatus("OPEN");
        this.finishedAt = null;
    }

    /**
     * Finalize the work order
     */
    public void finish() throws WorkOrderWithoutTechnician {
        if (this.technicianID == null) {
            throw new WorkOrderWithoutTechnician("There is no technician assigned to the service so that it can be completed");
        }
        this.setStatus("FINISHED");
        this.finishedAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S").format(Calendar.getInstance().getTime());
    }

    /**
     * Cancel the work order
     */
    public void cancel() {
        this.setStatus("CANCELLED");
        this.finishedAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S").format(Calendar.getInstance().getTime());
    }

    /**
     * Get the time between the initial date and the final date of a WordOrder
     * @return Return the time between two dates in days
     */
    public long getWaitingTime() {
        ParsePosition position1 = new ParsePosition(0);
        ParsePosition position2 = new ParsePosition(0);

        Date createdAtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(this.createdAt, position1);
        Date finishedAtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(this.finishedAt, position2);

        LocalDate createdAtTemporal = createdAtDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate finishedAtTemporal = finishedAtDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return ChronoUnit.DAYS.between(createdAtTemporal, finishedAtTemporal);
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
        return "ID: " + this.id + ", Client ID: " + this.clientID + ", Technician ID: " + this.technicianID + ", Status: " + this.status + ", Description: " + this.description + ", Creation Date: " + this.createdAt + ", Completion Date: " + this.finishedAt + ", Satisfaction Score: " + this.clientSatisfaction + ", Price:" + this.price + ", Cost: " + this.cost + ", Payment Method: " + this.paymentMethod;
    }
}
