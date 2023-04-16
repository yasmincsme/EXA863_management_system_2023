package com.example.exa863_management_system_2023.dao.workOrder;

import com.example.exa863_management_system_2023.model.Client;
import com.example.exa863_management_system_2023.model.Service;
import com.example.exa863_management_system_2023.model.Technician;
import com.example.exa863_management_system_2023.model.WorkOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkOrderListImplementationTest {

    private WorkOrderDAO workOrderDAO;

    @BeforeEach
    void setUp() {
        workOrderDAO = new WorkOrderListImplementation();
    }

    @Test
    void testCreate() {
        // Create a new work order
        WorkOrder workOrder = new WorkOrder(null);
        Client client = new Client("John Doe");
        Technician technician = new Technician("Jane Smith");
        List<Service> services = new ArrayList<>();
        services.add(new Service("Service 1", 100));
        services.add(new Service("Service 2", 200));
        Date createdAt = new Date();
        workOrder.setClient(client);
        workOrder.setTechnician(technician);
        workOrder.setServices(services);
        workOrder.setDescription("Test description");
        workOrder.setCreatedAt(createdAt);
        workOrder.setStatus("Open");

        // Save the work order
        WorkOrder savedWorkOrder = workOrderDAO.create(workOrder);

        // Check if the work order was saved correctly
        Assertions.assertNotNull(savedWorkOrder.getID());
        Assertions.assertEquals(client, savedWorkOrder.getClient());
        Assertions.assertEquals(technician, savedWorkOrder.getTechnician());
        Assertions.assertEquals(services, savedWorkOrder.getServices());
        Assertions.assertEquals("Test description", savedWorkOrder.getDescription());
        Assertions.assertEquals(createdAt, savedWorkOrder.getCreatedAt());
        Assertions.assertEquals("Open", savedWorkOrder.getStatus());
    }

    @Test
    void testFindMany() {
        // Create some work orders
        WorkOrder workOrder1 = new WorkOrder(null);
        WorkOrder workOrder2 = new WorkOrder(null);
        workOrderDAO.create(workOrder1);
        workOrderDAO.create(workOrder2);

        // Find all work orders
        List<WorkOrder> workOrders = workOrderDAO.findMany();

        // Check if the correct number of work orders was returned
        Assertions.assertEquals(2, workOrders.size());

        // Check if the work orders were returned in the correct order
        Assertions.assertEquals(workOrder1, workOrders.get(0));
        Assertions.assertEquals(workOrder2, workOrders.get(1));
    }

    @Test
    void testFindByID() {
        // Create a new work order
        WorkOrder workOrder = new WorkOrder(null);
        WorkOrder savedWorkOrder = workOrderDAO.create(workOrder);

        // Find the work order by ID
        WorkOrder foundWorkOrder = workOrderDAO.findByID(savedWorkOrder.getID());

        // Check if the correct work order was returned
        Assertions.assertEquals(savedWorkOrder, foundWorkOrder);
    }

    @Test
    void testUpdate() throws Exception {
        // Create a new work order
        WorkOrder workOrder = new WorkOrder(null);
        WorkOrder savedWorkOrder = workOrderDAO.create(workOrder);

        // Update the work order
        savedWorkOrder.setStatus("Closed");
        savedWorkOrder.setFinishedAt(new Date());
        workOrderDAO.update(savedWorkOrder);

        // Find the updated work order by ID
        WorkOrder foundWorkOrder = workOrderDAO.findByID(savedWorkOrder.getID());

        //
