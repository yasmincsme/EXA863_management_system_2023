package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.model.Technician;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UpdateUserController {

    @FXML
    private TextField loginField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private Button saveButton;

    @FXML
    void cancelOperation(ActionEvent event) {

    }

    @FXML
    void saveUser(ActionEvent event) throws ObjectNotFoundException, IOException {
        if (UsersController.selectedUser instanceof Manager) {
            Manager updatingUser = (Manager) UsersController.selectedUser;

            if (nameField.getText().length() > 0) {
                updatingUser.setName(nameField.getText());
            }
            if (emailField.getText().length() > 0) {
                updatingUser.setEmail(emailField.getText());
            }
            DAO.getManager().update(updatingUser);
        } else if (UsersController.selectedUser instanceof Technician) {
            Technician updatingUser = (Technician) UsersController.selectedUser;

            if (nameField.getText().length() > 0) {
                updatingUser.setName(nameField.getText());
            }
            if (emailField.getText().length() > 0) {
                updatingUser.setEmail(emailField.getText());
            }
            DAO.getTechnician().update(updatingUser);
        } else if (UsersController.selectedUser instanceof Employee) {
            Employee updatingUser = (Employee) UsersController.selectedUser;

            if (nameField.getText().length() > 0) {
                updatingUser.setName(nameField.getText());
            }
            if (emailField.getText().length() > 0) {
                updatingUser.setEmail(emailField.getText());
            }
            DAO.getEmployee().update(updatingUser);
        }
        MainController.gotoScene("UsersView.fxml");
    }

}