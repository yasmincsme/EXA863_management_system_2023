package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.model.Technician;
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

public class UsersController extends MenuController {

    //Elementos das colunas
    @FXML
    private TableView<Object> usersTable;
    @FXML
    private TableColumn<Object, String> nameColumn;
    @FXML
    private TableColumn<Object, String> emailColumn;
    @FXML
    private TableColumn<Object, String> roleColumn;


    //Label
    @FXML
    private Label nameLabel;
    @FXML
    private Label IDLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label roleLabel;


    //Button
    @FXML
    private Button removeButton;
    @FXML
    private Button updateUserButton;
    @FXML
    private Button newUserButton;


    public static Object selectedUser;


    @FXML
    private void initialize(){
        selectedUser = null;
        initializeTable();
    }

    private void initializeTable(){

        //Valores para o nome
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para o email
        this.emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para o tipo
        this.roleColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.roleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        this.usersTable.onMouseClickedProperty().setValue(mouseEvent -> {
            if (usersTable.getSelectionModel().getSelectedItem() != null) {
                UsersController.selectedUser = usersTable.getSelectionModel().getSelectedItem();
                this.showUser();
            }
        });

        ArrayList<Object> usersList = FindUsers.findAllUsers();
        for (Object user : usersList) {
            usersTable.getItems().add(user);
        }
    }

    private void showUser(){
        if (UsersController.selectedUser != null) {
            Manager newUser = null;
            //mostrar o usuario
            if (UsersController.selectedUser instanceof Manager) {
                newUser = (Manager) UsersController.selectedUser;
                this.nameLabel.setText(newUser.getName());
                this.IDLabel.setText(newUser.getID());
                this.emailLabel.setText(newUser.getEmail());
                this.roleLabel.setText(newUser.getType());
            }
        } else {
            this.nameLabel.setText("name");
            this.IDLabel.setText("ID");
            this.emailLabel.setText("email");
            this.roleLabel.setText("role");
        }
        if (UsersController.selectedUser != null) {
            Technician newUser = null;
            //mostrar o usuario
            if (UsersController.selectedUser instanceof Technician) {
                newUser = (Technician) UsersController.selectedUser;
                this.nameLabel.setText(newUser.getName());
                this.IDLabel.setText(newUser.getID());
                this.emailLabel.setText(newUser.getEmail());
                this.roleLabel.setText(newUser.getType());
            }
        } else {
            this.nameLabel.setText("name");
            this.IDLabel.setText("ID");
            this.emailLabel.setText("email");
            this.roleLabel.setText("role");
        }
        if (UsersController.selectedUser != null) {
            Employee newUser = null;
            //mostrar o usuario
            if (UsersController.selectedUser instanceof Employee) {
                newUser = (Employee) UsersController.selectedUser;
                this.nameLabel.setText(newUser.getName());
                this.IDLabel.setText(newUser.getID());
                this.emailLabel.setText(newUser.getEmail());
                this.roleLabel.setText(newUser.getType());
            }
        } else {
            this.nameLabel.setText("name");
            this.IDLabel.setText("ID");
            this.emailLabel.setText("email");
            this.roleLabel.setText("role");
        }
    }

    @FXML
    void removeUser(ActionEvent event) throws IOException {
        if (selectedUser instanceof Manager){
            try {
                DAO.getManager().delete(((Manager) selectedUser).getID());
            } catch (ObjectNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        } else if (selectedUser instanceof Technician) {
            try {
                DAO.getTechnician().delete(((Technician) selectedUser).getID());
            } catch (ObjectNotFoundException exception) {
            }
        } else if (selectedUser instanceof Employee) {
            try {
                DAO.getEmployee().delete(((Employee) selectedUser).getID());
            } catch (ObjectNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
        MainController.gotoScene("UsersView.fxml");
    }

    @FXML
    void updateUser(ActionEvent event) throws IOException {
        MainController.popUp("UpdateUserView.fxml");
    }

    @FXML
    void addNewUser(ActionEvent event) throws IOException {
        Stage popUpStage = MainController.popUp("NewUserView.fxml");
    }
}


