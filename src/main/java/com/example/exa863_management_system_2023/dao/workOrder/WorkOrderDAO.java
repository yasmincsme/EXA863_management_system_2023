package com.example.exa863_management_system_2023.dao.workOrder;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.WorkOrder;

import java.util.List;

public interface WorkOrderDAO extends CRUD<WorkOrder, Exception> {

    /**
     * Percorre a lista e retorna as ordens de serviço que estão em aberto.
     * @return Lista com todas as ordens de serviço em aberto
     */
    public List<WorkOrder> findOpenWorkOrders();

    /**
     * Percorre a lista e retorna a primeira ordem de serviço em aberto da lista.
     * @return Primeira ordem de serviço em aberto da lista
     */
    public WorkOrder getFirstOpenedWorkOrder();

    /**
     * Percorre a lista e retorna uma lista com todas as ordens de serviço que pertencem a um mesmo cliente.
     * @param clientID ID do cliente desejado
     * @return Lista com todas as ordens de serviço que pertencem a um mesmo cliente
     */
    public List<WorkOrder> findOrderByClientID(String clientID);

    /**
     * Percorre a lista e retorna uma lista com todas as ordens de serviço que já foram designadas a um mesmo técnico.
     * @param technicianID ID do técnico desejado
     * @return Lista com todas as ordens de serviço que pertencem a um mesmo técnico
     */
    public List<WorkOrder> findOrderByTechnicianID(String technicianID);

    /**
     * Procura no sistema por todos os serviços pertencentes a uma mesma ordem de serviço e retorna o preço final.
     * @param workOrderID ID da ordem de serviço
     * @return Preço final de todos os serviços de uma ordem de serviço
     */
    public double getPriceByWorkOrderID(String workOrderID);

    /**
     * Procura no sistema por todos os serviços pertencentes a uma mesma ordem de serviço e retorna o custo final.
     * @param workOrderID ID da ordem de serviço
     * @return Preço final de todos os serviços de uma ordem de serviço
     */
    public double getCostByWorkOrderID(String workOrderID);
}
