package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.model.Client;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ClientListImplementationTest {

    private ClientListImplementation clientListImplementation;

    @Before
    public void setUp() {
        clientListImplementation = new ClientListImplementation();
    }

    @Test
    public void testCreate() {
        Client client = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        client.setID("72980f1e-dd4b-11ed");
        clientListImplementation.create(client);
        assertEquals(client, clientListImplementation.findByID(client.getID()));
    }

    @Test
    public void testFindMany() {
        Client client1 = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        client1.setID("72980f1e-dd4b-11ed");
        clientListImplementation.create(client1);

        Client client2 = new Client("Jane Doe", "jane.doe@example.com", "janedoe", "password");
        client2.setID("1fb2dbb0-dd89-11ed");
        clientListImplementation.create(client2);

        List<Client> clients = clientListImplementation.findMany();
        assertEquals(2, clients.size());
        assertEquals(client1, clients.get(0));
        assertEquals(client2, clients.get(1));
    }

    @Test
    public void testFindByID() {
        Client client = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        client.setID("72980f1e-dd4b-11ed");

        clientListImplementation.create(client);
        assertEquals(client, clientListImplementation.findByID(client.getID()));
        assertNull(clientListImplementation.findByID("non-existent-id"));
    }

    @Test
    public void testFindByName() {
        Client client1 = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        client1.setID("72980f1e-dd4b-11ed");
        clientListImplementation.create(client1);

        Client client2 = new Client("Jane Doe", "jane.doe@example.com", "janedoe", "password");
        client2.setID("1fb2dbb0-dd89-11ed");
        clientListImplementation.create(client2);

        List<Client> clients = clientListImplementation.findByName("John");

        assertEquals(2, clients.size());
        assertEquals(client1, clients.get(0));
        assertEquals(client2, clients.get(1));
    }

    @Test
    public void testUpdate() {
        Client client1 = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        client1.setID("72980f1e-dd4b-11ed");
        clientListImplementation.create(client1);

        Client client2 = new Client("Jane Doe", "jane.doe@example.com", "janedoe", "password");
        client2.setID("1fb2dbb0-dd89-11ed");
        clientListImplementation.create(client2);

        client1.setName("Smith");
        clientListImplementation.update(client1);
        assertEquals(client1, clientListImplementation.findByID(client1.getID()));
    }

    @Test
    public void testDelete() {
        Client client = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        clientListImplementation.create(client);
        clientListImplementation.delete(client.getID());
        assertNull(clientListImplementation.findByID(client.getID()));
    }

    @Test
    public void testDeleteMany() {
        Client client1 = new Client("Matthew Delgado", "matthew.delgado@example.com", "Belmont, California(CA), 94002", "(262) 633-9393");
        clientListImplementation.create(client1);
        Client client2 = new Client("Jane Doe", "jane.doe@example.com", "janedoe", "password");
        clientListImplementation.create(client2);
        clientListImplementation.deleteMany();
        List<Client> clients = clientListImplementation.findMany();
        assertEquals(0, clients.size());
    }
}
