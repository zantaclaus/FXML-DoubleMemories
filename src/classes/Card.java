package classes;

public class Card {

    /* Field */

    private int id = 0;
    private boolean isOpen;
    private boolean isPair;

    /* Method */

    public Card(int id) {
        this.id = id;
        this.isOpen = false;
        this.isPair = false;
    }

    public int getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean open) {
        isOpen = open;
    }

    public boolean isPair() {
        return isPair;
    }

    public void setIsPair(boolean pair) {
        isPair = pair;
    }

}
