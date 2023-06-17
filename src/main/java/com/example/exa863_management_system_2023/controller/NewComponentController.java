package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewComponentController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField manufacturerField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField quantityField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField serialNumberField;

    @FXML
    private TextField unitCostField;

    @FXML
    private TextField unitPriceField;

    @FXML
    void cancelOperation(ActionEvent event) {

    }

    @FXML
    void saveComponent(ActionEvent event) {
        double unitPrice = Double.parseDouble(unitPriceField.getText());
        double unitCost =  Double.parseDouble(unitCostField.getText());
        int quantity = Integer.parseInt(unitCostField.getText());
        ComputerComponent component = new ComputerComponent(nameField.getText(), manufacturerField.getText(), serialNumberField.getText(), unitPrice, unitCost, quantity);
        DAO.getComponent().create(component);
    }

}
