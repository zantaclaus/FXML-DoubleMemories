package controllers;

import classes.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    /* Field */

    @FXML
    private Button btnExit;

    /* Method */

    public void noobMode(ActionEvent event) throws IOException {

        Sound.soundEffect("menu.wav");

        Parent modelParent = FXMLLoader.load(getClass().getResource("../scenes/noob.fxml"));
        Scene modelScene = new Scene(modelParent);
        modelScene.getStylesheets().add("styles/style.css");

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(modelScene);
        window.show();

    }

    public void proMode(ActionEvent event) throws IOException {

        Media click = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + "/src/sounds/Menu.wav");
        MediaPlayer clickPlayer = new MediaPlayer(click);
        clickPlayer.play();

        Parent modelParent = FXMLLoader.load(getClass().getResource("../scenes/pro.fxml"));
        Scene modelScene = new Scene(modelParent);
        modelScene.getStylesheets().add("styles/style.css");

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(modelScene);
        window.show();
    }

    public void exitProgram(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }



}

