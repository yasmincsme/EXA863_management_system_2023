package com.example.exa863_management_system_2023.dao.workOrder;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.*;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;


public class WorkOrderListImplementation implements WorkOrderDAO {

    private List<WorkOrder> listOfWorkOrder;

    public WorkOrderListImplementation() {
        this.listOfWorkOrder = new ArrayList<>();
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param workOrder Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public WorkOrder create(WorkOrder workOrder) {
        workOrder.setID(Generator.generateID());
        this.listOfWorkOrder.add(workOrder);
        return workOrder;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<WorkOrder> findMany() {
        return listOfWorkOrder;
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public WorkOrder findByID(String id) {
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getID().equals(id)) {
                return workOrder;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna as ordens de serviço que estão em aberto.
     * @return Lista com todas as ordens de serviço em aberto
     */
    @Override
    public List<WorkOrder> findOpenWorkOrders() {
        List<WorkOrder> openWorkOrders = new ArrayList<WorkOrder>();
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if(workOrder.getStatus().equals("OPEN")) {
                openWorkOrders.add(workOrder);
            }
        }
        return openWorkOrders;
    }

    /**
     * Percorre a lista e retorna a primeira ordem de serviço em aberto da lista.
     * @return Primeira ordem de serviço em aberto da lista
     */
    public WorkOrder getFirstOpenedWorkOrder() {
        List<WorkOrder> openWorkOrders = new ArrayList<>();
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getStatus().equals("OPEN")) {
                return workOrder;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna uma lista com todas as ordens de serviço que pertencem a um mesmo cliente.
     * @param clientID ID do cliente desejado
     * @return Lista com todas as ordens de serviço que pertencem a um mesmo cliente
     */
    @Override
    public List<WorkOrder> findOrderByClientID(String clientID) {
        List<WorkOrder> workOrderListByClient = new ArrayList<>();
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getClientID().equals(clientID)) {
                workOrderListByClient.add(workOrder);
            }
        }
        return workOrderListByClient;
    }

    /**
     * Percorre a lista e retorna uma lista com todas as ordens de serviço que já foram designadas a um mesmo técnico.
     * @param technicianID ID do técnico desejado
     * @return Lista com todas as ordens de serviço que pertencem a um mesmo técnico
     */
    @Override
    public List<WorkOrder> findOrderByTechnicianID(String technicianID) {
        List<WorkOrder> workOrderListByTechnician = new ArrayList<>();
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getTechnicianID().equals(technicianID)) {
                workOrderListByTechnician.add(workOrder);
            }
        }
        return workOrderListByTechnician;
    }

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param workOrder Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void update(WorkOrder workOrder) throws ObjectNotFoundException {
        for (int i = 0; i < listOfWorkOrder.size(); i++) {
            if (this.listOfWorkOrder.get(i).getID().equals(workOrder.getID())) {
                this.listOfWorkOrder.set(i, workOrder);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed work order is not registered in the system");
    }

    /**
     * Percorre a lista e deleta o objeto informado.
     * @param id ID do objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void delete(String id) throws ObjectNotFoundException{
        for (int i = 0; i < this.listOfWorkOrder.size(); i++) {
            if (this.listOfWorkOrder.get(i).getID().equals(id)) {
                this.listOfWorkOrder.remove(i);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed work order is not registered in the system");
    }

    /**
     * Deleta todos os elementos da lista
     */
    @Override
    public void deleteMany() {
        this.listOfWorkOrder = new ArrayList<>();
    }

    /**
     * Procura no sistema por todos os serviços pertencentes a uma mesma ordem de serviço e retorna o preço final.
     * @param workOrderID ID da ordem de serviço
     * @return Preço final de todos os serviços de uma ordem de serviço
     */
    @Override
    public double getPriceByWorkOrderID(String workOrderID) {
        return DAO.getBuilding().getPriceByServices(workOrderID) + DAO.getCleaning().getPriceByServices(workOrderID) + DAO.getInstallation().getPriceByServices(workOrderID);

    }

    /**
     * Procura no sistema por todos os serviços pertencentes a uma mesma ordem de serviço e retorna o custo final.
     * @param workOrderID ID da ordem de serviço
     * @return Preço final de todos os serviços de uma ordem de serviço
     */
    @Override
    public double getCostByWorkOrderID(String workOrderID) {
        return DAO.getBuilding().getCostByServices(workOrderID) + DAO.getCleaning().getCostByServices(workOrderID) + DAO.getInstallation().getCostByServices(workOrderID);
    }
}
