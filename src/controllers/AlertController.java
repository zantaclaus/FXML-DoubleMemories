package controllers;

import classes.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertController {

    /* Field */

    public static boolean backToMenu = false;

    /* Method */

    public static void display() throws IOException {

        Parent alertParent = FXMLLoader.load(AlertController.class.getResource("../scenes/alert.fxml"));
        Scene alertScene = new Scene(alertParent);
        alertScene.getStylesheets().add("styles/style.css");

        Stage window1 = new Stage();
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setTitle("Do you want to exit?");
        window1.getIcons().add(new Image("images/icon.png"));

        window1.setScene(alertScene);
        window1.showAndWait();
    }

    public void noClick(ActionEvent event) {
        Sound.soundEffect("menu.wav");
        closeWindow(event);
    }

    public void yesClick(ActionEvent event) {
        backToMenu = true;
        Sound.soundEffect("menu.wav");
        closeWindow(event);
    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

}