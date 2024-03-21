package com.example.laba_4.controllers;

import com.example.laba_4.model.AppModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SpasiboController {
    AppModel appModel = AppModel.getInstance();


    @FXML
    private Button spasibo_naGlavnyuButton;

    @FXML
    void initialize() {
        spasibo_naGlavnyuButton.setOnAction(e -> {
            appModel.changePage(spasibo_naGlavnyuButton, "glavnaya.fxml");
        });
    }
}
