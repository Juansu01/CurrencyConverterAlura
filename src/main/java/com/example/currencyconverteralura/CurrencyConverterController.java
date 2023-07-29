package com.example.currencyconverteralura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyConverterController implements Initializable {
    @FXML
    private Label welcomeText = new Label();

    @FXML
    public ChoiceBox<String> haveChoiceBox = new ChoiceBox<String>();

    @FXML
    public Text haveError = new Text();

    @FXML
    public Text wantError = new Text();
    @FXML
    public ChoiceBox<String> wantChoiceBox = new ChoiceBox<String>();

    @FXML
    public TextField currencyInput = new TextField();

    @FXML
    public Text currencyInputError = new Text();

    private FXMLLoader resultLoader = new FXMLLoader(getClass().getResource("converter-result.fxml"));

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String[] availableCurrencies = {"COP", "USD", "BRL", "EUR", "CAD", "AUD", "MXN"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setText("Select currencies");
        haveChoiceBox.getItems().addAll(availableCurrencies);
        wantChoiceBox.getItems().addAll(availableCurrencies);
    }

    public void onSubmit(ActionEvent event) throws IOException {
        boolean isValid = validateInput();
        if (isValid) {
            this.setResultValues();
            this.displayResult(event);
        }

    }

    public boolean validateInput() {
        String haveVal = haveChoiceBox.getValue();
        String wantVal = wantChoiceBox.getValue();
        String currencyInputVal = currencyInput.getText();

        boolean isHaveValValid = false;
        boolean isWantValValid = false;
        boolean isCurrencyInputValid = false;

        if (currencyInputVal.isEmpty()) {
            currencyInputError.setText("Enter quantity");
        } else if (!isNumeric(currencyInput.getText())) {
            currencyInputError.setText("Enter only numbers");
        } else {
            currencyInputError.setText("");
            isCurrencyInputValid = true;
        }

        if (haveVal == null) {
            haveError.setText("Select option");
        } else {
            haveError.setText("");
            isHaveValValid = true;
        }

        if (wantVal == null) {
            wantError.setText("Select option");
        } else {
            wantError.setText("");
            isWantValValid = true;
        }
        return isCurrencyInputValid && isHaveValValid && isWantValValid;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setResultValues() throws IOException {
        root = this.resultLoader.load();
        ConverterResultController resultController = this.resultLoader.getController();
        resultController.setResultLabel(haveChoiceBox.getValue(), wantChoiceBox.getValue());
        resultController.setResultText("Omg");

    }

    public void displayResult(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}