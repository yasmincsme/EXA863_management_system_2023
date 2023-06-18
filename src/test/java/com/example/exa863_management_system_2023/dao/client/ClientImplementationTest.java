package com.example.exa863_management_system_2023.dao.client;

import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Client;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ClientImplementationTest {
    private Client client1;
    private Client client2;

    @BeforeEach
    public void setUp() {
        client1 = DAO.getClient().create(new Client("John Smith", "john.smith@example.com", "245 Cold Storage Rd, Craig, Alaska 99921, USA", "password123"));
        client2 = DAO.getClient().create(new Client("Jane Dame", "jane.dame@example.com", "257 Fireweed Ln, Ketchikan, Alaska 99901, USA", "password123"));
    }

    @AfterEach
    public void tearDown() {
        DAO.getClient().deleteMany();
    }

    @Test
    public void testCreate() {
        Client actual = DAO.getClient().create(new Client("John Smith", "john.smith@example.com", "245 Cold Storage Rd, Craig, Alaska 99921, USA", "password123"));
        Client expected = DAO.getClient().findByID(actual.getID());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMany() {
        List<Client> clientList = DAO.getClient().findMany();
        int expectedLength = 2;
        assertEquals(expectedLength, clientList.size());
    }

    @Test
    public void testFindByID() {
        Client actual1 = DAO.getClient().findByID(client1.getID());
        assertEquals(client1, actual1);

        Client actual2 = DAO.getClient().findByID((client2.getID()));
        assertEquals(client2, actual2);
    }

    @Test
    public void testFindByName() {
        List<Client> actual1 = DAO.getClient().findByName(client1.getName());
        assertEquals(client1, actual1.get(0));

        List<Client> actual2 = DAO.getClient().findByName(client2.getName());
        assertEquals(client2, actual2.get(0));
    }

    @Test
    public void testUpdate() {
        String client1ID = client1.getID();
        Client newClient1 = DAO.getClient().create(new Client("John Smith", "john.smith@example.com", "245 Cold Storage Rd, Craig, Alaska 99921, USA", "password123"));
        newClient1.setID(client1ID);

        try {
            DAO.getClient().update(newClient1);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        assertEquals(newClient1, DAO.getClient().findByID(client1ID));
    }

    @Test
    public void testDelete() {
        try {
            DAO.getClient().delete(client1.getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        List<Client> clientList = DAO.getClient().findMany();
        int expectedLength = 1;
        assertEquals(1, clientList.size());
        assertEquals(client2, clientList.get(0));
    }

    @Test
    public void testDeleteMany() {
        DAO.getClient().deleteMany();
        List<Client> clientList = DAO.getClient().findMany();
        assertEquals(0, clientList.size());
    }
}