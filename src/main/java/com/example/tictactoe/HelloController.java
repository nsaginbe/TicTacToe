package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {
    public boolean[] used = new boolean[10];
    public int queue = 0;
    public boolean over;

    @FXML
    public Button Button1;
    @FXML
    public Button Button2;
    @FXML
    public Button Button3;
    @FXML
    public Button Button4;
    @FXML
    public Button Button5;
    @FXML
    public Button Button6;
    @FXML
    public Button Button7;
    @FXML
    public Button Button8;
    @FXML
    public Button Button9;

    @FXML
    public Label txt;
    @FXML
    public Button restart;

    @FXML
    protected void onRestartClick() {
        Button1.setText("");
        Button2.setText("");
        Button3.setText("");
        Button4.setText("");
        Button5.setText("");
        Button6.setText("");
        Button7.setText("");
        Button8.setText("");
        Button9.setText("");

        txt.setAlignment(Pos.CENTER);
        txt.setText("TicTacToe");

        queue = 0;
        for (int i = 1; i <= 9; i++){
            used[i] = false;
        }
        over = false;
    }

    @FXML
    protected void onButtonClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        int idx = HelloApplication.getIndex(btn.getId());
        if (!used[idx] && !over){
            used[idx] = true;
            if (queue == 0){
                btn.setText("X");
            }
            else {
                btn.setText("O");
            }
            queue = 1 - queue;

            checkForWin();
        }

        boolean fu = true;
        for (int i = 1; i <= 9; i++){
            if (!used[i]){
                fu = false;
                break;
            }
        }
        if (fu){
            over = true;
            txt.setAlignment(Pos.CENTER);
            txt.setText("FUCK YOU");
        }
    }

    public void checkForWin() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add(Button1.getText() + Button2.getText() + Button3.getText());
        arr.add(Button4.getText() + Button5.getText() + Button6.getText());
        arr.add(Button7.getText() + Button8.getText() + Button9.getText());
        arr.add(Button1.getText() + Button4.getText() + Button7.getText());
        arr.add(Button2.getText() + Button5.getText() + Button8.getText());
        arr.add(Button3.getText() + Button6.getText() + Button9.getText());
        arr.add(Button1.getText() + Button5.getText() + Button9.getText());
        arr.add(Button3.getText() + Button5.getText() + Button7.getText());

        for (String el : arr){
            if (el.equals("XXX")){
                over = true;
                txt.setAlignment(Pos.CENTER);
                txt.setText("X WINS!");
            }
            else if (el.equals("OOO")){
                over = true;
                txt.setAlignment(Pos.CENTER);
                txt.setText("O WINS!");
            }
        }
    }
}