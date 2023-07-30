package com.example.currencyconverteralura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class WeightConverterController implements Initializable {

    @FXML
    private ChoiceBox<String> haveWeightChoiceBox = new ChoiceBox<String>();

    @FXML
    private ChoiceBox<String> wantWeightChoiceBox = new ChoiceBox<String>();

    @FXML
    public TextField weightInput = new TextField();

    @FXML
    public Text haveError = new Text();

    @FXML
    public Text wantError = new Text();

    @FXML
    public Text weightInputError = new Text();

    @FXML
    public Text result = new Text();

    public final double ratio = 0.45359237;


    private String[] availableUnits = {"Kilos", "Pounds"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.haveWeightChoiceBox.getItems().addAll(this.availableUnits);
        this.wantWeightChoiceBox.getItems().addAll(this.availableUnits);
    }

    public void onSubmit(ActionEvent event) {
        boolean isInputValid = this.validateInput();
        if (isInputValid) {
            System.out.println("Can convert!");
            double result = this.getResult();
            this.result.setText(String.valueOf(result));
        }
    }

    public boolean validateInput() {
        String haveWeightChoice = this.haveWeightChoiceBox.getValue();
        String wantWeightChoice = this.wantWeightChoiceBox.getValue();
        String weightInputValue = this.weightInput.getText();

        boolean isHaveWeightChoiceValid = false;
        boolean isWantWeightChoiceValid = false;
        boolean isWeightInputValueValid = false;

        if (haveWeightChoice == null) {
            haveError.setText("Please select unit");
        } else {
            haveError.setText("");
            isHaveWeightChoiceValid = true;
        }

        if (wantWeightChoice == null) {
            wantError.setText("Please select unit");
        } else {
            wantError.setText("");
            isWantWeightChoiceValid = true;
        }

        if (weightInputValue.isEmpty()) {
            weightInputError.setText("Enter quantity");
            this.result.setText("");
        } else if (!isNumeric(weightInputValue)) {
            weightInputError.setText("Enter only numbers");
            this.result.setText("");
        } else {
            weightInputError.setText("");
            isWeightInputValueValid = true;
        }

        return isHaveWeightChoiceValid && isWantWeightChoiceValid && isWeightInputValueValid;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getResult() {
        String haveWeightChoice = this.haveWeightChoiceBox.getValue();
        String wantWeightChoice = this.wantWeightChoiceBox.getValue();
        double inputAsDouble = Double.parseDouble(this.weightInput.getText());
        if (haveWeightChoice == wantWeightChoice) {
            return inputAsDouble;
        } else if (haveWeightChoice == "Kilos" && wantWeightChoice == "Pounds") {
            return this.convertKilosToPounds(inputAsDouble);
        } else {
            return this.convertPoundsToKilos(inputAsDouble);
        }
    }

    public double convertKilosToPounds(double kilos) {
        return kilos / this.ratio;
    }

    public double convertPoundsToKilos(double pounds) {
        return pounds * this.ratio;
    }
}
