package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.model.Technician;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class NewUserController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField roleField;

    @FXML
    private Button saveButton;

    @FXML
    void cancelOperation(ActionEvent event) {

    }

    @FXML
    void saveUser(ActionEvent event) {
        if (Objects.equals(roleField.getText().toLowerCase().charAt(0), "e")) {
            Employee user = new Employee(nameField.getText(), emailField.getText(), loginField.getText(), passwordField.getText());
            DAO.getEmployee().create(user);
        } else if (Objects.equals(roleField.getText().toLowerCase().charAt(0), "t")) {
            Technician user = new Technician(nameField.getText(), emailField.getText(), loginField.getText(), passwordField.getText());
            DAO.getTechnician().create(user);
        } else if (Objects.equals(roleField.getText().toLowerCase().charAt(0), "m")) {
            Manager user = new Manager(nameField.getText(), emailField.getText(), loginField.getText(), passwordField.getText());
            DAO.getManager().create(user);
        }
        try {
            MainController.gotoScene("UsersView.fxml");

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
