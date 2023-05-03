package com.example.exa863_management_system_2023.dao;

import com.example.exa863_management_system_2023.dao.building.BuildingArchiveImplementation;
import com.example.exa863_management_system_2023.dao.building.BuildingDAO;
import com.example.exa863_management_system_2023.dao.building.BuildingListImplementation;
import com.example.exa863_management_system_2023.dao.cleaning.CleaningArchiveImplementation;
import com.example.exa863_management_system_2023.dao.cleaning.CleaningDAO;
import com.example.exa863_management_system_2023.dao.cleaning.CleaningListImplementation;
import com.example.exa863_management_system_2023.dao.client.ClientArchiveImplementation;
import com.example.exa863_management_system_2023.dao.client.ClientDAO;
import com.example.exa863_management_system_2023.dao.client.ClientListImplementation;
import com.example.exa863_management_system_2023.dao.computerComponent.ComponentArchiveImplementation;
import com.example.exa863_management_system_2023.dao.computerComponent.ComponentListImplementation;
import com.example.exa863_management_system_2023.dao.computerComponent.ComputerComponentDAO;
import com.example.exa863_management_system_2023.dao.employee.EmployeeArchiveImplementation;
import com.example.exa863_management_system_2023.dao.employee.EmployeeDAO;
import com.example.exa863_management_system_2023.dao.employee.EmployeeListImplementation;
import com.example.exa863_management_system_2023.dao.installation.InstallationArchiveImplementation;
import com.example.exa863_management_system_2023.dao.installation.InstallationDAO;
import com.example.exa863_management_system_2023.dao.installation.InstallationListImplementation;
import com.example.exa863_management_system_2023.dao.manager.ManagerArchiveImplementation;
import com.example.exa863_management_system_2023.dao.manager.ManagerDAO;
import com.example.exa863_management_system_2023.dao.manager.ManagerListImplementation;
import com.example.exa863_management_system_2023.dao.technician.TechnicianArchiveImplementation;
import com.example.exa863_management_system_2023.dao.technician.TechnicianDAO;
import com.example.exa863_management_system_2023.dao.technician.TechnicianListImplementation;
import com.example.exa863_management_system_2023.dao.workOrder.WorkOrderArchiveImplementation;
import com.example.exa863_management_system_2023.dao.workOrder.WorkOrderDAO;
import com.example.exa863_management_system_2023.dao.workOrder.WorkOrderListImplementation;

public class DAO {

    private static BuildingDAO buildingDAO;
    private static CleaningDAO cleaningDAO;
    private static InstallationDAO installationDAO;

    private static ManagerDAO managerDAO;
    private static EmployeeDAO employeeDAO;
    private static ClientDAO clientDAO;
    private static TechnicianDAO technicianDAO;

    private static ComputerComponentDAO computerComponentDAO;
    private static WorkOrderDAO workOrderDAO;

    public static BuildingDAO getBuilding() {
        if (buildingDAO == null) {
            buildingDAO = new BuildingArchiveImplementation();
        }
        return buildingDAO;
    }

    public static CleaningDAO getCleaning() {
        if (cleaningDAO == null) {
            cleaningDAO = new CleaningArchiveImplementation();
        }
        return cleaningDAO;
    }

    public static InstallationDAO getInstallation() {
        if (installationDAO == null) {
            installationDAO = new InstallationArchiveImplementation();
        }
        return installationDAO;
    }

    public static ManagerDAO getManager() {
        if (managerDAO == null) {
            managerDAO = new ManagerArchiveImplementation();
        }
        return managerDAO;
    }

    public static EmployeeDAO getEmployee() {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeArchiveImplementation();
        }
        return employeeDAO;
    }

    public static ClientDAO getClient() {
        if (clientDAO == null) {
            clientDAO = new ClientArchiveImplementation();
        }
        return clientDAO;
    }

    public static TechnicianDAO getTechnician() {
        if (technicianDAO == null) {
            technicianDAO = new TechnicianArchiveImplementation();
        }
        return technicianDAO;
    }

    public static ComputerComponentDAO getComponent() {
        if (computerComponentDAO == null) {
            computerComponentDAO = new ComponentArchiveImplementation();
        }
        return computerComponentDAO;
    }

    public static WorkOrderDAO getWorkOrder() {
        if (workOrderDAO == null) {
            workOrderDAO = new WorkOrderArchiveImplementation();
        }
        return workOrderDAO;
    }
}
