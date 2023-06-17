package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import com.example.exa863_management_system_2023.model.WorkOrder;
import com.example.exa863_management_system_2023.utils.FindUsers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdersController {

    @FXML
    private TableColumn<WorkOrder, String> clientColumn;
    @FXML
    private TableColumn<WorkOrder, String> technicianColumn;
    @FXML
    private TableColumn<WorkOrder, String> statusColumn;
    @FXML
    private TableColumn<WorkOrder, Double> priceColumn;
    @FXML
    private TableColumn<WorkOrder, Double> costColumn;
    @FXML
    private TableColumn<WorkOrder, Integer> scoreColumn;


    //Label
    @FXML
    private Label numTotalLabel;
    @FXML
    private Label numCanceledLabel;
    @FXML
    private Label numCompletedLabel;
    @FXML
    private Label numOrdersLabel;


    //Button
    @FXML
    private Button removeButton;
    @FXML
    private Button updateOrderButton;
    @FXML
    private Button newOrderButton;


    public static Object selectedOrder;


    @FXML
    private void initialize(){
        selectedOrder = null;
        initializeTable();
    }

    private void initializeTable(){

        //Valores para a descrição
        this.descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        this.descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para o ID do cliente
        this.clientColumn.setCellValueFactory(new PropertyValueFactory<>("clientID"));
        this.clientColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para o ID do técnico
        this.technicianColumn.setCellValueFactory(new PropertyValueFactory<>("technicianID"));
        this.technicianColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para o status
        this.statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        this.statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para a coluna preço
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        this.priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        //Valores para a coluna custo
        this.costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        this.costColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        //Valores para a coluna de score
        this.scoreColumn.setCellValueFactory(new PropertyValueFactory<>("clientSatisfaction"));
        this.scoreColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        this.ordersTable.onMouseClickedProperty().setValue(mouseEvent -> {
            if (ordersTable.getSelectionModel().getSelectedItem() != null) {
                OrdersController.selectedOrder = ordersTable.getSelectionModel().getSelectedItem();
            }
        });

        List<WorkOrder> ordersList = DAO.getWorkOrder().findMany();
        for (WorkOrder order : ordersList) {
            ordersTable.getItems().add(order);
        }
    }

    @FXML
    void removeOrder(ActionEvent event) throws IOException {
        try {
            DAO.getWorkOrder().delete(((WorkOrder) selectedOrder).getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        MainController.gotoScene("OrdersView.fxml");
    }

    @FXML
    void updateOrder(ActionEvent event) {

    }

    @FXML
    void addNewOrder(ActionEvent event) {

    }
}
