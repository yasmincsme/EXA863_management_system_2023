package com.example.exa863_management_system_2023.dao.computerComponent;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.exa863_management_system_2023.model.ComputerComponent;

class ComponentListImplementationTest {

    private ComponentListImplementation componentList;
    private ComputerComponent component;

    @BeforeEach
    void setUp() throws Exception {
        componentList = new ComponentListImplementation();
        component = new ComputerComponent(100.0);
        component.setName("Test Component");
        component.setDescription("This is a test component");
        component.setManufacturer("Test Manufacturer");
        component.setSerialNumber("123456789");
        component.setPrice(150.0);
        component.setQuantity(10);
    }

    @Test
    void testCreate() {
        componentList.create(component);
        List<ComputerComponent> componentListResult = componentList.findMany();
        assertEquals(1, componentListResult.size());
        assertEquals(component, componentListResult.get(0));
    }

    @Test
    void testFindMany() {
        componentList.create(component);
        List<ComputerComponent> componentListResult = componentList.findMany();
        assertEquals(1, componentListResult.size());
        assertEquals(component, componentListResult.get(0));
    }

    @Test
    void testFindByID() {
        componentList.create(component);
        ComputerComponent componentResult = componentList.findByID(component.getID());
        assertEquals(component, componentResult);
    }

    @Test
    void testFindByName() {
        componentList.create(component);
        List<ComputerComponent> componentListResult = componentList.findByName(component.getName());
        assertEquals(1, componentListResult.size());
        assertEquals(component, componentListResult.get(0));
    }

    @Test
    void testUpdate() throws Exception {
        componentList.create(component);
        component.setDescription("Updated description");
        componentList.update(component);
        ComputerComponent componentResult = componentList.findByID(component.getID());
        assertEquals(component, componentResult);
    }

    @Test
    void testDelete() {
        componentList.create(component);
        componentList.delete(component.getID());
        List<ComputerComponent> componentListResult = componentList.findMany();
        assertEquals(0, componentListResult.size());
    }

    @Test
    void testDeleteMany() {
        componentList.create(component);
        componentList.deleteMany();
        List<ComputerComponent> componentListResult = componentList.findMany();
        assertEquals(0, componentListResult.size());
    }

    @Test
    void testDeleteSome() {
        componentList.create(component);
        componentList.deleteSome(component.getID(), 5);
        ComputerComponent componentResult = componentList.findByID(component.getID());
        assertEquals(5, componentResult.getQuantity());
    }

}
