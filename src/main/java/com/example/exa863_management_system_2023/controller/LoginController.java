package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.dao.employee.EmployeeDAO;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.model.Technician;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    public ArrayList<Object> findAllUsersByLogin() {
        ArrayList<Object> usersList = new ArrayList<>();

        usersList.addAll(DAO.getEmployee().findByLogin(usernameField.getText()));
        usersList.addAll(DAO.getManager().findByLogin(usernameField.getText()));
        usersList.addAll(DAO.getTechnician().findByLogin(usernameField.getText()));

        return usersList;
    }

    @FXML
    void toLogin(ActionEvent event) throws IOException {
        ArrayList<Object> usersList = findAllUsersByLogin();
        for (Object user : usersList) {
            if (user instanceof Employee) {
                Employee newUser = (Employee) user;
                if (Objects.equals(newUser.getPassword(), passwordField.getText())) {
                    MainController.gotoScene("OrdersView.fxml");
                }
            }
            if (user instanceof Manager) {
                Manager newUser = (Manager) user;
                if (Objects.equals(newUser.getPassword(), passwordField.getText())) {
                    MainController.gotoScene("OrdersView.fxml");
                }
            }
            if (user instanceof Technician) {
                Technician newUser = (Technician) user;
                if (Objects.equals(newUser.getPassword(), passwordField.getText())) {
                    MainController.gotoScene("OrdersView.fxml");
                }
            }
        }
    }
}
