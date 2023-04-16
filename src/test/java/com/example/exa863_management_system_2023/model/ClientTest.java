package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testConstructor() {
        Client client = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");

        assertEquals("Matthew Delgado", client.getName());
        assertEquals("matthew.delgado@example.com", client.getEmail());
        assertEquals("Belmont, California(CA), 94002", client.getAddress());
        assertEquals("(262) 633-9393", client.getPhone());
    }

    @Test
    public void testToString() {
        Client client = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        client.setID("6e056406-dc97-11ed");
        String expected = "ID: 6e056406-dc97-11ed, Name: Matthew Delgado, Email: matthew.delgado@example.com, Address: Belmont, California(CA), 94002, Phone: (262) 633-9393";
        String actual = client.toString();
        assertEquals(expected, actual);
    }
}