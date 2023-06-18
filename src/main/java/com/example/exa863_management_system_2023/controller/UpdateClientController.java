package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateClientController {

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
    private TextField addressField;
    @FXML
    private TextField phoneField;


    @FXML
    void cancelOperation(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("ClientView.fxml");
    }

    @FXML
    void saveClient(ActionEvent event) throws ObjectNotFoundException, IOException {
        Client client = (Client) ClientsController.selectedUser;

        if (!nameField.getText().isEmpty()) {
            client.setName(nameField.getText());
        }
        if (!emailField.getText().isEmpty()) {
            client.setEmail(emailField.getText());
        }
        if (!addressField.getText().isEmpty()) {
            client.setAddress(addressField.getText());
        }
        if (!phoneField.getText().isEmpty()) {
            client.setPhone(phoneField.getText());
        }
        DAO.getClient().update(client);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("ClientView.fxml");
    }
}
