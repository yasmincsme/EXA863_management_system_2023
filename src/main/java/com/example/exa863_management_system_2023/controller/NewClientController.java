package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewClientController {

    @FXML
    private TextField addressField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button saveButton;

    @FXML
    void cancelOperation(ActionEvent event) {

    }

    @FXML
    void saveClient(ActionEvent event) {
        Client client = new Client(nameField.getText(), emailField.getText(), addressField.getText(), phoneField.getText());
        DAO.getClient().create(client);
    }

}
