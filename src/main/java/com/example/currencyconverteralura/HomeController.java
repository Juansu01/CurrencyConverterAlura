package com.example.currencyconverteralura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private ChoiceBox<String> converterChoiceBox = new ChoiceBox<String>();

    private String[] availableConverters = {"Currency", "Weight"};

    @FXML
    public Text converterChoiceError = new Text();

    private final FXMLLoader weightConverter = new FXMLLoader(getClass().getResource("weight-currency-converter-prompt.fxml"));

    private final FXMLLoader currencyConverter = new FXMLLoader(getClass().getResource("currency-converter-result.fxml"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.converterChoiceError.setText("");
        this.setConverterChoiceBox();
    }

    public void onHomeSubmit(ActionEvent event) {
        boolean isChoiceValid = this.validateChoice();
        if (isChoiceValid) {
            System.out.println("Valid choice.");
        }
    }

    public void setConverterChoiceBox() {
        this.converterChoiceBox.getItems().addAll(this.availableConverters);
    }

    public boolean validateChoice() {
        boolean isChoiceNull = this.converterChoiceBox.getValue() == null;
        if (isChoiceNull) {
            this.converterChoiceError.setText("Please pick a converter");
        } else {
            this.converterChoiceError.setText("");
        }

        return !isChoiceNull;
    }
}
