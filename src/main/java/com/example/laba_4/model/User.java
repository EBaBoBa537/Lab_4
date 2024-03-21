package com.example.laba_4.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private int id;
    private String login;
    private String password;
    ArrayList<Korzina> arrayKorzina = new ArrayList<>();

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public void addUslugaToKorzina(String nazvanie, double cena) {
        Korzina item = new Korzina(nazvanie, cena);
        arrayKorzina.add(item);
    }

    public void clearKorzina() {
        arrayKorzina.clear();
    }

    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<Korzina> getArrayKorzina() {
        return arrayKorzina;
    }
}
