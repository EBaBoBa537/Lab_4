package com.example.laba_4.patternStrategy;

import java.util.ArrayList;

public class WorkWithFile {
    private InteractionStrategy interaction;

    public void setInteraction(InteractionStrategy interaction) {
        this.interaction = interaction;
    }

    public <T> void doAction(String fileName, ArrayList<T> arr) {
        interaction.work(fileName, arr);
    }
}
