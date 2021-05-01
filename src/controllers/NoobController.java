package controllers;

import classes.Card;
import classes.Deck;
import classes.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NoobController implements Initializable{

    /* Field */

    private Deck deck = new Deck(36);
    private ArrayList<Card> myDeck = deck.getDeck();
    private Image[] images = deck.getImage();

    public static boolean isPlayer1 = true;
    private int cardOpen = 0;
    private int countPair = 0;
    private ArrayList<Integer> cardOpenId = new ArrayList<>();
    private ArrayList<Integer> cardOpenIndex = new ArrayList<>();

    @FXML
    private ImageView card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36;
    private ImageView[] cards = new ImageView[37];

    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36;
    private Button[] btns = new Button[37];

    @FXML
    private ImageView imgPlayer1, imgPlayer2;

    @FXML
    private Label labelPlayer1, labelPlayer2;
    private int scorePlayer1 = 0, scorePlayer2 = 0;
    public static boolean isDraw = false;

    /* Method */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCardsToArray();
        setButtonToArray();
        //System.out.println("Noob Mode");
    }

    public void onBtnClick(ActionEvent event) throws IOException {

        String btnId = ((Button)event.getSource()).getId(); // btn1
        int index = getBtnId(btnId);

        // Check Card can open?
        if(!myDeck.get(index).isPair() && (!myDeck.get(index).isOpen() || cardOpen == 2)) {
            cardOpen += 1;
            Sound.soundEffect("click.wav");

            cardOpenId.add(myDeck.get(index).getId());
            cardOpenIndex.add(index);
            if(cardOpen == 2)  {
                if(cardOpenId.get(0) == cardOpenId.get(1)) {

                    Sound.soundEffect("pair.wav");

                    if(isPlayer1) {
                        scorePlayer1 += 1;
                        labelPlayer1.setText(scorePlayer1+"");
                    }
                    else {
                        scorePlayer2 += 1;
                        labelPlayer2.setText(scorePlayer2+"");
                    }

                    cards[cardOpenIndex.get(0)].getStyleClass().add("pass");
                    cards[cardOpenIndex.get(1)].getStyleClass().add("pass");

                    myDeck.get(cardOpenIndex.get(0)).setIsPair(true);
                    myDeck.get(cardOpenIndex.get(1)).setIsPair(true);
                    countPair += 1;
                    cardOpen = 0;

                }

                cardOpenId.clear();
                cardOpenIndex.clear();
            }
        }

        // Change Player
        if(cardOpen == 2 && !myDeck.get(index).isPair()) {
            isPlayer1 = !isPlayer1;
            setPlayer();
        }

        // Close Card
        if(cardOpen == 3) {
            for(int i = 1; i <= 36; i++) {
                if(myDeck.get(i).isOpen() && !myDeck.get(i).isPair()) {
                    cards[i].setImage(new Image("images/0.png"));
                    myDeck.get(i).setIsOpen(false);
                }
            }
            cardOpen = 1;
        }

        // Open Card
        if(!myDeck.get(index).isOpen()) {
            cards[index].setImage(images[index]);
            myDeck.get(index).setIsOpen(true);
        }

        /* System.out.println(btnId + " index:" + index + " isOpen:" + myDeck.get(index).isOpen() + " open:" + cardOpen + " isPlair:" + myDeck.get(index).isPair()); */

        // isWinner
        if(countPair == 18) {
            winnerScene(event);
        }
    }

    public void menuCLick(ActionEvent event) throws IOException {
        Sound.soundEffect("menu.wav");
        AlertController.display();
        if(AlertController.backToMenu) {
            AlertController.backToMenu = false;
            Parent menuParent = FXMLLoader.load(getClass().getResource("../scenes/menu.fxml"));
            Scene menuScene = new Scene(menuParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(menuScene);
            window.show();
        }
    }

    private int getBtnId(String btnId) {
        for(int i = 1; i <= 36; i++) {
            if(btnId.equals("btn" + i) || btnId.equals("btn" + (i - 18)))
                return i;
        }
        return 0;
    }

    private void setCardsToArray() {
        cards[0] = card0;
        cards[1] = card1;
        cards[2] = card2;
        cards[3] = card3;
        cards[4] = card4;
        cards[5] = card5;
        cards[6] = card6;
        cards[7] = card7;
        cards[8] = card8;
        cards[9] = card9;
        cards[10] = card10;
        cards[11] = card11;
        cards[12] = card12;
        cards[13] = card13;
        cards[14] = card14;
        cards[15] = card15;
        cards[16] = card16;
        cards[17] = card17;
        cards[18] = card18;
        cards[19] = card19;
        cards[20] = card20;
        cards[21] = card21;
        cards[22] = card22;
        cards[23] = card23;
        cards[24] = card24;
        cards[25] = card25;
        cards[26] = card26;
        cards[27] = card27;
        cards[28] = card28;
        cards[29] = card29;
        cards[30] = card30;
        cards[31] = card31;
        cards[32] = card32;
        cards[33] = card33;
        cards[34] = card34;
        cards[35] = card35;
        cards[36] = card36;
    }
    private void setButtonToArray() {
        btns[0] = btn0;
        btns[1] = btn1;
        btns[2] = btn2;
        btns[3] = btn3;
        btns[4] = btn4;
        btns[5] = btn5;
        btns[6] = btn6;
        btns[7] = btn7;
        btns[8] = btn8;
        btns[9] = btn9;
        btns[10] = btn10;
        btns[11] = btn11;
        btns[12] = btn12;
        btns[13] = btn13;
        btns[14] = btn14;
        btns[15] = btn15;
        btns[16] = btn16;
        btns[17] = btn17;
        btns[18] = btn18;
        btns[19] = btn19;
        btns[20] = btn20;
        btns[21] = btn21;
        btns[22] = btn22;
        btns[23] = btn23;
        btns[24] = btn24;
        btns[25] = btn25;
        btns[26] = btn26;
        btns[27] = btn27;
        btns[28] = btn28;
        btns[29] = btn29;
        btns[30] = btn30;
        btns[31] = btn31;
        btns[32] = btn32;
        btns[33] = btn33;
        btns[34] = btn34;
        btns[35] = btn35;
        btns[36] = btn36;
    }
    private void setPlayer() {
        if(isPlayer1) {
            imgPlayer1.setImage(new Image("images/Player-1.png"));
            imgPlayer2.setImage(new Image("images/Player-2-black.png"));
        }
        else {
            imgPlayer1.setImage(new Image("images/Player-1-black.png"));
            imgPlayer2.setImage(new Image("images/Player-2.png"));
        }
    }
    private void winnerScene(ActionEvent event) throws IOException {
        if(scorePlayer1 == scorePlayer2) {
            isDraw = true;
        }
        Parent exitParent = FXMLLoader.load(getClass().getResource("../scenes/winner.fxml"));
        Scene exitScene = new Scene(exitParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(exitScene);
        window.show();
    }
}
