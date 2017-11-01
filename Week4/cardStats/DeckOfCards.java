package cardStats;

// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {

    private Card deck[]; // array of Card objects
    private int currentCard; // index of next Card to be dealt
    private final int NUMBER_OF_CARDS = 52; // constant number of Cards
    private Random randomNumbers; // random number generator

    private int[] faceCounters;
    private int[] suitCounters;
    private Card[] hand;

    // constructor fills deck of Cards
    public DeckOfCards() {
        deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
        randomNumbers = new Random(); // create random number generator
        hand = new Card[5];
        faceCounters = new int[13];
        suitCounters = new int[4];
        // populate deck with Card objects
        for (int count = 0; count < deck.length; count++) {
            deck[count]
                    = new Card(count % 13, count / 13);
        }
    } // end DeckOfCards constructor

    private void initData() {
        Arrays.fill(faceCounters, 0);
        Arrays.fill(suitCounters, 0);
        for (int i = 0; i < hand.length; i++) {
            hand[i] = dealCard();
        }
    }

    private void countFaces() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                ++faceCounters[hand[i].getFace()];
            }
        }
    }

    private void countSuits() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                ++suitCounters[hand[i].getSuit()];
            }
        }
    }

    private boolean has3Faces() {
        for (int i = 0; i < faceCounters.length; i++) {
            if (faceCounters[i] == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean has3Suits() {
        for (int i = 0; i < suitCounters.length; i++) {
            if (suitCounters[i] == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean has2Plus2Suits() {
        boolean foundOne = false;
        for (int i = 0; i < suitCounters.length; i++) {
            if (suitCounters[i] == 2 && !foundOne) {
                foundOne = true;
                continue;
            }
            else if(foundOne)
                return true;
        }
        return false;
    }

    public void doStats(){
        shuffle();
        for (int i = 0; i < deck.length; i+= 5) {
            initData();
            printHand();
            System.out.printf("Has three suits: %b%n", has3Suits());
            System.out.printf("Has three faces: %b%n", has3Faces());
            System.out.printf("Has 2 plus 2 suits faces: %b%n", has2Plus2Suits());
        }
    }
    private void printHand() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null)
                System.out.println(hand[i]);
            else
                System.out.println("Missing card");
        }
    }
    // shuffle deck of Cards with one-pass algorithm

    public void shuffle() {
        // after shuffling, dealing should start at deck[ 0 ] again
        currentCard = 0; // reinitialize currentCard

        // for each Card, pick another random Card and swap them
        for (int first = 0; first < deck.length; first++) {
            // select a random number between 0 and 51 
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // swap current Card with randomly selected Card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        } // end for
    } // end method shuffle

    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length) {
            return deck[currentCard++]; // return current Card in array
        } else {
            return null; // return null to indicate that all Cards were dealt
        }
    } // end method dealCard
} // end class DeckOfCards

