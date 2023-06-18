package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewComponentController {

    //Button
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;


    //Field
    @FXML
    private TextField nameField;
    @FXML
    private TextField manufacturerField;
    @FXML
    private TextField serialNumberField;
    @FXML
    private TextField unitPriceField;
    @FXML
    private TextField unitCostField;
    @FXML
    private TextField quantityField;


    @FXML
    void cancelOperation(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("StockView.fxml");
    }

    @FXML
    void saveComponent(ActionEvent event) throws IOException {
        double unitPrice = Double.parseDouble(unitPriceField.getText());
        double unitCost =  Double.parseDouble(unitCostField.getText());
        int quantity = Integer.parseInt(unitCostField.getText());
        ComputerComponent component = new ComputerComponent(nameField.getText(), manufacturerField.getText(), serialNumberField.getText(), unitPrice, unitCost, quantity);
        DAO.getComponent().create(component);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("StockView.fxml");
    }

}
