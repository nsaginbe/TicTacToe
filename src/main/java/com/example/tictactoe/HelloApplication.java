package com.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class HelloApplication extends Application {
    private static final HashMap<String, Integer> idx = new HashMap<>();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();

        idx.put("Button1", 1);
        idx.put("Button2", 2);
        idx.put("Button3", 3);
        idx.put("Button4", 4);
        idx.put("Button5", 5);
        idx.put("Button6", 6);
        idx.put("Button7", 7);
        idx.put("Button8", 8);
        idx.put("Button9", 9);
    }

    public static int getIndex(String s){
        return idx.get(s);
    }

    public static void main(String[] args) {
        launch();
    }
}