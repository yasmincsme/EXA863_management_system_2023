package com.example.exa863_management_system_2023.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

public class InstallationTest {

    @Test
    public void testConstructor() {

        Installation installation = new Installation("Installation of the Office package and antivirus", "Provide a seamless and hassle-free installation of the Microsoft Office package and a reliable antivirus software to protect the computer", 100, 0, "Windows");

        assertEquals("Installation of the Office package and antivirus", installation.getName());
        assertEquals("Provide a seamless and hassle-free installation of the Microsoft Office package and a reliable antivirus software to protect the computer", installation.getDescription());
        assertEquals(100, installation.getPrice());
        assertEquals(0, installation.getCost());
        assertEquals("Windows", installation.getOperatingSystem());
        assertNotNull(installation.getPrograms());
        assertTrue(installation.getPrograms().isEmpty());
    }

    @Test
    public void testAddProgram() {
        Installation installation = new Installation("Installation of the Office package and antivirus", "Provide a seamless and hassle-free installation of the Microsoft Office package and a reliable antivirus software to protect the computer", 100, 0, "Windows");
        String program1 = "Microsoft Word";
        String program2 = "Microsoft PowerPoint";
        String program3 = "McAfee";
        installation.addProgram(program1);
        installation.addProgram(program2);
        installation.addProgram(program3);
        assertEquals(3, installation.getPrograms().size());
        assertEquals(program1, installation.getPrograms().get(0));
        assertEquals(program2, installation.getPrograms().get(1));
        assertEquals(program3, installation.getPrograms().get(2));
    }

    @Test
    public void testEquals() {
        Installation installation1 = new Installation("Installation of the Office package and antivirus", "Provide a seamless and hassle-free installation of the Microsoft Office package and a reliable antivirus software to protect the computer", 100, 0, "Windows");
        installation1.setID("68e7e64c-dd4b-11ed");
        Installation installation2 = new Installation("Browser Setup", "Install and configure your preferred web browser", 50, 0, "MacOS");
        installation2.setID("72980f1e-dd4b-11ed");

        //Test equality of two different components with different IDs
        assertNotEquals(installation1, installation2);

        //Test equality of the same component
        assertEquals(installation1, installation1);
        assertEquals(installation2, installation2);

        //Null object
        assertNotEquals(null, installation1);
    }

    @Test
    public void testToString() {
        Installation installation = new Installation("Installation of the Office package and antivirus", "Provide a seamless and hassle-free installation of the Microsoft Office package and a reliable antivirus software to protect the computer", 100, 0, "Windows");
        installation.setID("68e7e64c-dd4b-11ed");
        String expected = "ID: 68e7e64c-dd4b-11ed, Name: Installation of the Office package and antivirus, Description: Provide a seamless and hassle-free installation of the Microsoft Office package and a reliable antivirus software to protect the computer, Price: 100, Cost: 0, Service: Installation, Programs: [], Operating System: Windows";
        String actual = installation.toString();
        assertEquals(expected, actual);
    }
}