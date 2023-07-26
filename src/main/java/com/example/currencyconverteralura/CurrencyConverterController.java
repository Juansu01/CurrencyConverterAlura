package com.example.currencyconverteralura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyConverterController implements Initializable {
    @FXML
    private Label welcomeText = new Label("Hello?");

    @FXML
    public ChoiceBox<String> haveChoiceBox = new ChoiceBox<String>();
    @FXML
    public ChoiceBox<String> wantChoiceBox = new ChoiceBox<String>();

    private String[] availableCurrencies = {"COP", "USD", "BRL", "EUR", "CAD", "AUD", "MXN"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setText("Select currencies");
        haveChoiceBox.getItems().addAll(availableCurrencies);
        wantChoiceBox.getItems().addAll(availableCurrencies);
    }

    public void getCurrencies(ActionEvent event) {

    }
}