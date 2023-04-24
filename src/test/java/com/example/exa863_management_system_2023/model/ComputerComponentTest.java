package com.example.exa863_management_system_2023.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerComponentTest {

    @Test
    public void testConstructor() {
        ComputerComponent component = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 5);

        assertNull(component.getID());
        assertEquals("CPU", component.getName());
        assertEquals("Intel", component.getManufacturer());
        assertEquals("ABC123", component.getSerialNumber());
        assertEquals(200.00, component.getUnitPrice(), 3);
        assertEquals(100.00, component.getUnitCost(), 3);
        assertEquals(5, component.getQuantity());
    }

    @Test
    public void testGetPrice() {
        ComputerComponent component = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 5);
        assertEquals(1000.00, component.getPrice());
    }

    @Test
    public void testGetCost() {
        ComputerComponent component = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 5);
        assertEquals(500.00, component.getCost());
    }

    @Test
    public void testEquals() {
        ComputerComponent component1 = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 5);
        component1.setID("a908ffa4-dd37-11ed");
        ComputerComponent component2 = new ComputerComponent("RAM", "Intel", "XYZ456", 300.60, 259.00, 2);
        component2.setID("ed198b64-dd37-11ed");
        ComputerComponent component3 = new ComputerComponent("Keyboard", "Ryzen", "QWE799", 256.90, 150.00, 9);
        component3.setID("a908ffa4-dd37-11ed");


        //Verify that two clients with the same ID are equal
        assertEquals(component1, component3);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(component1, component2);

        //Null object
        assertNotEquals(null, component1);

        //Same object
        assertEquals(component1, component1);
        assertEquals(component2, component2);
        assertEquals(component3, component3);
    }

    @Test
    public void testToString() {
        ComputerComponent component = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 5);
        component.setID("6e056406-dc97-11ed");
        String expected = "ID: 6e056406-dc97-11ed, Name: CPU, Manufacturer: Intel, Serial Number: ABC123, Unit Price: 200.0, Unit Cost: 100.0, Quantity: 5";
        String actual = component.toString();
        assertEquals(expected, actual);
    }

}
