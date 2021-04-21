package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertController {

    /* Field */

    public static boolean backToMenu = false;

    /* Method */

    public static void display() throws IOException {
        Parent exitParent = FXMLLoader.load(AlertController.class.getResource("../scenes/alert.fxml"));
        Scene exitScene = new Scene(exitParent);

        Stage window1 = new Stage();
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setTitle("Do you want to exit?");

        window1.setScene(exitScene);
        window1.showAndWait();
    }

    public void noClick(ActionEvent event) {
        closeWindow(event);
    }

    public void yesClick(ActionEvent event) {
        backToMenu = true;
        closeWindow(event);
    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

}