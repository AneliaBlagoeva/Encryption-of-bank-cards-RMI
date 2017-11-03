package cardStats;
public class Card {

    private int face; // face of card ("Ace", "Deuce", ...)
    private int suit; // suit of card ("Hearts", "Diamonds", ...)
    private static String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private static String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
    // two-argument constructor initializes card's face and suit

    public Card(int cardFace, int cardSuit) {
        setFace(cardFace); // initialize face of card
        setSuit(cardSuit); // initialize suit of card
    } // end two-argument Card constructor

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        if (face > -1 && face < 13) {
            this.face = face;
        } else {
            this.face = 0;
        }
    }
    public int getSuit() {
        return suit;
    }
    public void setSuit(int suit) {
        if (suit > -1 && suit < 4) {
            this.suit = suit;
        } else {
            this.suit = 0;
        }
    }
    // return String representation of Card
    public String toString() {
        return faces[face] + " of " + suits[suit];
    } // end method toString
} // end class Card

