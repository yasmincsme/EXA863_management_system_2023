package com.example.exa863_management_system_2023.model;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BuildingTest {

    private final List<ComputerComponent> stock = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        ComputerComponent component1 = new ComputerComponent("CPU", "Intel", "ABC123", 100, 150, 10);
        component1.setID("11221ccc-dd3f-11ed");
        ComputerComponent component2 = new ComputerComponent("GPU", "Nvidia", "XYZ789", 800, 1000, 5);
        component2.setID("20012e04-dd3f-11ed");
        ComputerComponent component3 = new ComputerComponent("RAM", "Corsair", "DEF456", 50, 70, 20);
        component3.setID("11221ccc-dd3f-11ed");
        stock.add(component1);
        stock.add(component2);
        stock.add(component3);

        assertEquals(3, stock.size());
    }

    @Test
    public void testConstructor() {

        Building building = new Building("Change de Hard Disk", "Safely remove the old hard disk and install a new one", 120, 60);

        assertEquals("Change de Hard Disk", building.getName());
        assertEquals("Safely remove the old hard disk and install a new one", building.getDescription());
        assertEquals(120, building.getPrice());
        assertEquals(60, building.getCost());
        assertNotNull(building.getUsedComponents());
        assertTrue(building.getUsedComponents().isEmpty());
    }

    @Test
    public void testEquals() {
        Building building1 = new Building("Change de Hard Disk", "Safely remove the old hard disk and install a new one", 120, 60);
        building1.setID("68e7e64c-dd4b-11ed");
        Building building2 = new Building("RAM Upgrade", "Install additional RAM modules to increase memory capacity", 60, 30);
        building2.setID("72980f1e-dd4b-11ed");

        //Test equality of two different components with different IDs
        assertNotEquals(building1, building2);

        //Test equality of the same component
        assertEquals(building1, building1);
        assertEquals(building2, building2);

        //Null object
        assertNotEquals(null, building1);
    }

    @Test
    public void testToString() {
        Building building = new Building("Change de Hard Disk", "Safely remove the old hard disk and install a new one", 120, 60);
        building.setID("68e7e64c-dd4b-11ed");
        String expected = "ID: 68e7e64c-dd4b-11ed, Name: Change de Hard Disk, Description: Safely remove the old hard disk and install a new one, Price: 120, Cost: 60, Service: Building, Components: []";
        String actual = building.toString();
        assertEquals(expected, actual);
    }
}