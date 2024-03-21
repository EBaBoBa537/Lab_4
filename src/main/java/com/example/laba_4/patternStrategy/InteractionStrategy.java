package com.example.laba_4.patternStrategy;

import java.util.ArrayList;

public interface InteractionStrategy {
    <T> void work(String fileName, ArrayList<T> arr);
}
