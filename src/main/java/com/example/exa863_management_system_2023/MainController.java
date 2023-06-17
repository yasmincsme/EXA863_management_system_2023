package com.example.exa863_management_system_2023;

import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.model.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        MainController.stage = new Stage();
        Manager manager = new Manager("Admin", "admin@example", "admin", "admin123");
        if (DAO.getManager().findByLogin("yamisan").size() == 0) {
            DAO.getManager().create(manager);
        }
        gotoScene("LoginView.fxml");
    }
}
