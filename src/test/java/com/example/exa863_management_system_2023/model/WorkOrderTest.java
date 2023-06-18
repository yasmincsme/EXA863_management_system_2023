package com.example.exa863_management_system_2023.model;

import com.example.exa863_management_system_2023.exceptions.WorkOrderWithoutTechnician;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkOrderTest {

    @Test
    public void testConstructor() {

        WorkOrder workOrder = new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade");
        workOrder.setCreatedAt("24-04-2023 14:05:35.377");

        assertNull(workOrder.getID());
        assertEquals("c28c7bbe-dd45-11ed", workOrder.getClientID());
        assertNull(workOrder.getTechnicianID());
        assertEquals("OPEN", workOrder.getStatus());
        assertEquals("Computer hardware upgrade", workOrder.getDescription());
        assertEquals("24-04-2023 14:05:35.377", workOrder.getCreatedAt());
        assertNull(workOrder.getFinishedAt());
        assertEquals(0, workOrder.getClientSatisfaction());
        assertEquals(0.00, workOrder.getPrice());
        assertEquals(0.00, workOrder.getCost());
        assertNull(workOrder.getPaymentMethod());
    }
    @Test
    public void testReopen() {
        WorkOrder workOrder = new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade");
        workOrder.setID("d9c0adb4-dd45-11ed");
        workOrder.setTechnicianID("6e056406-dc97-11ed");
        workOrder.setCreatedAt("24-04-2023 14:05:35.377");
        workOrder.setPaymentMethod("PIX");

        try {
            workOrder.finish();
        } catch (WorkOrderWithoutTechnician exception) {
            throw new RuntimeException(exception);
        }

        assertEquals("FINISHED", workOrder.getStatus());
        assertNotNull(workOrder.getFinishedAt());

        workOrder.reopen();
        assertEquals("OPEN", workOrder.getStatus());
        assertNull(workOrder.getFinishedAt());
    }
    @Test
    public void testFinish() {
        WorkOrder workOrder = new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade");
        workOrder.setID("d9c0adb4-dd45-11ed");
        workOrder.setTechnicianID("6e056406-dc97-11ed");
        workOrder.setCreatedAt("24-04-2023 14:05:35.377");
        workOrder.setPaymentMethod("PIX");

        try {
            workOrder.finish();
        } catch (WorkOrderWithoutTechnician exception) {
            throw new RuntimeException(exception);
        }
        assertEquals("FINISHED", workOrder.getStatus());
        assertNotNull(workOrder.getFinishedAt());
    }

    @Test
    public void testCancel() {
        WorkOrder workOrder = new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade");
        workOrder.setID("d9c0adb4-dd45-11ed");
        workOrder.setTechnicianID("6e056406-dc97-11ed");
        workOrder.setCreatedAt("24-04-2023 14:05:35.377");
        workOrder.setPaymentMethod("PIX");

        workOrder.cancel();
        assertEquals("CANCELLED", workOrder.getStatus());
        assertNotNull(workOrder.getFinishedAt());
    }

    @Test
    public void TestGetWaitingTime() {
        WorkOrder workOrder = new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade");
        workOrder.setID("d9c0adb4-dd45-11ed");
        workOrder.setTechnicianID("6e056406-dc97-11ed");

        workOrder.setCreatedAt("24-04-2023 14:05:35.377");
        workOrder.setFinishedAt("24-05-2023 14:05:35.377");

        assertEquals(30, workOrder.getWaitingTime());
    }

    @Test
    public void testEquals() {
        WorkOrder workOrder1 = new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade");
        workOrder1.setID("d9c0adb4-dd45-11ed");
        WorkOrder workOrder2 = new WorkOrder("c28c7bbe-dd45-11ed", "Provide new keyboard");
        workOrder2.setID("6e056406-dc97-11ed");
        WorkOrder workOrder3 = new WorkOrder("c28c7bbe-dd45-11ed", "Install new SO");
        workOrder3.setID("d9c0adb4-dd45-11ed");

        //Verify that two clients with the same ID are equal
        assertEquals(workOrder1, workOrder3);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(workOrder1, workOrder2);

        //Null object
        assertNotEquals(null, workOrder1);

        //Same object
        assertEquals(workOrder1, workOrder1);
        assertEquals(workOrder2, workOrder2);
        assertEquals(workOrder3, workOrder3);
    }

    @Test
    public void testToString() {
        WorkOrder workOrder = new WorkOrder("c28c7bbe-dd45-11ed", "Computer hardware upgrade");
        workOrder.setID("d9c0adb4-dd45-11ed");
        workOrder.setTechnicianID("6e056406-dc97-11ed");
        workOrder.setCreatedAt("24-04-2023 14:05:35.377");
        workOrder.setFinishedAt("24-05-2023 14:05:35.377");
        workOrder.setPaymentMethod("PIX");

        try {
            workOrder.finish();
        } catch (WorkOrderWithoutTechnician exception) {
            throw new RuntimeException(exception);
        }

        String expected = "ID: d9c0adb4-dd45-11ed, Client ID: c28c7bbe-dd45-11ed, Technician ID: 6e056406-dc97-11ed, Status: FINISHED, Description: Computer hardware upgrade, Creation Date: 24-04-2023 14:05:35.377, Completion Date: 24-05-2023 14:05:35.377, Satisfaction Score: 0, Price: 0.0, Cost: 0.0,Payment Method: PIX";
        String actual = workOrder.toString();
    }
}