package com.example.exa863_management_system_2023.model;

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

}