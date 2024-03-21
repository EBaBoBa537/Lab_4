module com.example.laba_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laba_4 to javafx.fxml;
    exports com.example.laba_4;
    exports com.example.laba_4.controllers;
    opens com.example.laba_4.controllers to javafx.fxml;
}