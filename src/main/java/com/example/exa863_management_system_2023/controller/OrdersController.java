package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.WorkOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class OrdersController extends MenuController{

    //Elementos das colunas
    @FXML
    private TableView<WorkOrder> ordersTable;
    @FXML
    private TableColumn<WorkOrder, String> descriptionColumn;
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
        updateValues();
    }

    private void initializeTable(){

        //Valores para a descrição
        this.descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        //Valores para o ID do cliente
        this.clientColumn.setCellValueFactory(new PropertyValueFactory<>("clientID"));

        //Valores para o ID do técnico
        this.technicianColumn.setCellValueFactory(new PropertyValueFactory<>("technicianID"));

        //Valores para o status
        this.statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        //Valores para a coluna preço
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Valores para a coluna custo
        this.costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        //Valores para a coluna de score
        this.scoreColumn.setCellValueFactory(new PropertyValueFactory<>("clientSatisfaction"));

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

    public void updateValues() {
        int totalOrders = 0;
        int canceledOrders = 0;
        int pendignOrders = 0;
        int openedOrders = 0;
        List<WorkOrder> orderList = DAO.getWorkOrder().findMany();
        for(WorkOrder workOrder : orderList) {
            totalOrders += 1;
            if (Objects.equals(workOrder.getStatus(), "OPEN")) {
                openedOrders += 1;
            } else if (Objects.equals(workOrder.getStatus(), "CANCELED")) {
                canceledOrders += 1;
            } else {
                pendignOrders += 1;
            }
        }
        this.numTotalLabel.setText(String.valueOf(totalOrders));
        this.numCanceledLabel.setText(String.valueOf(canceledOrders));
        this.numCompletedLabel.setText(String.valueOf(pendignOrders));
        this.numOrdersLabel.setText(String.valueOf(openedOrders));
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
    void updateOrder(ActionEvent event) throws IOException {
        Stage popUpStage = MainController.popUp("UpdateOrderView.fxml");
    }

    @FXML
    void addNewOrder(ActionEvent event) throws IOException {
        Stage popUpStage = MainController.popUp("NewOrderView.fxml");
    }
}
