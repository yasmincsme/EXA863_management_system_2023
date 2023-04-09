package com.example.exa863_management_system_2023.dao.workOrder;

import com.example.exa863_management_system_2023.dao.technician.TechnicianListImplementation;
import com.example.exa863_management_system_2023.model.Technician;
import com.example.exa863_management_system_2023.model.WorkOrder;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderListImplementation implements WorkOrderDAO {

    private List<WorkOrder> listOfWorkOrder;
    private int nextID;

    public WorkOrderListImplementation() {
        this.listOfWorkOrder = new ArrayList<>();
        this.nextID = 0;
    }

    @Override
    public WorkOrder create(WorkOrder workOrder) {
        workOrder.setId(this.nextID);
        this.nextID++;
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
    public WorkOrder findByID(int id) {
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getId() == id) {
                return workOrder;
            }
        }
        return null;
    }

    @Override
    public void update(WorkOrder workOrder) throws Exception {
        for (int i = 0; i < listOfWorkOrder.size(); i++) {
            if (this.listOfWorkOrder.get(i).getId() == workOrder.getId()) {
                this.listOfWorkOrder.set(i, workOrder);
                return;
            }
        }
    }

    @Override
    public void delete(int id) throws Exception {
        for (int i = 0; i < this.listOfWorkOrder.size(); i++) {
            if (this.listOfWorkOrder.get(i).getId() == id) {
                this.listOfWorkOrder.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfWorkOrder = new ArrayList<>();
        this.nextID = 0;
    }
}
