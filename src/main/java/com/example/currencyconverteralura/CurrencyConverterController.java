package com.example.currencyconverteralura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyConverterController implements Initializable {
    @FXML
    private Label welcomeText = new Label("Hello?");

    @FXML
    public ChoiceBox<String> haveChoiceBox = new ChoiceBox<String>();

    @FXML
    public Text haveError = new Text();

    @FXML
    public Text wantError = new Text();
    @FXML
    public ChoiceBox<String> wantChoiceBox = new ChoiceBox<String>();

    private String[] availableCurrencies = {"COP", "USD", "BRL", "EUR", "CAD", "AUD", "MXN"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setText("Select currencies");
        haveChoiceBox.getItems().addAll(availableCurrencies);
        wantChoiceBox.getItems().addAll(availableCurrencies);
    }

    public void onSubmit(ActionEvent event) {
        String haveValue = haveChoiceBox.getValue();
        String wantValue = wantChoiceBox.getValue();
        boolean isValid = validateInput();
        if (isValid) {
            System.out.println("The user wants:" + haveValue + " " + wantValue);
        }

    }

    public boolean validateInput() {
        String haveVal = haveChoiceBox.getValue();
        String wantVal = wantChoiceBox.getValue();

        if (haveVal == null) {
            haveError.setText("Select option");
        } else {
            haveError.setText("");
        }

        if (wantVal == null) {
            wantError.setText("Select option");
        } else {
            wantError.setText("");
        }
        if (haveVal == null || wantVal == null) {
            return false;
        }

        return true;
    }
}