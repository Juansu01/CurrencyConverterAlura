package com.example.currencyconverteralura;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

    public void setResultText(String haveCurrency, String wantCurrency, String amount) throws IOException {
        resultText.setText("Wow, result");
        JsonObject convertResult = makeConvertRequest(haveCurrency, wantCurrency, amount);
        resultText.setText("$ " + convertResult.get("new_amount"));
    }

    public JsonObject makeConvertRequest(String haveCurrency, String wantCurrency, String amount) throws IOException {
        String url = "https://api.api-ninjas.com/v1/convertcurrency?want=" + wantCurrency + "&have=" + haveCurrency + "&amount=" + amount;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("accept", "application/json");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return JsonParser.parseString(response.toString()).getAsJsonObject();
    }
}
