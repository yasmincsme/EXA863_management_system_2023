package com.example.exa863_management_system_2023.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ComputerComponentTest {

    @Test
    public void testFirstConstructor() {

        ComputerComponent component = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 5);

        assertEquals("CPU", component.getName());
        assertEquals("Intel", component.getManufacturer());
        assertEquals("ABC123", component.getSerialNumber());
        assertEquals(200.00, component.getUnitPrice());
        assertEquals(100.00, component.getUnitCost());
        assertEquals(5, component.getQuantity());
    }

    @Test
    public void testGetCost() {
        ComputerComponent component = new ComputerComponent("CPU", "Intel", "ABC123", 100, 200, 5);
        assertEquals(500, component.getCost());
    }

    @Test
    public void testGetPrice() {
        ComputerComponent component = new ComputerComponent("CPU", "Intel", "ABC123", 100, 200, 5);
        assertEquals(1000, component.getPrice());
    }

    @Test
    public void testEquals() {
        ComputerComponent component1 = new ComputerComponent("CPU", "Intel", "ABC123", 100, 150, 10);
        component1.setID("11221ccc-dd3f-11ed");
        ComputerComponent component2 = new ComputerComponent("GPU", "Nvidia", "XYZ789", 800, 1000, 5);
        component2.setID("20012e04-dd3f-11ed");

        //Test equality of two different components with different IDs
        assertNotEquals(component1, component2);

        //Test equality of the same component
        assertEquals(component1, component1);
        assertEquals(component2, component2);

        //Null object
        assertNotEquals(null, component1);
    }

    @Test
    public void testToString() {
        ComputerComponent component = new ComputerComponent("CPU", "Intel", "ABC123", 100, 200, 5);
        component.setID("6e056406-dc97-11ed");
        String expected = "ID: 6e056406-dc97-11ed, Name: CPU, Manufacturer: Intel, Serial Number: ABC123, Unit Cost: 100, Unit Price: 200, Quantity: 5";
        String actual = component.toString();
        assertEquals(expected, actual);
    }

}
