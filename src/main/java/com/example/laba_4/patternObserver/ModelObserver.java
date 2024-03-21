package com.example.laba_4.patternObserver;

import java.util.ArrayList;

public class ModelObserver {
    private ArrayList<KorzinaButtonObserver> korzinaObservers = new ArrayList<>();

    public void addObserver(KorzinaButtonObserver observer) {
        korzinaObservers.add(observer);
    }

    public void notifyObservers(boolean isItemAdd) {
        for (KorzinaButtonObserver observer : korzinaObservers) {
            observer.updateKorzina(isItemAdd);
        }
    }
}
