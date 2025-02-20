package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField height;

    @FXML
    private TextField radius;

    @FXML
    private TextField result;

    @FXML
    void StartCalcButton(ActionEvent event) {
        double h = Double.parseDouble(height.getText());
        double r = Double.parseDouble(radius.getText());
        double res = 2*Math.PI*r*(r+h);
        result.setText(String.valueOf(res));
    }

}
