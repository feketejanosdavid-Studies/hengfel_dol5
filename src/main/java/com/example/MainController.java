package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private TextField height;

    @FXML
    private TableColumn<Calculations, Double> heightColumn;

    @FXML
    private TextField radius;

    @FXML
    private TableColumn<Calculations, Double> radiusColumn;

    @FXML
    private TextField result;

    @FXML
    private TableColumn<Calculations, Double> resultColumn;

    @FXML
    private TableView<Calculations> tableView;

    private ObservableList<Calculations> calculationsList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        radiusColumn.setCellValueFactory(new PropertyValueFactory<>("radius"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("surface"));

        tableView.setItems(calculationsList);

        loadToTable();
    }

    @FXML
    void StartCalcButton(ActionEvent event) {
        double h = Double.parseDouble(height.getText());
        double r = Double.parseDouble(radius.getText());
        double res = 2 * Math.PI * r * (r + h);
        result.setText(String.valueOf(res));

        Calculations calc = new Calculations(h, r, res);

        DataSource ds = new DataSource();
        ds.addCalculation(calc);

        calculationsList.add(calc);
    }

    void loadToTable() {
        DataSource ds = new DataSource();
        calculationsList.setAll(ds.getAllCalculations());
    }
}
