package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Cleaning;
import com.example.exa863_management_system_2023.model.Client;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientsController extends MenuController{

    //Elementos das colunas
    @FXML
    private TableView<Client> usersTable;
    @FXML
    private TableColumn<Client, String> nameColumn;
    @FXML
    private TableColumn<Client, String> emailColumn;

    //Label
    @FXML
    private Label nameLabel;
    @FXML
    private Label IDLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label phoneLabel;

    //Button
    @FXML
    private Button removeButton;
    @FXML
    private Button updateClientButton;
    @FXML
    private Button newClientButton;

    public static Object selectedUser;

    //TextField
    @FXML
    private TextField nameField;


    @FXML
    private void initialize(){
        selectedUser = null;
        initializeTable();
    }

    private void initializeTable(){

        //Valores para o nome
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Valores para o email
        this.emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        this.usersTable.onMouseClickedProperty().setValue(mouseEvent -> {
            if (usersTable.getSelectionModel().getSelectedItem() != null) {
                ClientsController.selectedUser = usersTable.getSelectionModel().getSelectedItem();
                this.showUser();
            }
        });

        List<Client> clientList = DAO.getClient().findMany();
        for (Client client : clientList) {
            usersTable.getItems().add(client);
        }
    }

    private void showUser() {
        if (ClientsController.selectedUser != null) {
            Client newClient = null;
            newClient = (Client) ClientsController.selectedUser;
            this.nameLabel.setText(newClient.getName());
            this.IDLabel.setText((newClient.getID()));
            this.emailLabel.setText(newClient.getEmail());
            this.addressLabel.setText(newClient.getAddress());
            this.phoneLabel.setText(newClient.getPhone());
        } else {
            this.nameLabel.setText("name");
            this.IDLabel.setText("ID");
            this.emailLabel.setText("email");
            this.addressLabel.setText("address");
            this.phoneLabel.setText("phone");
        }

    }

    @FXML
    void removeClient(ActionEvent event) throws IOException{
        try {
            DAO.getClient().delete(((Client) selectedUser).getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        MainController.gotoScene("ClientView.fxml");
    }

    @FXML
    void updateClient(ActionEvent event) throws IOException {
        Stage popUpStage = MainController.popUp("UpdateClientView.fxml");

    }

    @FXML
    void addNewClient(ActionEvent event) throws IOException {
        Stage popUpStage = MainController.popUp("NewClientView.fxml");
    }
}
