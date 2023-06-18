package com.example.exa863_management_system_2023.model;

import com.example.exa863_management_system_2023.exceptions.InvalidSatisfactionScore;
import com.example.exa863_management_system_2023.exceptions.WorkOrderWithoutTechnician;

import java.io.Serializable;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class WorkOrder implements Serializable {

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
     * Cria um novo objeto do tipo "work order".
     * @param clientID ID do cliente
     * @param description Descrição da ordem de serviço
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
        this.price = 0.0;
        this.cost = 0.0;
        this.paymentMethod = null;
    }

    /**
     * Retorna o ID do objeto.
     * @return ID do objeto
     */
    public String getID() {
        return id;
    }

    /**
     * Atribui um novo valor para o ID.
     * @param id Novo valor para o ID
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Retorna o ID do cliente ao qual a ordem de serviço serviço está associada.
     * @return ID do cliente ao qual a ordem de serviço serviço está associada
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * Atribui um novo valor para o ID do cliente ao qual a ordem de serviço está associada.
     * @param clientID ID do cliente ao qual a ordem de serviço está associada
     */
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * Retorna o ID do técnico ao qual a ordem de serviço serviço está associada.
     * @return ID do técnico ao qual a ordem de serviço serviço está associada
     */
    public String getTechnicianID() {
        return technicianID;
    }

    /**
     * Atribui um novo valor para o ID do técnico ao qual a ordem de serviço está associada.
     * @param technicianID ID do técnico ao qual a ordem de serviço está associada
     */
    public void setTechnicianID(String technicianID) {
        this.technicianID = technicianID;
    }

    /**
     * Retorna o status da ordem de serviço.
     * @return Status da ordem de serviço
     */
    public String getStatus() {
        return status;
    }

    /**
     * Atualiza o status da ordem de serviço.
     * @param status Novo valor para o status da ordem de serviço
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retorna a descrição do serviço.
     * @return Descrição do serviço
     */
    public String getDescription() {
        return description;
    }

    /**
     * Atribui uma nova informação à descrição.
     * @param description Nova descrição para o serviço
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o dia de criação da ordem de serviço.
     * @return Dia de criação da ordem de serviço
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Atualiza o dia de criação da ordem de serviço.
     * @param createdAt Novo valor para o dia de criação da ordem de serviço.
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Retorna o dia de finalização da ordem de serviço.
     * @return Dia de finalização da ordem de serviço
     */
    public String getFinishedAt() {
        return finishedAt;
    }

    /**
     * Atualiza o dia de finalização da ordem de serviço.
     * @param finishedAt Novo valor para o dia de finalização da ordem de serviço.
     */
    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    /**
     * Retorna a satisfação do cliente.
     * @return Satisfação do cliente
     */
    public int getClientSatisfaction() {
        return clientSatisfaction;
    }

    /**
     * Atualiza a satisfação do cliente.
     * @param clientSatisfaction Novo valor para a satisfação do cliente
     */
    public void setClientSatisfaction(int clientSatisfaction) throws InvalidSatisfactionScore {
        if (clientSatisfaction < 0 || clientSatisfaction > 10) {
            throw new InvalidSatisfactionScore("Please enter a valid value for the customer satisfaction level");
        }
        this.clientSatisfaction = clientSatisfaction;
    }

    /**
     * Retorna o preço da ordem de serviço.
     * @return Preço da ordem de serviço
     */
    public double getPrice() {
        return price;
    }

    /**
     * Atribui um novo valor para o preço da ordem de serviço.
     * @param price Novo preço para a ordem de serviço
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retorna o custo da ordem de serviço.
     * @return Custo da ordem de serviço
     */
    public double getCost() {
        return cost;
    }

    /**
     * Atribui um novo valor para o custo da ordem de serviço.
     * @param cost Novo custo para a ordem de serviço
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Retorna o método de pagamento da ordem de serviço.
     * @return Método de pagamento da ordem de serviço
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Atualiza o método de pagamento da ordem de serviço.
     * @param paymentMethod Novo valor para o método de pagamento da ordem de serviço
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Reabre uma ordem de serviço fechada
     */
    public void reopen() {
        this.setStatus("OPEN");
        this.finishedAt = null;
    }

    /**
     * Finaliza uma ordem de serviço aberta
     */
    public void finish() throws WorkOrderWithoutTechnician {
        if (this.technicianID == null) {
            throw new WorkOrderWithoutTechnician("There is no technician assigned to the service so that it can be completed");
        }
        this.setStatus("FINISHED");
        this.finishedAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S").format(Calendar.getInstance().getTime());
    }

    /**
     * Cancela uma ordem de serviço aberta
     */
    public void cancel() {
        this.setStatus("CANCELLED");
        this.finishedAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S").format(Calendar.getInstance().getTime());
    }

    /**
     * Retorna o tempo de espera para finalização da ordem de serviço em dias.
     * @return Tempo de espera para finalização da ordem de serviço em dias
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
     * Compara dois objetos do tipo "work order" a partir do ID
     * @param object Objeto do tipo "work order"
     * @return True se o objeto informado tem o mesmo ID do objeto comparado, False caso contrário.
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
     * Retorna uma representação em String do objeto.
     * @return Representação em String do objeto
     */
    @Override
    public String toString() {
        return "ID: " + this.id + ", Client ID: " + this.clientID + ", Technician ID: " + this.technicianID + ", Status: " + this.status + ", Description: " + this.description + ", Creation Date: " + this.createdAt + ", Completion Date: " + this.finishedAt + ", Satisfaction Score: " + this.clientSatisfaction + ", Price:" + this.price + ", Cost: " + this.cost + ", Payment Method: " + this.paymentMethod;
    }
}
