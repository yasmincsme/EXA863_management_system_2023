package com.example.exa863_management_system_2023.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClientsController {

    @FXML
    private Label IDLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Button clientsButton;

    @FXML
    private TableView<?> clientsTable;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private Label emailLabel;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private Label nameLabel;

    @FXML
    private Button newUserButton;

    @FXML
    private Button ordersButton;

    @FXML
    private Button overviewButton;

    @FXML
    private Label phoneLabel;

    @FXML
    private Button removeButton;

    @FXML
    private TextField searchField;

    @FXML
    private Button settingsButton;

    @FXML
    private Button signoutButton;

    @FXML
    private Button stockButton;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button usersButton;

}
