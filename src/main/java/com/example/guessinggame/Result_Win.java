package com.example.guessinggame;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Result_Win extends Data implements Initializable {
    @FXML
    private Label resultMessage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       resultMessage.setText(OriginalName+" You won!");
    }
}

