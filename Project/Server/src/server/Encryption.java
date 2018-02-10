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

    Cards cards = new Cards();

    public Encryption() throws RemoteException {

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
        if (cards.getEncryptedCards().contains(c)) {
            int index = cards.getEncryptedCards().indexOf(c);
            c = cards.getEncryptedCards().get(index);
            int num = c.getEncodedCode().size();
            if (num > 12) {
                return "";
            }
            c.getEncodedCode().add(resultArr.toString());
        } else {
            c.getEncodedCode().add(resultArr.toString());
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
