package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.InvalidSatisfactionScore;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.exceptions.WorkOrderWithoutTechnician;
import com.example.exa863_management_system_2023.model.WorkOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateOrderController {

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
    private TextField technicianID;
    @FXML
    private TextField statusField;
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
    void saveOrder(ActionEvent event) throws InvalidSatisfactionScore, ObjectNotFoundException, IOException, WorkOrderWithoutTechnician {
        WorkOrder order = (WorkOrder) OrdersController.selectedOrder;

        if (!descriptionField.getText().isEmpty()) {
            order.setDescription(descriptionField.getText());
        }
        if (!clientIDField.getText().isEmpty()) {
            order.setClientID(clientIDField.getText());
        }
        if (!technicianID.getText().isEmpty()) {
            order.setTechnicianID(technicianID.getText());
        }
        if (!statusField.getText().isEmpty()) {
            if (statusField.getText().toLowerCase().charAt(0) == 'o') {
                order.reopen();
            }
            if (statusField.getText().toLowerCase().charAt(0) == 'c') {
                order.cancel();
            }
            if (statusField.getText().toLowerCase().charAt(0) == 'f') {
                order.finish();
            }
        }
        if (!priceField.getText().isEmpty()) {
            order.setPrice(Double.parseDouble(priceField.getText()));
        }
        if (!costField.getText().isEmpty()) {
            order.setCost(Double.parseDouble(costField.getText()));
        }
        if (!satisfactionScoreField.getText().isEmpty()) {
            order.setClientSatisfaction(Integer.parseInt(satisfactionScoreField.getText()));
        }
        if (!paymentMethodField.getText().isEmpty()) {
            order.setPaymentMethod(paymentMethodField.getText());
        }
        DAO.getWorkOrder().update(order);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        MainController.gotoScene("OrdersView.fxml");
    }
}
