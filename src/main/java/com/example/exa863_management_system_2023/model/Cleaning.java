package com.example.exa863_management_system_2023.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cleaning implements Serializable {

    private String id;
    private String workOrderID;
    private final String type = "CLEANING";
    private String description;
    private double price;
    private double cost;

    /**
     * Cria um novo objeto do tipo "cleaning"
     * @param description Descrição do serviço
     * @param price Preço do serviço
     * @param cost Custo do serviço
     */
    public Cleaning(String description, String workOrderID, double price, double cost) {
        this.id = null;
        this.workOrderID = workOrderID;
        this.description = description;
        this.price = price;
        this.cost = cost;
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
     * Atribui uma nova descrição para a descrição.
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
    public void setPrice(Double price) {
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
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * Compara dois objetos do tipo "cleaning" a partir do ID
     * @param object Objeto do tipo "cleaning"
     * @return True se o objeto informado tem o mesmo ID do objeto comparado, False caso contrário.
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Cleaning) {
            Cleaning cleaning = (Cleaning) object;
            if (this.getID().equals(cleaning.getID())) {
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
        return "Type: " + this.type + ", ID: " + this.id + ", Order's ID: " + this.workOrderID + ", Description: " + this.description + ", Price: " + this.price + ", Cost: " + this.cost;
    }
}
