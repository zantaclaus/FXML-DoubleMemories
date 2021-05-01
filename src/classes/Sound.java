package classes;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {

    public static void soundEffect(String soundName){
        Media click = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + "/src/sounds/" + soundName);
        MediaPlayer clickPlayer = new MediaPlayer(click);

        clickPlayer.play();
    }
}
