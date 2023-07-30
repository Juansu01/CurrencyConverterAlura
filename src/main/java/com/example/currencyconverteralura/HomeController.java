package com.example.currencyconverteralura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private ChoiceBox<String> converterChoiceBox = new ChoiceBox<String>();

    private String[] availableConverters = {"Currency", "Weight"};

    @FXML
    public Text converterChoiceError = new Text();

    private final FXMLLoader weightConverter = new FXMLLoader(getClass().getResource("weight-converter-prompt.fxml"));

    private final FXMLLoader currencyConverter = new FXMLLoader(getClass().getResource("currency-converter-prompt.fxml"));

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.converterChoiceError.setText("");
        this.setConverterChoiceBox();
    }

    public void onHomeSubmit(ActionEvent event) throws IOException {
        boolean isChoiceValid = this.validateChoice();
        if (isChoiceValid) {
            if (converterChoiceBox.getValue() == "Currency") {
                this.displayCurrencyConverter(event);
            } else {
                this.displayWeightConverter(event);
            }
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

    public void displayCurrencyConverter(ActionEvent event) throws IOException {
        root = this.currencyConverter.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayWeightConverter(ActionEvent event) throws IOException {
        root = this.weightConverter.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
