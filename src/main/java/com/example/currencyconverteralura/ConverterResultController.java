package com.example.currencyconverteralura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.text.Text;


public class ConverterResultController {

    @FXML
    private Label resultLabel = new Label();

    @FXML
    private Text resultText = new Text();


    public void goHome(ActionEvent event) {
        System.out.println("Going Home");
    }

    public void goToConverter(ActionEvent event) {
        System.out.println("Going back to converter");
    }

    public void setResultLabel(String haveCurrency, String wantCurrency) {
        resultLabel.setText("From " + haveCurrency + " to " + wantCurrency);
    }

    public void setResultText(String resut) {
        resultText.setText("Wow, result");
    }

}
