package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MenuController {

    @FXML
    void goToClients(ActionEvent event) throws IOException {
        MainController.gotoScene("ClientView.fxml");
    }

    @FXML
    void goToStock(ActionEvent event) throws IOException {
        MainController.gotoScene("StockView.fxml");
    }

    @FXML
    void goToUsers(ActionEvent event)  throws IOException{
        MainController.gotoScene("UsersView.fxml");
    }

    @FXML
    void goToOrders(ActionEvent event)  throws IOException{
        MainController.gotoScene("OrdersView.fxml");
    }

    @FXML
    void quit(ActionEvent event)  throws IOException{
        MainController.gotoScene("LoginView.fxml");
    }
}
