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
        for(Object workOrder: this.listOfWorkOrder) {
            workOrderList.add((WorkOrder) workOrder);
        }
        return workOrderList;
    }

    @Override
    public WorkOrder findByID(String id) {
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (Objects.equals(workOrder.getID(), id)) {
                return workOrder;
            }
        }
        return null;
    }

    @Override
    public void update(WorkOrder workOrder) throws Exception {
        for (int i = 0; i < listOfWorkOrder.size(); i++) {
            if (Objects.equals(this.listOfWorkOrder.get(i).getID(), workOrder.getID())) {
                this.listOfWorkOrder.set(i, workOrder);
                return;
            }
        }
    }

    @Override
    public void delete(String id) throws Exception {
        for (int i = 0; i < this.listOfWorkOrder.size(); i++) {
            if (Objects.equals(this.listOfWorkOrder.get(i).getID(), id)) {
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
}
