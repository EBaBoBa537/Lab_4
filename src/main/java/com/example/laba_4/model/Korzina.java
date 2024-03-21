package com.example.laba_4.model;

import java.io.Serializable;

public class Korzina implements Serializable {
    private String nazvanie;
    private double cena;

    public Korzina(String nazvanie, double cena) {
        this.nazvanie = nazvanie;
        this.cena = cena;
    }

    public String getNazvanie() {
        return nazvanie;
    }
    public double getCena() {
        return cena;
    }
}
