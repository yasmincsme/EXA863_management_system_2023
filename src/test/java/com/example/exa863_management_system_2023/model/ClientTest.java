package com.example.exa863_management_system_2023.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testConstructor() {
        Client client = new Client("Matthew Delgado", "math.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");

        assertEquals("Matthew Delgado", client.getName());
        assertEquals("math.delgado@example.com", client.getEmail());
        assertEquals("Belmont, California(CA), 94002", client.getAddress());
        assertEquals("(262) 633-9393", client.getPhone());
    }

    @Test
    public void testEquals() {
        Client client1 = new Client("John Smith", "john.smith@example.com", "245 Cold Storage Rd, Craig, Alaska 99921, USA", "password");
        client1.setID("a908ffa4-dd37-11ed");
        Client client2 = new Client("Jane Doe", "jane.doe@example.com", "1536 Stellar Dr, Kenai, Alaska 99611, USA", "password");
        client2.setID("ed198b64-dd37-11ed");
        Client client3 = new Client("John Smith", "john.smith@example.com", "257 Fireweed Ln, Ketchikan, Alaska 99901, USA", "password");
        client3.setID("a908ffa4-dd37-11ed");


        //Verify that two clients with the same ID are equal
        assertEquals(client1, client3);

        //Verify that two clients with different IDs are not equal
        assertNotEquals(client1, client2);

        //Null object
        assertNotEquals(null, client1);

        //Same object
        assertEquals(client1, client1);
        assertEquals(client2, client2);
        assertEquals(client3, client3);
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