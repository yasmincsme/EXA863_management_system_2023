package com.example.exa863_management_system_2023.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Installation implements Serializable {

    private String id;
    private String workOrderID;
    private final String type = "INSTALLATION";
    private String description;
    private double price;
    private double cost;
    private String operatingSystem;


    /**
     * Cria um novo objeto do tipo "installation".
     * @param description Descrição do serviço
     * @param price Preço do serviço
     * @param cost Custo do serviço
     */
    public Installation(String description, String workOrderID, double price, double cost, String operatingSystem) {
        this.id = null;
        this.workOrderID = workOrderID;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.operatingSystem = operatingSystem;
    }

    /**
     * Retorna o ID do objeto.
     * @return ID do objeto
     */
    public String getID() { return id;}

    /**
     * Atribui um novo valor para o ID.
     * @param id Novo valor para o ID
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Retorna o ID da ordem de serviço a qual o serviço está associado.
     * @return ID da ordem de serviço a qual o serviço está associado
     */
    public String getWorkOrderID() {
        return workOrderID;
    }

    /**
     * Atribui um novo valor para o ID da ordem de serviço a qual o serviço está associado.
     * @param workOrderID Novo valor para o ID da ordem de serviço a qual o serviço está associado
     */
    public void setWorkOrderID(String workOrderID) {
        this.workOrderID = workOrderID;
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
     * Retorna o preço do serviço.
     * @return Preço do serviço
     */
    public double getPrice() {
        return price;
    }

    /**
     * Atribui um novo valor para o preço do serviço.
     * @param price Novo preço para o serviço
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retorna o custo do serviço.
     * @return Custo do serviço
     */
    public double getCost() {
        return cost;
    }

    /**
     * Atribui um novo valor para o custo do serviço.
     * @param cost Novo custo para o serviço
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Retorna o sistema operacional do sistema do computador do cliente.
     * @return Sistema operacional do sistema do computador do cliente
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     *Aribui uma nova informação sobre o sistema operacional que substitui a anterior.
     * @param operatingSystem Nova informação sobre o sistema operacional
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * Compara dois objetos do tipo "installation" a partir do ID
     * @param object Objeto do tipo "installation"
     * @return True se o objeto informado tem o mesmo ID do objeto comparado, False caso contrário.
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Installation) {
            Installation installation = (Installation) object;
            if (this.getID().equals(installation.getID())) {
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
        return "Type: " + this.type + ", ID: " + this.id + ", Order's ID: " + this.workOrderID + ", Description: " + this.description + ", Price: " + this.price + ", Cost: " + this.cost + ", Operating System: " + this.operatingSystem;
    }
}
