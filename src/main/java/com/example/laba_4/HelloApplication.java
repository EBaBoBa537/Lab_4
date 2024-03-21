package com.example.laba_4;

import com.example.laba_4.model.AppModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AppModel.getInstance().fillUslugi();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("voiti.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Автомастерская \"Карбюратор\"");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}