package server;

/**
 * One of the most important class.
 * Implements Cryptable interface.
 * Here is the main logic for encode and decode.
 */
import cards.Card;
import cards.Cards;
import common.Chryptable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Encryption extends UnicastRemoteObject implements Chryptable {


    public Cards cards;

    /**
     * constructor
     * @throws RemoteException 
     */
    public Encryption() throws RemoteException {
        cards = new Cards();
    }

    /**
     * event handller for button encode clicked
     * Encode the card.
     * Check if card is already encrypted. If true we add encrypted code to
     * sublist of encrypted codes for the exact card.
     * If false we add  the cards in list of all cards.
     * @param code
     * @return 
     */
    @Override
    public String encode(String code) {
        char[] inputArr = code.toCharArray();
        ArrayList<Integer> resultArr = new ArrayList<Integer>();

        for (char current : inputArr) {
            if (Character.isDigit(current)) {
                int shiftedSymbol = (Character.getNumericValue(current) + 5) % 10;
                resultArr.add(shiftedSymbol);
            }
        }

        Card c = new Card(code);
        
        if (cards.contains(c)) {
            int index = cards.getEncryptedCards().indexOf(c);
            c = cards.getEncryptedCards().get(index);
            int num = c.getEncodedCodes().size();
            if (num > 12) {
                System.out.println("Error while adding!");
                return "";
            }
            c.getEncodedCodes().add(resultArr.toString());
        } else {
            c.getEncodedCodes().add(resultArr.toString());
            cards.getEncryptedCards().add(c);
        }

        return resultArr.toString();
    }

    /**
     * Event handler for button decode clicked
     * @param code
     * @return 
     */
    @Override
    public String decode(String code) {
        char[] inputArr = code.toCharArray();
        ArrayList<Integer> resultArr = new ArrayList<Integer>();

        for (char current : inputArr) {
            if (Character.isDigit(current)) {
                int shiftedSymbol = Math.abs((Character.getNumericValue(current) - 5)) % 10;
                resultArr.add(shiftedSymbol);
            }
        }

        return resultArr.toString();
    }

}
