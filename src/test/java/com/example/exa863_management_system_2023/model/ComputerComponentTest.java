package com.example.exa863_management_system_2023.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ComputerComponentTest {

    @Test
    public void testConstructor() {

        ComputerComponent component = new ComputerComponent("CPU", "Central Processing Unit", "Intel", "12345", 100, 200, 5);

        assertEquals("CPU", component.getName());
        assertEquals("Central Processing Unit", component.getDescription());
        assertEquals("Intel", component.getManufacturer());
        assertEquals("12345", component.getSerialNumber());
        assertEquals(100, component.getUnitCost());
        assertEquals(200, component.getUnitPrice());
        assertEquals(5, component.getQuantity());
    }
    @Test
    public void testEquals() {
        ComputerComponent component1 = new ComputerComponent("CPU", "Intel Core i7", "Intel", "ABC123", 100, 150, 10);
        ComputerComponent component2 = new ComputerComponent("GPU", "Nvidia GeForce RTX 3080", "Nvidia", "XYZ789", 800, 1000, 5);
        ComputerComponent component3 = new ComputerComponent("RAM", "Corsair Vengeance LPX", "Corsair", "DEF456", 50, 70, 20);

        // Test equality of two different components with different IDs
        assertNotEquals(component1, component2);

        // Test equality of two different components with the same ID
        assertNotEquals(component1, component3);

        // Test equality of the same component
        assertEquals(component1, component1);
        assertEquals(component2, component2);
        assertEquals(component3, component3);
    }
}
