package com.example.exa863_management_system_2023.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CleaningTest {

    @Test
    public void testConstructor() {

        Cleaning cleaning = new Cleaning("CPU cooler cleaning", "c28c7bbe-dd45-11ed", 70.00, 25.00);

        assertNull(cleaning.getID());
        assertEquals("c28c7bbe-dd45-11ed", cleaning.getWorkOrderID());
        assertEquals("CPU cooler cleaning", cleaning.getDescription());
        assertEquals(70, cleaning.getPrice(), 3);
        assertEquals(25, cleaning.getCost(), 3);
    }

    @Test
    public void testEquals() {
        Cleaning cleaning1 = new Cleaning("CPU cooler cleaning", "f28c7bbe-dd45-11ed", 70.00, 25.00);
        cleaning1.setID("c28c7bbe-dd45-11ed");
        Cleaning cleaning2 = new Cleaning("Clean keyboard", "f28c7bbe-dd45-11ed", 35.00, 5.00);
        cleaning2.setID("d9c0adb4-dd45-11ed");
        Cleaning cleaning3 = new Cleaning("Cleaning peripheral components", "f28c7bbe-dd45-11ed", 60.00, 10.00);
        cleaning3.setID("c28c7bbe-dd45-11ed");

        //Verify that two clients with the same ID are equal
        assertEquals(cleaning1, cleaning3);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(cleaning1, cleaning2);

        //Null object
        assertNotEquals(null, cleaning1);

        //Same object
        assertEquals(cleaning1, cleaning1);
        assertEquals(cleaning2, cleaning2);
        assertEquals(cleaning3, cleaning3);
    }

    @Test
    public void testToString() {
        Cleaning cleaning = new Cleaning("Cleaning peripheral components", "f28c7bbe-dd45-11ed", 70.00, 25.00);
        cleaning.setID("c28c7bbe-dd45-11ed");
        String expected = "Type: CLEANING, ID: c28c7bbe-dd45-11ed, Order's ID: f28c7bbe-dd45-11ed, Description: Cleaning peripheral components, Price: 70.0, Cost: 25.0";
        String actual = cleaning.toString();
        assertEquals(expected, actual);
    }
}