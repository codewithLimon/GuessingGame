package com.example.guessinggame;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Label afterMessage;

    @FXML
    private Label attempts;

    @FXML
    private Label beforeMessage;

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private TextField nameInput;

    @FXML
    private Button nameSubmit;

    @FXML
    private Button number;

    static int countAttempts=2;

    int generatedNumber;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label playerName;

    private String Name;
    @FXML
    void generateNumber(){
        Random random=new Random();
        generatedNumber=random.nextInt(1,4);
        afterMessage.setText("Your number is generated. Guess the number and select the proper circle");
        System.out.println(generatedNumber);
    }

    @FXML
    void circle1Listener(MouseEvent event) throws IOException {
        if(generatedNumber==1){
            won(event);
        }else {
            countChange(event);
        }
    }

    @FXML
    void circle2Listener(MouseEvent event) throws IOException {
        if(generatedNumber==2){
            won(event);
        }else {
            countChange(event);
        }
    }
    @FXML
    void circle3Listener(MouseEvent event) throws IOException {
        if(generatedNumber==3){
            won(event);
        }else{
            countChange(event);
        }
    }

    @FXML
    void nameSubmitClicked(ActionEvent event) {
        Name=nameInput.getText();
    }

    public void countChange(Event event) throws IOException {
        countAttempts--;
        if (countAttempts > 0) {
            attempts.setText("" + countAttempts);
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("lost.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        }

    }
    public void won(Event event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Won.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

