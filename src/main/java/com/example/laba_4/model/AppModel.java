package com.example.laba_4.model;

import com.example.laba_4.HelloApplication;
import com.example.laba_4.patternObserver.KorzinaButtonObserver;
import com.example.laba_4.patternObserver.ModelObserver;
import com.example.laba_4.patternStrategy.ReadFile;
import com.example.laba_4.patternStrategy.WorkWithFile;
import com.example.laba_4.patternStrategy.WriteToFile;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AppModel {
    private int activeIndex = 0;
    private boolean userRegistSuccess = false;
    private int activeUserId = -1;
    ArrayList<User> arrusers = new ArrayList<>();
    ArrayList<Usluga> arrayUslugi = new ArrayList<>();
    WorkWithFile action = new WorkWithFile();
    ModelObserver modalObserver = new ModelObserver();

    private static AppModel instance;
    public static AppModel getInstance() {
        if (instance == null) {
            instance = new AppModel();
        }
        return instance;
    }

    public void showUsluga(ImageView app_image, Label app_title, TextArea app_text, Label app_cost, Label app_add_success) {
        app_add_success.setText("");
        Usluga usluga = arrayUslugi.get(activeIndex);
        Image image = new Image(getClass().getResourceAsStream(usluga.getImage_src()));
        app_image.setImage(image);
        app_text.setText(usluga.getText());
        app_title.setText(usluga.getNazvanie());
        app_cost.setText(usluga.getCena() + " руб.");
    }

    public void setActiveIndexPrev() {
        int length = arrayUslugi.size();
        if (activeIndex == 0) activeIndex = length - 1;
        else activeIndex--;
    }
    public void setActiveIndexNext() {
        int length = arrayUslugi.size();
        if (activeIndex == length - 1) activeIndex = 0;
        else activeIndex++;
    }

    public static void deleteFocus(AnchorPane anchor_pane) {
        Platform.runLater(() -> anchor_pane.requestFocus());
    }

    public static void changePage(Node buttonClicked, String fxml) {
        buttonClicked.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource(fxml));
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Автомастерская \"Карбюратор\"");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void fillUslugi() {
        Usluga usluga1 = new Usluga(1, "/foto/dvigatel.png", "Замена двигателя", "Наша команда опытных специалистов оперативно и профессионально осуществляет замену двигателя, восстанавливая мощность вашего автомобиля.", 20);
        Usluga usluga2 = new Usluga(2, "/foto/karburator.png", "Ремонт карбюратора", "Мы тщательно диагностируем и качественно восстанавливаем работу карбюратора, обеспечивая плавный ход и экономичное топливопотребление.", 78);
        Usluga usluga3 = new Usluga(3, "/foto/korobka_peredach.png", "Замена коробки передач", "Наши специалисты проводят точную диагностику коробки передач для выявления и решения любых проблем, обеспечивая надежность передач и плавное переключение.", 60);
        Usluga usluga4 = new Usluga(4, "/foto/podveska.png", "Диагностика подвески", "Мы гарантируем качественный ремонт подвески, обеспечивая комфорт и безопасность на дороге.", 45);
        Usluga usluga5 = new Usluga(5, "/foto/shiny.png", "Шиномонтаж", "Наши мастера осуществляют быстрый и профессиональный шиномонтаж, обеспечивая надежное сцепление с дорогой.", 35);
        Usluga usluga6 = new Usluga(6, "/foto/starter.png", "Замена стартера", "Автомастерская \"Карбюратор\" обеспечивает эффективную замену стартера, чтобы ваш автомобиль запускался без сбоев.", 36);
        Usluga usluga7 = new Usluga(7, "/foto/tormoznaya_sistema.png", "Замена тормозной системы", "Наша тщательная диагностика тормозной системы гарантирует надежную работу тормозов, обеспечивая безопасность на дороге.", 44);
        Usluga usluga8 = new Usluga(8, "/foto/vyhlopnaya_sistema.png", "Замена выхлопной системы", "Мы проводим точную диагностику выхлопной системы для определения и устранения любых неисправностей, обеспечивая экологичность и эффективность работы вашего автомобиля.", 26);
        arrayUslugi.add(usluga1);
        arrayUslugi.add(usluga2);
        arrayUslugi.add(usluga3);
        arrayUslugi.add(usluga4);
        arrayUslugi.add(usluga5);
        arrayUslugi.add(usluga6);
        arrayUslugi.add(usluga7);
        arrayUslugi.add(usluga8);
        action.setInteraction(new WriteToFile());
        action.doAction("uslugi.txt", arrayUslugi);
    }
    public void setUserRegistSuccess(boolean isSuccess) {
        userRegistSuccess = isSuccess;
    }
    public boolean isUserRegistSuccess() {
        return userRegistSuccess;
    }

    public boolean addUser(Label signUp_error, TextField fxml_login, TextField fxml_password) {
        int id = 0;
        boolean alreadyExist = false;
        String login = fxml_login.getText().trim();
        String password = fxml_password.getText().trim();

        if (!login.isEmpty() && !password.isEmpty()) {
            if (arrusers.isEmpty()) {
                action.setInteraction(new ReadFile());
                action.doAction("users.txt", arrusers);
            }
            for (User item: arrusers) {
                if (login.equals(item.getLogin())) alreadyExist = true;
            }

            if (!alreadyExist) {
                if (arrusers.size() > 0) id = arrusers.get(arrusers.size() - 1).getId() + 1;
                User user = new User(id, login, password);
                arrusers.add(user);
                userRegistSuccess = true;
                action.setInteraction(new WriteToFile());
                action.doAction("users.txt", arrusers);
                return true;
            }
            else signUp_error.setText("*Такой пользователь уже существует");
        }
        else signUp_error.setText("*Все поля должны быть заполнены");
        return false;
    }

    public boolean checkUser(Label signIn_error, TextField fxml_login, TextField fxml_password) {
        String login = fxml_login.getText().trim();
        String password = fxml_password.getText().trim();

        if (!login.isEmpty() && !password.isEmpty()) {
            if (arrusers.isEmpty()) {
                action.setInteraction(new ReadFile());
                action.doAction("users.txt", arrusers);
            }
            if (arrayUslugi.isEmpty()) {
                action.setInteraction(new ReadFile());
                action.doAction("uslugi.txt", arrayUslugi);
            }
            for (User item: arrusers) {
                if (login.equals(item.getLogin())) {
                    if (password.equals(item.getPassword())) {
                        activeUserId = item.getId();
                        System.out.println();
                        return true;
                    }
                    else {
                        signIn_error.setText("*Неверный пароль");
                        return false;
                    }
                }
            }
            signIn_error.setText("*Нет такого пользователя");
        }
        else signIn_error.setText("*Все поля должны быть заполнены");
        return false;
    }

    public void addItemToKorzina(Label fxml_success) {
        String nazvanie = arrayUslugi.get(activeIndex).getNazvanie();
        double cena = arrayUslugi.get(activeIndex).getCena();
        for(User user: arrusers) {
            if (user.getId() == activeUserId) {
                user.addUslugaToKorzina(nazvanie, cena);
                action.setInteraction(new WriteToFile());
                action.doAction("users.txt", arrusers);
                fxml_success.setText("Услуга добавлена в корзину!");
            }
        }
    }

    public ArrayList<Korzina> getArrayKorzina() {
        for(User user: arrusers) {
            if (user.getId() == activeUserId) {
                return user.getArrayKorzina();
            }
        }
        return null;
    }

    public int getArrayKorzinaLength() {
        ArrayList<Korzina> basket = getArrayKorzina();
        return basket.size();
    }

    public void clearKorzina() {
        for(User user: arrusers) {
            if (user.getId() == activeUserId) {
                user.clearKorzina();
                action.setInteraction(new WriteToFile());
                action.doAction("users.txt", arrusers);
            }
        }
    }

    public void addKorzinaObserver(KorzinaButtonObserver observer) {
        modalObserver.addObserver(observer);
        if (getArrayKorzina().size() != 0) {
            modalObserver.notifyObservers(true);
        }
    }
}
