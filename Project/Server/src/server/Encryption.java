package server;

/**
 * One of the most important class. Implements Cryptable interface. Here is the
 * main logic for encode and decode.
 */
import cards.Card;
import cards.Cards;
import cards.EncryptedCode;
import common.Chryptable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Encryption extends UnicastRemoteObject implements Chryptable {

    public Cards cards;

    /**
     * constructor
     *
     * @throws RemoteException
     */
    public Encryption() throws RemoteException {
        cards = new Cards();
    }

    /**
     * event handler for button encode clicked Encode the card. Check if card is
     * already encrypted. If true we add encrypted code to sublist of encrypted
     * codes for the exact card. If false we add the cards in list of all cards.
     *
     * @param code
     * @return
     */
    public static StringBuilder helperEncode(int cryptogram, char[] inputArr) {
        StringBuilder resultArr = new StringBuilder();

        for (char current : inputArr) {
            if (Character.isDigit(current)) {
                int shiftedSymbol = (Character.getNumericValue(current) + cryptogram) % 10;
                resultArr.append((char) (shiftedSymbol + '0'));
            }
        }

        return resultArr;
    }

    @Override
    public String encode(String code) {
        char[] inputArr = code.toCharArray();

        Boolean existingCard = false;

        String result;
        Card c = new Card(code);
        existingCard = cards.contains(c);

        if (existingCard) {
            result = new String();

            //find card of all cards
            int index = cards.getEncryptedCards().indexOf(c);
            c = cards.getEncryptedCards().get(index);

            int crypto = (c.getEncodedCodes().get(c.getEncodedCodes().size() - 1).getCryptogram()) + 1;
            result = new String(helperEncode(crypto, inputArr).toString());

            int num = c.getEncodedCodes().size();
            if (num > 12) {
                System.out.println("Error while adding!");
                return "";
            }

            c.getEncodedCodes().add(new EncryptedCode(result, crypto));
        } else {
            result = new String();

            result = new String(helperEncode(5, inputArr).toString());
            c.getEncodedCodes().add(new EncryptedCode(result, 5));
            cards.getEncryptedCards().add(c);
        }

        return result;
    }


    /**
     * Event handler for button decode clicked
     * We are searching in list with encrypted cards
     * if we find such a card return card id
     * if we dont find such a card return empty string
     * @param code
     * @return
     */
    @Override
    public String decode(String code) {
        String result = "";
        Boolean flag = false;
        Boolean existingCard = false;
        Card ourCard = new Card();

        EncryptedCode en = new EncryptedCode(code);

        for (Card c : cards.getEncryptedCards()) {
            flag = c.getEncodedCodes().contains(en);

            if (flag) {
                existingCard = true;
                ourCard = c;
                break;
            }

        }

        if (existingCard) {
            result = new String();
            int index = cards.encryptedCards.indexOf(ourCard);
            result = cards.getEncryptedCards().get(index).getCardId();
        } else {
            return result;
        }

        return result;
    }

}
