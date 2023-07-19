module com.example.currencyconverteralura {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.currencyconverteralura to javafx.fxml;
    exports com.example.currencyconverteralura;
}