package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.InvalidSatisfactionScore;
import com.example.exa863_management_system_2023.model.Client;
import com.example.exa863_management_system_2023.model.WorkOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewOrderController {

    //Button
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;


    //Field
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField clientIDField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField costField;
    @FXML
    private TextField satisfactionScoreField;
    @FXML
    private TextField paymentMethodField;


    @FXML
    void cancelOperation(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("OrdersView.fxml");
    }

    @FXML
    void saveOrder(ActionEvent event) throws IOException {
        WorkOrder order = new WorkOrder(descriptionField.getText(), clientIDField.getText());

        if (!priceField.getText().isEmpty()) {
            order.setPrice(Double.parseDouble(priceField.getText()));
        }
        if (!costField.getText().isEmpty()) {
            order.setCost(Double.parseDouble(costField.getText()));
        }
        if (!satisfactionScoreField.getText().isEmpty()) {
            try {
                order.setClientSatisfaction(Integer.parseInt(satisfactionScoreField.getText()));
            } catch (InvalidSatisfactionScore exception) {
                throw new RuntimeException(exception);
            }
        }
        if (!paymentMethodField.getText().isEmpty()) {
            order.setPaymentMethod(paymentMethodField.getText());
        }
        DAO.getWorkOrder().create(order);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("OrdersView.fxml");
    }

}
