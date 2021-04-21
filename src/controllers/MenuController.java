package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    /* Field */

    @FXML
    private Button btnExit;

    /* Method */

    public void noobMode(ActionEvent event) throws IOException {
        Parent modelParent = FXMLLoader.load(getClass().getResource("../scenes/noob.fxml"));
        Scene modelScene = new Scene(modelParent);
        modelScene.getStylesheets().add("styles/style.css");

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(modelScene);
        window.show();
    }

    public void proMode(ActionEvent event) throws IOException {
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

