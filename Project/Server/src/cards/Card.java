package cards;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Card class contains card id and list from encrypted codes of the card. One
 * card can have more than one encrypted code
 */
/**
 *
 * @author Anelia
 */
public class Card {

    String cardId;
    ArrayList<EncryptedCode> encodedCodes;

    public Card() {
        encodedCodes = new ArrayList<EncryptedCode>();
    }

    /**
     * getter of card id
     *
     */
    public String getCardId() {

        return cardId;
    }

    /**
     * constructor of class card
     *
     * @param cardId
     */
    public Card(String cardId) {
        setCardId(cardId);
        encodedCodes = new ArrayList<EncryptedCode>();
    }

    /**
     * setter of card class sets card id
     *
     * @param cardId
     */
    public void setCardId(String cardId) {
        if (cardId.length() > 16) {
            System.out.println("Invalid number");
        } else {
            this.cardId = cardId;
        }
    }

    public ArrayList<EncryptedCode> getEncodedCodes() {
        return encodedCodes;
    }

    public ArrayList<String> EncryptedCodeToStringList(){
        ArrayList<String> result=new ArrayList<>();
        
        for(EncryptedCode e:encodedCodes){
            result.add(e.code);
    }
        return result;
    }
    /**
     * setter of card class sets encrypted codes list
     *
     * @param encodedCodes
     */
    public void setEncodedCodes(ArrayList<EncryptedCode> encodedCodes) {
        this.encodedCodes = encodedCodes;
    }

    /**
     * constructor of class card
     *
     * @param cardId
     * @param encodedCode
     */
    public Card(String cardId, ArrayList<EncryptedCode> encodedCode) {
        setCardId(cardId);
        setEncodedCodes(encodedCode);
    }

    /**
     * override method equals for using method contains compare cards by card id
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        } else {
            return (this.cardId.equals(((Card) obj).getCardId()));
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.cardId);
        return hash;
    }

    /**
     * override method to string
     * @return 
     */
    @Override
    public String toString() {
        return "Card{" + "cardId=" + cardId + ", encodedCodes=" + encodedCodes + '}';
    }

}
