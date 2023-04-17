package com.example.exa863_management_system_2023.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkOrderTest {

    private WorkOrder workOrder;
    private String clientID;
    private String description;
    private Building building;
    private Cleaning cleaning;
    private Installation installation;

    @BeforeEach
    void setUp() {
        clientID = "c28c7bbe-dd45-11ed";
        description = "Install additional RAM modules to increase memory capacity";
        workOrder = new WorkOrder(clientID, description);
        building = new Building("Change RAM", "Safely remove the RAM memory and install a new one", 120, 60);
        cleaning = new Cleaning("Cleaning peripheral components", "Remove dirt and grime", 70, 25);
        installation = new Installation("Installation of the Office package and antivirus", "Provide a seamless and hassle-free installation of the Microsoft Office package and a reliable antivirus software", 100, 0, "Windows");
    }

    @Test
    void testAddBuildingService() {
        workOrder.addBuildingService(building);
        List<Building> expectedBuildingList = new ArrayList<>();
        expectedBuildingList.add(building);
        assertEquals(expectedBuildingList, workOrder.getBuildindList());
    }

    @Test
    void testAddCleaningService() {
        workOrder.addCleaningService(cleaning);
        List<Cleaning> expectedCleaningList = new ArrayList<>();
        expectedCleaningList.add(cleaning);
        assertEquals(expectedCleaningList, workOrder.getCleaningList());
    }

    @Test
    void testAddInstallationService() {
        workOrder.addInstallationService(installation);
        List<Installation> expectedInstallationList = new ArrayList<>();
        expectedInstallationList.add(installation);
        assertEquals(expectedInstallationList, workOrder.getInstallationList());
    }

    @Test
    void testGetBuildingListPrice() {
        workOrder.addBuildingService(building);
        workOrder.addBuildingService(building);
        assertEquals(200, workOrder.getBuildingListPrice());
    }

    @Test
    void testGetCleaningListPrice() {
        workOrder.addCleaningService(cleaning);
        workOrder.addCleaningService(cleaning);
        assertEquals(100, workOrder.getCleaningListPrice());
    }

    @Test
    void testGetInstallationListPrice() {
        workOrder.addInstallationService(installation);
        workOrder.addInstallationService(installation);
        assertEquals(400, workOrder.getInstallationListPrice());
    }

    @Test
    void testGetPrice() {
        workOrder.addBuildingService(building);
        workOrder.addCleaningService(cleaning);
        workOrder.addInstallationService(installation);
        assertEquals(350, workOrder.getPrice());
    }

    @Test
    void testGetBuildingListCost() {
        workOrder.addBuildingService(building);
        workOrder.addBuildingService(building);
        assertEquals(100, workOrder.getBuildingListCost());
    }

    @Test
    void testGetCleaningListCost() {
        workOrder.addCleaningService(cleaning);
        workOrder.addCleaningService(cleaning);
        assertEquals(50, workOrder.getCleaningListCost());
    }

    @Test
    void testGetInstallationListCost() {
        workOrder.addInstallationService(installation);
        workOrder.addInstallationService(installation);
        assertEquals(200, workOrder.getInstallationListCost());
    }

    @Test
    void testGetCost() {
        workOrder.addBuildingService(building);
        workOrder.addCleaningService(cleaning);
        workOrder.addInstallationService(installation);
        assertEquals(85, workOrder.getCost());
    }

    @Test
    void testStatus() {
        assertTrue(workOrder.isOnGoing());
        assertFalse(workOrder.isFinished());
        assertFalse(workOrder.isCanceled());

        workOrder.finish();
        assertFalse(workOrder.isOnGoing());
        assertTrue(workOrder.isFinished());
        assertFalse(workOrder.isCanceled());

        workOrder.cancel();
        assertFalse(workOrder.isOnGoing());
        assertFalse(workOrder.isFinished());
        assertTrue(workOrder.isCanceled());
    }

    @Test
    void waitingTime() {
        WorkOrder workOrder = new WorkOrder("c28c7bbe-dd45-11ed", "Install additional RAM modules to increase memory capacity");

        workOrder.setCreatedAt(Date.from(LocalDate.of(2023, 4, 15).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        workOrder.setFinishedAt(Date.from(LocalDate.of(2023, 4, 17).atStartOfDay(ZoneId.systemDefault()).toInstant()));

        assertEquals(2, workOrder.getWaitingTime());

    }
}
