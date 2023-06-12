package com.example.exa863_management_system_2023.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StockController {

    @FXML
    private Button clientsButton;

    @FXML
    private TableView<?> componentsTable;

    @FXML
    private TableColumn<?, ?> manufacturerColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private Button newComponentButton;

    @FXML
    private Button ordersButton;

    @FXML
    private Button overviewButton;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private Button removeButton;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<?, ?> serialNumberColumn;

    @FXML
    private Button settingsButton;

    @FXML
    private Button signoutButton;

    @FXML
    private Button stockButton;

    @FXML
    private TableColumn<?, ?> unitCostColumn;

    @FXML
    private TableColumn<?, ?> unitPriceColumn;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button usersButton;

}
