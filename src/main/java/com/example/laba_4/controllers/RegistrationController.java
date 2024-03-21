package com.example.laba_4.controllers;

import com.example.laba_4.model.AppModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrationController {
    AppModel appModel = AppModel.getInstance();

    @FXML
    private Label registratoin_error;

    @FXML
    private Button registration_voitiButton;

    @FXML
    private Button registration_registrButton;

    @FXML
    private TextField registration_login;


    @FXML
    private TextField registration_password;

    @FXML
    void initialize() {

        registration_voitiButton.setOnAction(e -> {
            appModel.changePage(registration_voitiButton, "voiti.fxml");
        });

        registration_registrButton.setOnAction(e -> {
            boolean bool = appModel.addUser(registratoin_error, registration_login, registration_password);
            if (bool) {
                appModel.changePage(registration_registrButton, "voiti.fxml");
            }
        });
    }
}
