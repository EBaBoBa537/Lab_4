package com.example.laba_4.patternObserver;

import javafx.scene.control.Button;

public class KorzinaButtonObserver  implements KorzinaObserver {
    private Button button_fxml;

    public KorzinaButtonObserver(Button button_fxml) {
        this.button_fxml = button_fxml;
    }

    @Override
    public void updateKorzina(boolean isItemAdd) {
        if (isItemAdd) {
            button_fxml.setStyle("-fx-background-color: #D8DEE4;");
        }
    }
}
