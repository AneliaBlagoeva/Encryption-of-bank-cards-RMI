/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import java.util.ArrayList;

/**
 *
 * @author Anelia
 */
public class Cards implements Sortable{
    public ArrayList<Card> encryptedCards;

    public Cards() {
    }
    
    

    public ArrayList<Card> getEncryptedCards() {
        return encryptedCards;
    }

    public void setEncryptedCards(ArrayList<Card> encryptedCards) {
        this.encryptedCards = encryptedCards;
    }

    public Cards(ArrayList<Card> encryptedCards) {
        setEncryptedCards(encryptedCards);
    }

    @Override
    public void sortByBankId() {
        encryptedCards.sort(new ComparatorByIdCard());
    }

    @Override
    public void sortByEncryptedId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
