package com.example.exa863_management_system_2023.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CleaningTest {

    @Test
    public void testConstructor() {

        Cleaning cleaning = new Cleaning("CPU cooler cleaning", 70, 25);

        assertEquals("CPU cooler cleaning", cleaning.getName());
        assertEquals("Reattach it to ensure proper cooling and ventilation", cleaning.getDescription());
        assertEquals(70, cleaning.getPrice());
        assertEquals(25, cleaning.getCost());
        assertNotNull(cleaning.getComponents());
        assertTrue(cleaning.getComponents().isEmpty());
    }

    @Test
    public void testAddComponent() {
        Cleaning cleaning = new Cleaning("Cleaning peripheral components", "Remove dirt and grime", 70, 25);
        ComputerComponent component1 = new ComputerComponent("Keyboard", "Wireless keyboard", "Microsoft");
        component1.setID("c28c7bbe-dd45-11ed");
        ComputerComponent component2 = new ComputerComponent("Mouse", "Wireless mouse", "Maxprint");
        component2.setID("d9c0adb4-dd45-11ed");
        cleaning.addComponent(component1);
        cleaning.addComponent(component2);
        assertEquals(2, cleaning.getComponents().size());
        assertEquals(component1, cleaning.getComponents().get(0));
        assertEquals(component2, cleaning.getComponents().get(1));
    }

    @Test
    public void testEquals() {
        Cleaning cleaning1 = new Cleaning("Clean Computer", "Clean computer components", 100, 50);
        cleaning1.setID("c28c7bbe-dd45-11ed");
        Cleaning cleaning2 = new Cleaning("Clean Computer", "Clean computer components", 120, 70);
        cleaning2.setID("d9c0adb4-dd45-11ed");

        //Test equality of two different components with different IDs
        assertNotEquals(cleaning1, cleaning2);

        //Test equality of the same component
        assertEquals(cleaning1, cleaning1);
        assertEquals(cleaning2, cleaning2);

        //Null object
        assertNotEquals(null, cleaning1);
    }

    @Test
    public void testToString() {
        Cleaning cleaning = new Cleaning("Cleaning peripheral components", "Remove dirt and grime", 70, 25);
        cleaning.setID("c28c7bbe-dd45-11ed");
        String expected = "ID: c28c7bbe-dd45-11ed, Name: Cleaning peripheral components, Description: Remove dirt and grime, Price: 70, Cost: 25, Service: Cleaning, Components: []";
        String actual = cleaning.toString();
        assertEquals(expected, actual);
    }
}