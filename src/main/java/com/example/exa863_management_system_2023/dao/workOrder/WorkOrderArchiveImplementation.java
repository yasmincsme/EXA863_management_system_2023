package com.example.exa863_management_system_2023.dao.workOrder;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Installation;
import com.example.exa863_management_system_2023.model.WorkOrder;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderArchiveImplementation implements WorkOrderDAO {
    private List<WorkOrder> listOfWorkOrder;
    private FileManager<String> fileManager;

    public WorkOrderArchiveImplementation() {
        fileManager = new FileManager<>("orders.dat");
        listOfWorkOrder = FileManager.readListFromFile("orders.dat");
    }

    @Override
    public WorkOrder create(WorkOrder workOrder) {
        workOrder.setID(Generator.generateID());
        listOfWorkOrder.add(workOrder);
        FileManager.writeListToFile(listOfWorkOrder, "orders.dat");
        return workOrder;
    }

    @Override
    public List<WorkOrder> findMany() {
        return FileManager.readListFromFile("orders.dat");
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
    public List<WorkOrder> findOpenWorkOrders() {
        List<WorkOrder> openWorkOrders = new ArrayList<WorkOrder>();
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if(workOrder.getStatus().equals("OPEN")) {
                openWorkOrders.add(workOrder);
            }
        }
        return openWorkOrders;
    }

    public WorkOrder getFirstOpenedWorkOrder() {
        List<WorkOrder> openWorkOrders = new ArrayList<>();
        for (WorkOrder workOrder : this.listOfWorkOrder) {
            if (workOrder.getStatus().equals("OPEN")) {
                return workOrder;
            }
        }
        return null;
    }

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

    @Override
    public void update(WorkOrder workOrder) throws ObjectNotFoundException {
        for (int i = 0; i < listOfWorkOrder.size(); i++) {
            if (this.listOfWorkOrder.get(i).getID().equals(workOrder.getID())) {
                this.listOfWorkOrder.set(i, workOrder);
                FileManager.writeListToFile(listOfWorkOrder, "orders.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed work order is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException{
        for (int i = 0; i < this.listOfWorkOrder.size(); i++) {
            if (this.listOfWorkOrder.get(i).getID().equals(id)) {
                this.listOfWorkOrder.remove(i);
                FileManager.writeListToFile(listOfWorkOrder, "orders.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed work order is not registered in the system");
    }

    @Override
    public void deleteMany() {
        listOfWorkOrder = new ArrayList<>();
        FileManager.writeListToFile(listOfWorkOrder, "orders.dat");
    }

    @Override
    public double getPriceByWorkOrderID(String workOrderID) {
        return DAO.getBuilding().getPriceByServices(workOrderID) + DAO.getCleaning().getPriceByServices(workOrderID) + DAO.getInstallation().getPriceByServices(workOrderID);

    }

    @Override
    public double getCostByWorkOrderID(String workOrderID) {
        return DAO.getBuilding().getCostByServices(workOrderID) + DAO.getCleaning().getCostByServices(workOrderID) + DAO.getInstallation().getCostByServices(workOrderID);
    }
}
