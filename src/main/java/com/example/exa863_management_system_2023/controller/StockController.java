package com.example.exa863_management_system_2023.controller;

import com.example.exa863_management_system_2023.MainController;
import com.example.exa863_management_system_2023.dao.DAO;
import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Client;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import javafx.beans.binding.DoubleBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FormatStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.text.Format;
import java.util.List;

public class StockController {

   //Elementos das colunas
    @FXML
    private TableView<ComputerComponent> componentsTable;
    @FXML
    private TableColumn<ComputerComponent, String> nameColumn;
    @FXML
    private TableColumn<ComputerComponent, String> manufacturerColumn;
    @FXML
    private TableColumn<ComputerComponent, String> serialNumberColumn;
    @FXML
    private TableColumn<ComputerComponent, Double> unitPriceColumn;
    @FXML
    private TableColumn<ComputerComponent, Double> unitCostColumn;
    @FXML
    private TableColumn<ComputerComponent, Integer> quantityColumn;


    //Button
    @FXML
    private Button removeButton;
    @FXML
    private Button updateStockButton;
    @FXML
    private Button newComponentButton;


    public static Object selectedComponent;


    @FXML
    private void initialize(){
        selectedComponent = null;
        initializeTable();
    }

    private void initializeTable(){

        //Valores para o nome
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para o fabricante
        this.manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        this.manufacturerColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para o número de série
        this.serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        this.serialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Valores para a coluna preço
        this.unitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        this.unitPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn( new DoubleStringConverter()));

        //Valores para a coluna custo
        this.unitCostColumn.setCellValueFactory(new PropertyValueFactory<>("unitCost"));
        this.unitCostColumn.setCellFactory(TextFieldTableCell.forTableColumn( new DoubleStringConverter()));

        //Valores para a coluna quantidade
        this.quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        this.quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter()));

        this.componentsTable.onMouseClickedProperty().setValue(mouseEvent -> {
            if (componentsTable.getSelectionModel().getSelectedItem() != null) {
                StockController.selectedComponent = componentsTable.getSelectionModel().getSelectedItem();
            }
        });

        List<ComputerComponent> componentList = DAO.getComponent().findMany();
        for (ComputerComponent component : componentList) {
            componentsTable.getItems().add(component);
        }
    }

    @FXML
    void removeComponent(ActionEvent event) throws IOException {
        try {
            DAO.getComponent().delete(((ComputerComponent) selectedComponent).getID());
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        MainController.gotoScene("StockView.fxml");
    }

    @FXML
    void updateComponent(ActionEvent event) {

    }

    @FXML
    void addNewOrder(ActionEvent event) throws IOException {
        MainController.popUp("NewComponentView.fxml");
    }
}
