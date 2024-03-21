package com.example.laba_4.model;

import java.io.Serializable;

public class Usluga implements Serializable {
    private int id;
    private String image_src;
    private String nazvanie;
    private String text;
    private double cena;

    public Usluga(int id, String image_src, String nazvanie, String text, double cena) {
        this.id = id;
        this.image_src = image_src;
        this.nazvanie = nazvanie;
        this.text = text;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }
    public String getImage_src() {
        return image_src;
    }
    public String getNazvanie() {
        return nazvanie;
    }
    public String getText() {
        return text;
    }
    public double getCena() {
        return cena;
    }
}
