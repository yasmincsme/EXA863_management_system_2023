package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewClientController {

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
    void saveClient(ActionEvent event) throws IOException {
        Client client = new Client(nameField.getText(), emailField.getText(), addressField.getText(), phoneField.getText());
        DAO.getClient().create(client);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("ClientView.fxml");
    }

}
