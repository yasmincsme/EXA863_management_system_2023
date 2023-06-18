package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateComponentController {

    //Button
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;


    //Field
    @FXML
    private TextField nameField;
    @FXML
    private TextField IDField;
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
    void saveComponent(ActionEvent event) throws ObjectNotFoundException, IOException {
        ComputerComponent component = (ComputerComponent) StockController.selectedComponent;

        if (!nameField.getText().isEmpty()) {
            component.setName(nameField.getText());
        }
        if (!manufacturerField.getText().isEmpty()) {
            component.setManufacturer(manufacturerField.getText());
        }
        if (!serialNumberField.getText().isEmpty()) {
            component.setSerialNumber(serialNumberField.getText());
        }
        if (!unitPriceField.getText().isEmpty()) {
            component.setUnitPrice(Double.parseDouble(unitPriceField.getText()));
        }
        if (!unitCostField.getText().isEmpty()) {
            component.setUnitCost(Double.parseDouble(unitCostField.getText()));
        }
        if (!quantityField.getText().isEmpty()) {
            component.setQuantity(Integer.parseInt(quantityField.getText()));
        }
        DAO.getComponent().update(component);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("StockView.fxml");
    }

}
