package com.example.laba_4.patternStrategy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteToFile implements InteractionStrategy {
    public <T> void work(String fileName, ArrayList<T> arr) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arr);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
