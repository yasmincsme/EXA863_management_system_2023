package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.model.Technician;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateUserController {

    //Button
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;


    //Field
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;


    @FXML
    void cancelOperation(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("UsersView.fxml");
    }

    @FXML
    void saveUser(ActionEvent event) throws ObjectNotFoundException, IOException {
        if (UsersController.selectedUser instanceof Manager) {
            Manager user = (Manager) UsersController.selectedUser;

            if (nameField.getText().length() > 0) {
                user.setName(nameField.getText());
            }
            if (emailField.getText().length() > 0) {
                user.setEmail(emailField.getText());
            }
            if (passwordField.getText().length() > 0) {
                user.setPassword(passwordField.getText());
            }
            DAO.getManager().update(user);
        } else if (UsersController.selectedUser instanceof Technician) {
            Technician user = (Technician) UsersController.selectedUser;

            if (nameField.getText().length() > 0) {
                user.setName(nameField.getText());
            }
            if (emailField.getText().length() > 0) {
                user.setEmail(emailField.getText());
            }
            if (passwordField.getText().length() > 0) {
                user.setPassword(passwordField.getText());
            }
            DAO.getTechnician().update(user);
        } else if (UsersController.selectedUser instanceof Employee) {
            Employee user = (Employee) UsersController.selectedUser;

            if (nameField.getText().length() > 0) {
                user.setName(nameField.getText());
            }
            if (emailField.getText().length() > 0) {
                user.setEmail(emailField.getText());
            }
            if (passwordField.getText().length() > 0) {
                user.setPassword(passwordField.getText());
            }
            DAO.getEmployee().update(user);
        }
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("UsersView.fxml");
    }
}