package com.example.number_guessing;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class mediumController {

    public Label myLabel;
    @FXML
    TextField textField;
    @FXML
    Button myButton;

    int limit = 5;

    int randomnumber = randomNumbergenerator();
    int previousNumber;
    int userInput;


    public void mainMenu(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene1.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
        System.out.println("yOou have entered the Main Menu option");
    }

    Stage stage;

    public void check(ActionEvent event) {
        System.out.println(randomnumber);

        try {
            userInput = Integer.parseInt(textField.getText());
            myLabel.setText("No.of.Limits You Have: "+ --limit);
            System.out.println(limit);


            if(limit <= 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ALERT");
                alert.setHeaderText("Your Limit is over.\n \n Please start again to see your Luck!!!");

                if(alert.showAndWait().get() == ButtonType.OK){
                    Object root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene1.fxml")));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene((Parent) root);
                    stage.setScene(scene);
                    stage.show();
                }
                return;
            }

            if(randomnumber == userInput){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("SPLENDID");
                alert.setHeaderText("Your number is correct.");
                alert.setContentText("Play Again.");

                if(alert.showAndWait().get() == ButtonType.OK){
                    Object root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene1.fxml")));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow ();
                    Scene scene = new Scene((Parent) root);
                    stage.setScene(scene);
                    stage.show();
                }

                return;
            }

            if(userInput<randomnumber){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("WRONG NUMBER");
                alert.setHeaderText("Your number is lies above: "+ userInput);
                alert.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("WRONG NUMBER");
                alert.setHeaderText("Your number is lies below: "+ userInput);
                alert.show();
            }

            previousNumber = userInput;
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("String is found");
            alert.setContentText("Please enter only Numbers.");
            alert.show();

        }
        catch (Exception e){
            System.out.println("wrong input");

        }



    }

    public static int randomNumbergenerator(){
        int minRange = 0;
        int maxRange = 100;


        return (int) (Math.random()*(maxRange-minRange+1)+minRange);
    }
}
