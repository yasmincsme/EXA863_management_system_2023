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
    public static Stage stage;
    public static boolean popUpClosed = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        MainController.stage = new Stage();
        gotoScene("LoginView.fxml");
    }

    public static void gotoScene(String path) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainController.class.getResource(path)));
        MainController.stage.setScene(new Scene(root));
        stage.show();
    }

    public static Stage popUp(String path) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainController.class.getResource(path)));
        Stage newStage = new Stage();
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(MainController.stage);
        newStage.setScene(new Scene(root));
        newStage.setOnHidden(e -> {
            popUpClosed = true;
        });
        newStage.show();
        return newStage;
    }
}
