package com.example.exa863_management_system_2023.dao.workOrder;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.WorkOrder;

import java.util.List;

public interface WorkOrderDAO extends CRUD<WorkOrder, Exception> {
    public List<WorkOrder> findOpenWorkOrders();
    public WorkOrder getFirstOpenedWorkOrder();
    public List<WorkOrder> findOrderByClientID(String id);
    public WorkOrder findOrderByTechnicianID(String id);
}
