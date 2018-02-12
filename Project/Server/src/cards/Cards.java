package cards;

import java.util.ArrayList;

/**
 * class cards contains from list from all cards
 */
/**
 *
 * @author Anelia
 */
public class Cards implements Sortable{
    public ArrayList<Card> encryptedCards=new ArrayList<Card>();

    /**
     * default constructor
     */
    public Cards() {
    }
    

    /**
     * getter of list of all encrypted cards
     * @return 
     */
    public ArrayList<Card> getEncryptedCards() {
        return encryptedCards;
    }
    
    /**
     * method contains. Check if a card is already encrypted
     * @param c
     * @return 
     */
    public boolean contains(Card c){
        if(encryptedCards.isEmpty())
        {
            return false;
        }else{
        return encryptedCards.contains(c);
        }
    }

    /**
     * Set encrypted cards list
     * @param encryptedCards 
     */
    public void setEncryptedCards(ArrayList<Card> encryptedCards) {
        this.encryptedCards = encryptedCards;
    }

    /**
     * constructor with 1 argument
     * @param encryptedCards 
     */
    public Cards(ArrayList<Card> encryptedCards) {
        setEncryptedCards(encryptedCards);
    }

    /**
     * override method sortByBankId from interface sortable.
     * sorts cards by card number
     * calls comparator method
     */
    @Override
    public void sortByBankId() {
        encryptedCards.sort(new ComparatorByIdCard());
    }
    
}
