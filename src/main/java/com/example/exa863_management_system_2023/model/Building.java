package com.example.exa863_management_system_2023.model;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Building implements Serializable {

    private String id;
    private String workOrderID;
    private final String type = "BUILDING";
    private String description;
    private double price;
    private double cost;
    private List<ComputerComponent> usedComponents;

    /**
     * Cria um novo objeto do tipo "building"
     * @param description Descrição do serviço
     * @param price Preço do serviço
     * @param cost Custo do serviço
     */
    public Building(String description, String workOrderID, double price, double cost) {
        this.id = null;
        this.workOrderID = workOrderID;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.usedComponents = new ArrayList<>();
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
     * Retorna uma lista contendo os componentes usados.
     * @return Lista de componentes usados
     */
    public List<ComputerComponent> getUsedComponents() {
        return usedComponents;
    }

    /**
     * Estabele uma nova lista de componentes usados que substituirá a anterior.
     * @param usedComponents new value to used components
     */
    public void setUsedComponents(List<ComputerComponent> usedComponents) {
        this.usedComponents = usedComponents;
    }

    /**
     * Adiciona um novo componente à lista.
     * @param component Novo componente
     */
    public void addComponent(ComputerComponent component) {
        this.usedComponents.add(component);
        increasePrice();
        increaseCost();
    }

    /**
     * Remove um componente existente da lista.
     * @param componentID ID do componente que se deseja remover
     * @throws ObjectNotFoundException
     */
    public void removeComponent(String componentID) throws ObjectNotFoundException {
        for (ComputerComponent component : this.usedComponents) {
            if (component.getID().equals(componentID)) {
                decreasePrice();
                decreaseCost();
                this.usedComponents.remove(component);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed component is not registered in the system");
    }

    /**
     * Aumenta o preço do serviço conforme os componentes usados.
     */
    public void increasePrice() {
       double price = 0;
       for (ComputerComponent component : this.usedComponents) {
            price += component.getUnitPrice() * component.getQuantity();
       }
       double newPrice = this.getPrice() + price;
       this.setPrice(newPrice);
    }

    /**
     * Aumenta o custo do serviço conforme os componentes usados.
     */
    public void increaseCost() {
        double cost = 0;
        for (ComputerComponent component : this.usedComponents) {
            cost += component.getUnitCost() * component.getQuantity();
        }
        double newCost = this.getCost() + cost;
        this.setCost(newCost);
    }

    /**
     * Diminui o preço do serviço conforme os componentes usados.
     */
    public void decreasePrice() {
        double price = 0;
        for (ComputerComponent component : this.usedComponents) {
            price += component.getUnitPrice() * component.getQuantity();
        }
        double newPrice = this.getPrice() - price;
        this.setPrice(newPrice);
    }

    /**
     * Diminui o preço do serviço conforme os componentes usados.
     */
    public void decreaseCost() {
        double cost = 0;
        for (ComputerComponent component : this.usedComponents) {
            cost += component.getUnitCost() * component.getQuantity();
        }
        double newCost = this.getCost() - cost;
        this.setCost(newCost);
    }

    /**
     * Compara dois objetos do tipo "building" a partir do ID
     * @param object Objeto do tipo "building"
     * @return True se o objeto informado tem o mesmo ID do objeto comparado, False caso contrário.
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Building) {
            Building building = (Building) object;
            if(this.getID().equals(building.getID())) {
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
        return "Type: " + this.type + ", ID: " + this.id + ", Order's ID: " + this.workOrderID + ", Description: " + this.description + ", Price: " + this.price + ", Cost: " + this.cost + ", Used Components: " + this.usedComponents;
    }
}
