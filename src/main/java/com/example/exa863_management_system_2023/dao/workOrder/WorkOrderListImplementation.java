package com.example.exa863_management_system_2023.dao.workOrder;

import com.example.exa863_management_system_2023.dao.technician.TechnicianListImplementation;
import com.example.exa863_management_system_2023.model.Technician;
import com.example.exa863_management_system_2023.model.WorkOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class WorkOrderListImplementation implements WorkOrderDAO {

    private List<WorkOrder> listOfWorkOrder;
    private String nextID;

    public WorkOrderListImplementation() {
        this.listOfWorkOrder = new ArrayList<>();
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
    }

    @Override
    public WorkOrder create(WorkOrder workOrder) {
        workOrder.setID(this.nextID);
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
        this.listOfWorkOrder.add(workOrder);
        return workOrder;
    }

    @Override
    public List<WorkOrder> findMany() {
        List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
        for(WorkOrder workOrder: this.listOfWorkOrder) {
            workOrderList.add(workOrder);
        }
        return workOrderList;
    }

    @Override
    public WorkOrder findByID(String id) {
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getID().equals(id)) {
                return workOrder;
            }
        }
        return null;
    }

    @Override
    public void update(WorkOrder workOrder) throws Exception {
        for (int i = 0; i < listOfWorkOrder.size(); i++) {
            if (this.listOfWorkOrder.get(i).getID().equals(workOrder.getID())) {
                this.listOfWorkOrder.set(i, workOrder);
                return;
            }
        }
    }

    @Override
    public void delete(String id) throws Exception {
        for (int i = 0; i < this.listOfWorkOrder.size(); i++) {
            if (this.listOfWorkOrder.get(i).getID().equals(id)) {
                this.listOfWorkOrder.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfWorkOrder = new ArrayList<>();
        this.nextID = null;
    }

    @Override
    public List<WorkOrder> findOpenWorkOrders() {
        List<WorkOrder> openWorkOrders = new ArrayList<WorkOrder>();
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if(workOrder.getStatus().equals("This work order is still active")) {
                openWorkOrders.add(workOrder);
            }
        }
        return openWorkOrders;
    }

    @Override
    public List<WorkOrder> findOrderByClientID(String id) {
        List<WorkOrder> workOrderListByClient = new ArrayList<>();
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getClientID().equals(id)) {
                workOrderListByClient.add(workOrder);
            }
        }
        return workOrderListByClient;
    }

    @Override
    public WorkOrder findOrderByTechnicianID(String id) {
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getTechnicianID().equals(id)) {
                return workOrder;
            }
        }
        return null;
    }
}
