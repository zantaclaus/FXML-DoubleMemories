package classes;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    /* Field */

    private int amount = 36;
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Integer> idList;
    private Image[] images = new Image[51];

    /* Method */

    public Deck(int amount) {
        this.amount = amount;
        idList = getIdList();
        idList = shuffleIdList(idList);
        idList.add(0, 0);
        setCard();
        setImage();
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public Image[] getImage() { return this.images; }

    private ArrayList<Integer> getIdList() {
        ArrayList<Integer> list = new ArrayList();
        System.out.println("amount: " + amount);
        int pair = amount / 2;
        for(int i = 1; i <= amount; i++) {
            if (i > pair)
                list.add(i - pair);
            else list.add(i);
        }
        return list;
    }

    private ArrayList<Integer> shuffleIdList(ArrayList<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

    private void setCard() {
//        for(int i = 1; i <= amount; i++) {
//            if (idList.get(i) <= 9)
//                System.out.print("0"+ idList.get(i)+" ");
//            else
//                System.out.print(idList.get(i)+" ");
//            if(i % 9 == 0)
//                System.out.println("");
//        }
//        System.out.println("");

        for(int i = 0; i <= amount; i++) {
            deck.add(new Card(idList.get(i)));
        }
    }

    private void setImage() {
        for(int i = 0; i <= amount; i++) {
            images[i] = new Image("images/" + idList.get(i) + ".png");
        }
    }


}