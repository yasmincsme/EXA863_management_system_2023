package com.example.exa863_management_system_2023.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

public class InstallationTest {

    @Test
    public void testConstructor() {

        Installation installation = new Installation("Install Windows 10", 70.00, 25.00, "Windows 8");

        assertNull(installation.getID());
        assertEquals("Install Windows 10", installation.getDescription());
        assertEquals(70.00, installation.getPrice(), 3);
        assertEquals(25.00, installation.getCost(), 3);
        assertEquals("Windows 8", installation.getOperatingSystem());
    }

    @Test
    public void testEquals() {
        Installation installation1 = new Installation("Install Windows 10", 70.00, 25.00, "Windows 8");
        installation1.setID("c28c7bbe-dd45-11ed");
        Installation installation2 = new Installation("Install Microsoft Word", 70.00, 25.00, "Windows 10");
        installation2.setID("d9c0adb4-dd45-11ed");
        Installation installation3 = new Installation("Install Quartus", 70.00, 25.00, "Xubuntu");
        installation3.setID("c28c7bbe-dd45-11ed");

        //Verify that two clients with the same ID are equal
        assertEquals(installation1, installation3);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(installation1, installation2);

        //Null object
        assertNotEquals(null, installation1);

        //Same object
        assertEquals(installation1, installation1);
        assertEquals(installation2, installation2);
        assertEquals(installation3, installation3);
    }

    @Test
    public void testToString() {
        Installation installation = new Installation("Install Windows 10", 70.00, 25.00, "Windows 8");
        installation.setID("c28c7bbe-dd45-11ed");
        String expected = "Type: INSTALLATION, ID: c28c7bbe-dd45-11ed, Description: Install Windows 10, Price: 70.0, Cost: 25.0, Operating System: Windows 8";
        String actual = installation.toString();
        assertEquals(expected, actual);
    }
}