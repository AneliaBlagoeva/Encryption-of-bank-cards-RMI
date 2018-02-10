/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import clients.User;
import java.util.ArrayList;

/**
 *
 * @author Anelia
 */
public class Card{
    String cardId;
    ArrayList<String> encodedCode;

    public String getCardId() {
        
        return cardId;
    }

    public Card(String cardId) {
        this.cardId = cardId;
    }
    
    

    public void setCardId(String cardId) {
        if(cardId.length()<16){
            System.out.println("Invalid number");
        }else{
        this.cardId = cardId;
        }
    }

    public ArrayList<String> getEncodedCode() {
        return encodedCode;
    }

    public void setEncodedCode(ArrayList<String> encodedCode) {
        this.encodedCode = encodedCode;
    }

    public Card(String cardId, ArrayList<String> encodedCode) {
        setCardId(cardId);
        setEncodedCode(encodedCode);
    }

 @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        } else {
            return (this.cardId.equals(((Card) obj).getCardId()) );
        }
    }

}
