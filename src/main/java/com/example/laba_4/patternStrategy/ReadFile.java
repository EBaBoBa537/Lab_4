package com.example.laba_4.patternStrategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFile implements InteractionStrategy {
    public <T> void work(String fileName, ArrayList<T> arr) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<T> newarr = ((ArrayList<T>) ois.readObject());
            arr.addAll(newarr);
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
