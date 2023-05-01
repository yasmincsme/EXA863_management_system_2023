package com.example.exa863_management_system_2023.dao.workOrder;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.Exceptions.WorkOrderWithoutTechnician;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Cleaning;
import com.example.exa863_management_system_2023.model.Installation;
import com.example.exa863_management_system_2023.model.WorkOrder;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WorkOrderListImplementationTest {

    private WorkOrder workOrder1;
    private WorkOrder workOrder2;

    private Cleaning cleaning1;
    private Cleaning cleaning2;
    private Building building1;
    private Building building2;
    private Installation installation1;
    private Installation installation2;


    @BeforeEach
    public void setUp() {
        workOrder1 = DAO.getWorkOrder().create(new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade"));
        workOrder2 = DAO.getWorkOrder().create(new WorkOrder("c28c7bbe-dd45-11ed", "Provide new keyboard"));

        cleaning1 = DAO.getCleaning().create(new Cleaning("CPU cooler cleaning", workOrder1.getID(), 70.00, 25.00));
        cleaning2 = DAO.getCleaning().create(new Cleaning("Clean keyboard", workOrder2.getID(), 35.00, 5.00));

        building1 = DAO.getBuilding().create(new Building("Switch the HD", workOrder1.getID(), 70.00, 25.00));
        building2 = DAO.getBuilding().create(new Building("Switch the CPU", workOrder2.getID(), 300.00, 120.00));

        installation1 = DAO.getInstallation().create(new Installation("Install Windows 10", workOrder1.getID(), 70.00, 25.00, "Windows 8"));
        installation2 = DAO.getInstallation().create(new Installation("Install Quartus", workOrder2.getID(), 70.00, 25.00, "Xubuntu"));

    }

    @AfterEach
    public void tearDown() {
        DAO.getWorkOrder().deleteMany();
    }

    @Test
    public void testCreate() {
        WorkOrder actual = DAO.getWorkOrder().create(new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade"));
        WorkOrder expected = DAO.getWorkOrder().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<WorkOrder> workOrderList = DAO.getWorkOrder().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, workOrderList.size());
    }

    @Test
    public void testFindByID() {
        WorkOrder actual1 = DAO.getWorkOrder().findByID(workOrder1.getID());
        assertEquals(workOrder1, actual1);

        WorkOrder actual2 = DAO.getWorkOrder().findByID(workOrder2.getID());
        assertEquals(workOrder2, actual2);
    }

    @Test
    public void testFindOpenWorkOrders() {
        assertEquals(2, DAO.getWorkOrder().findOpenWorkOrders().size());
    }

    @Test
    public void testGetFirstOpenedWorkOrder() {
        assertEquals(workOrder1, DAO.getWorkOrder().getFirstOpenedWorkOrder());

        workOrder1.setTechnicianID("490a63ae-0b5a-48f3");
        workOrder2.setTechnicianID("8fde-43d051c4b8f7");

        try {
            workOrder1.finish();
        } catch (WorkOrderWithoutTechnician exception) {
            throw new RuntimeException(exception);
        }

        assertEquals(workOrder2, DAO.getWorkOrder().getFirstOpenedWorkOrder());

        try {
            workOrder2.finish();
        } catch (WorkOrderWithoutTechnician exception) {
            throw new RuntimeException(exception);
        }

        assertNull(DAO.getWorkOrder().getFirstOpenedWorkOrder());
    }

    @Test
    public void testFindOrderByClientID() {
        assertEquals(workOrder1, DAO.getWorkOrder().findOrderByClientID(workOrder1.getClientID()).get(0));
        assertEquals(workOrder2, DAO.getWorkOrder().findOrderByClientID(workOrder1.getClientID()).get(1));
    }

    @Test
    public void testFindOrderByTechnicianID() {
        workOrder1.setTechnicianID("6e056406-dc97-11ed");
        workOrder2.setTechnicianID("6e056406-dc97-11ed");
        assertEquals(workOrder1, DAO.getWorkOrder().findOrderByTechnicianID(workOrder1.getTechnicianID()).get(0));
        assertEquals(workOrder2, DAO.getWorkOrder().findOrderByTechnicianID(workOrder1.getTechnicianID()).get(1));

    }

    @Test
    public void testUpdate() {
        WorkOrder newWorkOrder1 = DAO.getWorkOrder().create(new WorkOrder("c28c7bbe-dd45-11ed", "Provide new mouse"));
        newWorkOrder1.setID(workOrder1.getID());

        try {
            DAO.getWorkOrder().update(newWorkOrder1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newWorkOrder1, DAO.getWorkOrder().findByID(workOrder1.getID()));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getWorkOrder().delete(workOrder1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<WorkOrder> workOrderList = DAO.getWorkOrder().findMany();
        assertEquals(1, workOrderList.size());
        assertEquals(workOrder2, workOrderList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getWorkOrder().deleteMany();
        List<WorkOrder> workOrderList = DAO.getWorkOrder().findMany();
        assertEquals(0, workOrderList.size());
    }

    @Test
    public void testGetPriceByWorkOrderID() {
        assertEquals(210.0, DAO.getWorkOrder().getPriceByWorkOrderID(workOrder1.getID()));
        assertEquals(405.0, DAO.getWorkOrder().getPriceByWorkOrderID(workOrder2.getID()));
    }

    @Test
    public void testGetCostByWorkOrderID() {
        assertEquals(75, DAO.getWorkOrder().getCostByWorkOrderID(workOrder1.getID()));
        assertEquals(150.0, DAO.getWorkOrder().getCostByWorkOrderID(workOrder2.getID()));
    }
}