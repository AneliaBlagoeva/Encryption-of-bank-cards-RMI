package server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cards.Card;
import cards.Cards;
import common.Chryptable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Encryption extends UnicastRemoteObject implements Chryptable {

    //create empty cards
    //fill with encode
    public Cards cards;

    public Encryption() throws RemoteException {
        cards = new Cards();
    }

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

    @Override
    public String decode(String code) {
        char[] inputArr = code.toCharArray();
        ArrayList<Integer> resultArr = new ArrayList<Integer>();

        for (char current : inputArr) {
            if (Character.isDigit(current)) {
                int shiftedSymbol = (Character.getNumericValue(current) - 5) % 10;
                resultArr.add(shiftedSymbol);
            }
        }

        return resultArr.toString();
    }

}
