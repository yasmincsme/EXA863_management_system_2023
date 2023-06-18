package com.example.exa863_management_system_2023.model;

import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BuildingTest {

    @Test
    public void testConstructor() {

        Building building = new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00);

        assertNull(building.getID());
        assertEquals("c28c7bbe-dd45-11ed", building.getWorkOrderID());
        assertEquals("Switch the HD", building.getDescription());
        assertEquals(70.00, building.getPrice(), 3);
        assertEquals(25.00, building.getCost(), 3);
        assertTrue(building.getUsedComponents().isEmpty());
    }

    @Test
    public void testAddComponent() {
        Building building = new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00);
        building.setID("c28c7bbe-dd45-11ed");
        ComputerComponent component1 = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 2);
        component1.setID("a908ffa4-dd37-11ed");
        ComputerComponent component2 = new ComputerComponent("RAM", "Intel", "XYZ456", 300.00, 200.00, 2);
        component2.setID("ed198b64-dd37-11ed");

        building.addComponent(component1);
        building.addComponent(component2);

        assertEquals(2, building.getUsedComponents().size());
    }

    @Test
    public void testRemoveComponent() {
        Building building = new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00);
        building.setID("c28c7bbe-dd45-11ed");

        ComputerComponent component1 = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 2);
        component1.setID("a908ffa4-dd37-11ed");
        ComputerComponent component2 = new ComputerComponent("RAM", "Intel", "XYZ456", 300.00, 200.00, 2);
        component2.setID("ed198b64-dd37-11ed");

        building.addComponent(component1);
        building.addComponent(component2);

        assertEquals(2, building.getUsedComponents().size());

        try {
            building.removeComponent(building.getUsedComponents().get(0).getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }

        assertEquals(1, building.getUsedComponents().size());
    }

    @Test
    public void testIncrease() {
        Building building = new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00);
        building.setID("c28c7bbe-dd45-11ed");

        assertTrue(building.getUsedComponents().isEmpty());

        ComputerComponent component1 = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 2);
        component1.setID("a908ffa4-dd37-11ed");
        ComputerComponent component2 = new ComputerComponent("RAM", "Intel", "XYZ456", 300.00, 200.00, 2);
        component2.setID("ed198b64-dd37-11ed");

        ArrayList<ComputerComponent> usedComponents = new ArrayList<>();
        usedComponents.add(component1);
        usedComponents.add(component2);
        building.setUsedComponents(usedComponents);

        assertFalse(building.getUsedComponents().isEmpty());

        building.increasePrice();
        assertEquals(1070.00, building.getPrice(), 3);

        building.increaseCost();
        assertEquals(625.00, building.getCost(), 3);

    }

    @Test
    public void testDecrease() {
        Building building = new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00);
        building.setID("c28c7bbe-dd45-11ed");

        assertTrue(building.getUsedComponents().isEmpty());

        ComputerComponent component1 = new ComputerComponent("CPU", "Intel", "ABC123", 200.00, 100.00, 2);
        component1.setID("a908ffa4-dd37-11ed");
        ComputerComponent component2 = new ComputerComponent("RAM", "Intel", "XYZ456", 300.00, 200.00, 2);
        component2.setID("ed198b64-dd37-11ed");

        ArrayList<ComputerComponent> usedComponents = new ArrayList<>();
        usedComponents.add(component1);
        usedComponents.add(component2);
        building.setUsedComponents(usedComponents);

        assertFalse(building.getUsedComponents().isEmpty());

        building.increasePrice();
        assertEquals(1070.00, building.getPrice(), 3);

        building.increaseCost();
        assertEquals(625.00, building.getCost(), 3);

        building.decreasePrice();
        assertEquals(70.0, building.getPrice(), 3);

        building.decreaseCost();
        assertEquals(25.0, building.getCost(), 3);

        usedComponents.remove(component1);
        usedComponents.remove(component2);
        building.setUsedComponents(usedComponents);

        assertTrue(building.getUsedComponents().isEmpty());
    }

    @Test
    public void testEquals() {
        Building building1 = new Building("Switch the HD", "c28c7bbe-dd45-11ed", 70.00, 25.00);
        building1.setID("c28c7bbe-dd45-11ed");
        Building building2 = new Building("Switch the RAM", "c28c7bbe-dd45-11ed", 90.00, 65.00);
        building2.setID("d9c0adb4-dd45-11ed");
        Building building3 = new Building("Switch the CPU", "c28c7bbe-dd45-11ed", 300.00, 120.00);
        building3.setID("c28c7bbe-dd45-11ed");

        //Verify that two clients with the same ID are equal
        assertEquals(building1, building3);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(building1, building2);

        //Null object
        assertNotEquals(null, building1);

        //Same object
        assertEquals(building1, building1);
        assertEquals(building2, building2);
        assertEquals(building3, building3);
    }

    @Test
    public void testToString() {
        Building building = new Building("Switch the HD", "f28c7bbe-dd45-11ed", 70.00, 25.00);
        building.setID("c28c7bbe-dd45-11ed");
        String expected = "Type: BUILDING, ID: c28c7bbe-dd45-11ed, Order's ID: f28c7bbe-dd45-11ed, Description: Switch the HD, Price: 70.0, Cost: 25.0, Used Components: []";
        String actual = building.toString();
        assertEquals(expected, actual);
    }
}