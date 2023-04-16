import com.example.exa863_management_system_2023.dao.client.ClientDAO;
import com.example.exa863_management_system_2023.dao.client.ClientListImplementation;
import com.example.exa863_management_system_2023.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClientListImplementationTest {

    private ClientDAO clientDAO;

    @BeforeEach
    void setUp() {
        clientDAO = new ClientListImplementation();
    }

    @Test
    void create() {
        Client client = new Client("John Doe");
        client.setAddress("123 Main St");
        client.setPhone("555-555-5555");
        clientDAO.create(client);

        assertEquals(client, clientDAO.findByID(client.getID()));
    }

    @Test
    void findMany() {
        Client client1 = new Client("John Doe");
        clientDAO.create(client1);
        Client client2 = new Client("Jane Doe");
        clientDAO.create(client2);

        List<Client> clientList = clientDAO.findMany();
        assertTrue(clientList.contains(client1));
        assertTrue(clientList.contains(client2));
    }

    @Test
    void findByID() {
        Client client = new Client("John Doe");
        clientDAO.create(client);

        assertEquals(client, clientDAO.findByID(client.getID()));
    }

    @Test
    void findByName() {
        Client client1 = new Client("John Doe");
        clientDAO.create(client1);
        Client client2 = new Client("Jane Doe");
        clientDAO.create(client2);

        List<Client> clientList = clientDAO.findByName("John Doe");
        assertTrue(clientList.contains(client1));
        assertFalse(clientList.contains(client2));
    }

    @Test
    void update() {
        Client client = new Client("John Doe");
        clientDAO.create(client);

        client.setAddress("123 Main St");
        clientDAO.update(client);

        assertEquals("123 Main St", clientDAO.findByID(client.getID()).getAddress());
    }

    @Test
    void delete() {
        Client client = new Client("John Doe");
        clientDAO.create(client);

        clientDAO.delete(client.getID());

        assertNull(clientDAO.findByID(client.getID()));
    }

    @Test
    void deleteMany() {
        Client client1 = new Client("John Doe");
        clientDAO.create(client1);
        Client client2 = new Client("Jane Doe");
        clientDAO.create(client2);

        clientDAO.deleteMany();

        assertNull(clientDAO.findByID(client1.getID()));
        assertNull(clientDAO.findByID(client2.getID()));
    }

}
