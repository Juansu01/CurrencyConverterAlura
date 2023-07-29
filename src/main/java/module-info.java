module com.example.currencyconverteralura {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.currencyconverteralura to javafx.fxml;
    exports com.example.currencyconverteralura;
}