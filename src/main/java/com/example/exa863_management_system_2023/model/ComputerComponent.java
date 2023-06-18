package com.example.exa863_management_system_2023.model;

import java.io.Serializable;
import java.util.Objects;

public class ComputerComponent implements Serializable {

    private String id;
    private String name;
    private String buildingID;
    private String manufacturer;
    private String serialNumber;
    private double unitPrice;
    private double unitCost;
    private int quantity;

    /**
     * Cria um novo objeto do tipo "computer component".
     * @param name Nome do componente
     * @param manufacturer Fabricante do componente
     * @param serialNumber Número de série do componente
     * @param unitPrice Preço uniário do componente
     * @param unitCost Custo unitário do componente
     * @param quantity Quantidade do componente
     */
    public ComputerComponent(String name, String manufacturer, String serialNumber, double unitPrice, double unitCost, int quantity) {
        this.name = name;
        this.id = null;
        this.buildingID = null;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.quantity = quantity;
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
     * Retorna o nome da entidade referida.
     * @return Nome da entidade referida
     */
    public String getName() {
        return name;
    }

    /**
     * Atribui um novo nome à entidade referida.
     * @param name Novo nome para a entidade referida
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Retorna o ID do serviço ao qual o componente está associado.
     * @return ID do serviço ao qual o componente está associado
     */
    public String getBuildingID() {
        return buildingID;
    }

    /**
     * Atribui um novo valor para ID do serviço ao qual o componente está associado.
     * @param buildingID Novo valor para o ID do serviço ao qual o componente está associado
     */
    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    /**
     * Retorna a fabricante do componente.
     * @return Nome da fabricante do componente
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Atribui uma nova informação ao atributo fabricante.
     * @param manufacturer Novo nome para a fabricante do componente
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Retorna o número de série do componente.
     * @return Número de série do componente
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Atribui uma nova informação ao atributo número de série.
     * @param serialNumber Novo valor para o número de série do componente
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Retorna o preço unitário do componente.
     * @return Preço unitário do componente
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Atribui um novo preço unitário para componente.
     * @param unitPrice Novo preço unitário para o componente
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Retorna o custo unitário do componente.
     * @return Custo unitário do componente
     */
    public double getUnitCost() {
        return unitCost;
    }

    /**
     * Atribui um novo custo unitário para componente.
     * @param unitCost Novo custo unitário para o componente
     */
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    /**
     * Retorna a quantidade do componente em estoque.
     * @return Quantidade do componente em estoque
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Atribui uma nova quantidade para o componente.
     * @param quantity Nova quantidade para o componente
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;}

    /**
     * Retorna a multiplicação entre o preço unitário e a quantidade disponível no sistema
     * @return Multiplicação entre o preço unitário e a quantidade disponível no sistema
     */
    public Double getPrice() {
        return this.getUnitPrice() * this.getQuantity();
    }


    /**
     * Retorna a multiplicação entre o custo unitário e a quantidade disponível no sistema
     * @return Multiplicação entre o custo unitário e a quantidade disponível no sistema
     */
    public Double getCost() {
        return this.getUnitCost() * this.getQuantity();
    }

    /**
     * Compara dois objetos do tipo "computer component" a partir do ID
     * @param object Objeto do tipo "computer component"
     * @return True se o objeto informado tem o mesmo ID do objeto comparado, False caso contrário.
     */
    @Override
    public boolean equals(Object object) {
        if(object instanceof ComputerComponent) {
            ComputerComponent component = (ComputerComponent) object;
            if (this.getID().equals(component.getID())) {
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
        return "ID: " + this.id + ", Name: " + this.name + ", Manufacturer: " + this.manufacturer + ", Serial Number: " + this.serialNumber + ", Unit Price: " + this.unitPrice + ", Unit Cost: " + this.unitCost + ", Quantity: " + this.quantity;
    }
}
