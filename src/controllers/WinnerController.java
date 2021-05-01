package controllers;

import classes.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WinnerController implements Initializable {

    @FXML
    private ImageView winnerImg;

    public void menuClick(ActionEvent event) throws IOException {
        Sound.soundEffect("menu.wav");

        Parent exitParent = FXMLLoader.load(getClass().getResource("../scenes/menu.fxml"));
        Scene exitScene = new Scene(exitParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(exitScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(!NoobController.isPlayer1 || !ProController.isPlayer1) {
            if (NoobController.isDraw)
                winnerImg.setImage(new Image("images/Draw.jpg"));
            else
                winnerImg.setImage(new Image("images/player2win.jpg"));
        }
        Sound.soundEffect("winner.wav");
    }
}
