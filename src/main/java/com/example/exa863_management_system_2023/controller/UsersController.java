package com.example.exa863_management_system_2023.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UsersController {

    @FXML
    private Label IDLabel;

    @FXML
    private Button clientsButton;

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
    private Button removeButton;

    @FXML
    private TableColumn<?, ?> roleColumn;

    @FXML
    private Label roleLabel;

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

    @FXML
    private TableView<?> usersTable;

}

