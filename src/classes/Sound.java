package classes;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {

    public static void soundEffect(String soundName){

        Media media = new Media(Sound.class.getResource("/sounds/" + soundName).toExternalForm());
        MediaPlayer clickPlayer = new MediaPlayer(media);

        clickPlayer.play();
    }
}
