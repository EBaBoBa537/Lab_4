package com.example.laba_4.controllers;

import com.example.laba_4.model.AppModel;
import com.example.laba_4.model.Korzina;
import com.example.laba_4.patternObserver.KorzinaButtonObserver;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class KorzinaController {
    AppModel appModel = AppModel.getInstance();

    @FXML
    private Button korzina_zakazatButton;

    @FXML
    private Button korzina_nazad;

    @FXML
    private Label korzina_itogo;

    @FXML
    private TableView<Korzina> korzina_table;

    @FXML
    private TableColumn<Korzina, String> korzina_table_nazvanie;

    @FXML
    private TableColumn<Korzina, Double> korzina_table_cena;

    @FXML
    void initialize() {
        KorzinaButtonObserver basketButton = new KorzinaButtonObserver(korzina_zakazatButton);
        appModel.addKorzinaObserver(basketButton);

        ArrayList<Korzina> basketList = appModel.getArrayKorzina();
        ObservableList<Korzina> data = FXCollections.observableArrayList(basketList);
        korzina_table.setItems(data);
        korzina_table_nazvanie.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNazvanie()));
        korzina_table_cena.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getCena()).asObject());

        double sum = 0;
        for(Korzina item: basketList) sum += item.getCena();
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        String sumFormat = decimalFormat.format(sum);
        korzina_itogo.setText("Итого: " + sumFormat + " руб.");

        korzina_nazad.setOnAction(e -> {
            appModel.changePage(korzina_nazad, "glavnaya.fxml");
        });

        korzina_zakazatButton.setOnAction(e -> {
            if (appModel.getArrayKorzinaLength() != 0) {
                appModel.clearKorzina();
                appModel.changePage(korzina_zakazatButton, "spasibo.fxml");
            }
        });
    }
}
