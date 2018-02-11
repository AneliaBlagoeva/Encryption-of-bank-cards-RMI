/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Anelia
 */
public class Card{
    String cardId;
    ArrayList<String> encodedCodes;

    public String getCardId() {
        
        return cardId;
    }

    public Card(String cardId) {
        this.cardId = cardId;
        encodedCodes=new ArrayList<String>();
    }
    
    

    public void setCardId(String cardId) {
        if(cardId.length()<16){
            System.out.println("Invalid number");
        }else{
        this.cardId = cardId;
        }
    }

    public ArrayList<String> getEncodedCodes() {
        return encodedCodes;
    }

    public void setEncodedCodes(ArrayList<String> encodedCodes) {
        this.encodedCodes = encodedCodes;
    }

    public Card(String cardId, ArrayList<String> encodedCode) {
        setCardId(cardId);
        setEncodedCodes(encodedCode);
    }

 @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        } else {
            return (this.cardId.equals(((Card) obj).getCardId()) );
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.cardId);
        return hash;
    }

}
