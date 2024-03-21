package com.example.laba_4.controllers;

import com.example.laba_4.model.AppModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class GlavnayaController {
    AppModel appModel = AppModel.getInstance();

    @FXML
    private Button glavnaya_vKorzinu;

    @FXML
    private Label glavnaya_error;

    @FXML
    private Button glavnaya_pereitiVKorzinu;

    @FXML
    private Button glavnaya_left;

    @FXML
    private Button glavnaya_right;

    @FXML
    private Label glavnaya_cena;

    @FXML
    private ImageView glavnaya_image;

    @FXML
    private TextArea glavnaya_text;

    @FXML
    private Label glavnaya_nazvanie;

    @FXML
    void initialize() {
        appModel.showUsluga(glavnaya_image, glavnaya_nazvanie, glavnaya_text, glavnaya_cena, glavnaya_error);

        glavnaya_left.setOnMouseClicked(e -> {
            appModel.setActiveIndexPrev();
            appModel.showUsluga(glavnaya_image, glavnaya_nazvanie, glavnaya_text, glavnaya_cena, glavnaya_error);
        });
        glavnaya_right.setOnMouseClicked(e -> {
            appModel.setActiveIndexNext();
            appModel.showUsluga(glavnaya_image, glavnaya_nazvanie, glavnaya_text, glavnaya_cena, glavnaya_error);
        });

        glavnaya_vKorzinu.setOnAction(e -> {
            appModel.addItemToKorzina(glavnaya_error);
        });

        glavnaya_pereitiVKorzinu.setOnAction(e -> {
            appModel.changePage(glavnaya_pereitiVKorzinu, "korzina.fxml");
        });

    }
}
