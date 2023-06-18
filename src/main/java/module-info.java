module com.example.exa863_management_system_2023 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.exa863_management_system_2023.model;

    opens com.example.exa863_management_system_2023.dao.manager;
    opens com.example.exa863_management_system_2023.dao.building;
    opens com.example.exa863_management_system_2023.dao.cleaning;
    opens com.example.exa863_management_system_2023.dao.client;
    opens com.example.exa863_management_system_2023.dao.computerComponent;
    opens com.example.exa863_management_system_2023.dao.employee;
    opens com.example.exa863_management_system_2023.dao.installation;
    opens com.example.exa863_management_system_2023.dao.technician;
    opens com.example.exa863_management_system_2023.dao.workOrder;

    opens com.example.exa863_management_system_2023 to javafx.fxml;
    exports com.example.exa863_management_system_2023;

    opens com.example.exa863_management_system_2023.controller to javafx.fxml;
    exports com.example.exa863_management_system_2023.controller;
}