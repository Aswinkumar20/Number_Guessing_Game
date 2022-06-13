package com.example.number_guessing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class scene1Controller {
    @FXML
    private Parent root;
    int mode;
    @FXML
    Label myLabel;

    public void easy(ActionEvent event )throws IOException {
        Object root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("easyMode.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("EASY LEVEL");
        stage.setScene(scene);
        stage.show();
        System.out.println("yOou have entered the easy option");
    }

    public void medium(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mediumMode.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("MEDIUM LEVEL");
        stage.setScene(scene);
        stage.show();
        System.out.println("yOou have entered the medium option");
    }

    public void hard(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hardMode.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setTitle("HARD LEVEL");
        mode = 3;
        stage.setScene(scene);
        stage.show();
        System.out.println("yOou have entered the hard option");
    }
}