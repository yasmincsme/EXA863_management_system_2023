package com.example.exa863_management_system_2023.dao;

import com.example.exa863_management_system_2023.dao.building.BuildingDAO;
import com.example.exa863_management_system_2023.dao.cleaning.CleaningDAO;
import com.example.exa863_management_system_2023.dao.client.ClientDAO;
import com.example.exa863_management_system_2023.dao.computerComponent.ComputerComponentDAO;
import com.example.exa863_management_system_2023.dao.employee.EmployeeDAO;
import com.example.exa863_management_system_2023.dao.installation.InstallationDAO;
import com.example.exa863_management_system_2023.dao.manager.ManagerDAO;
import com.example.exa863_management_system_2023.dao.technician.TechnicianDAO;
import com.example.exa863_management_system_2023.dao.workOrder.WorkOrderDAO;

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

}
