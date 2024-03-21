package com.example.laba_4.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.laba_4.model.AppModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VoitiController {

    AppModel appModel = AppModel.getInstance();

    @FXML
    private Label voiti_error;

    @FXML
    private TextField voiti_login;

    @FXML
    private Button voiti_voitiButton;

    @FXML
    private TextField voiti_password;

    @FXML
    private Button voiti_registrButton;

    @FXML
    void initialize() {
        appModel.clearKorzina();
        if (appModel.isUserRegistSuccess()) {
            voiti_error.setText("Пользователь зарегистирован!");
            appModel.setUserRegistSuccess(false);
        }

        voiti_voitiButton.setOnAction(e -> {
            boolean bool = appModel.checkUser(voiti_error, voiti_login, voiti_password);
            if (bool) {
                appModel.changePage(voiti_voitiButton, "glavnaya.fxml");
            }
        });

        voiti_registrButton.setOnAction(e -> {
            appModel.changePage(voiti_registrButton, "registration.fxml");
        });
    }

}
