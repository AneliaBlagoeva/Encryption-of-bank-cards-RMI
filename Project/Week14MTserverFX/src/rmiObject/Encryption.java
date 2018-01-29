/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Encryption extends UnicastRemoteObject implements Chryptable  {
   
    public Encryption() throws RemoteException{
    }

    @Override
    public String encode(String input) {
        char[] inputArr = input.toCharArray();
        ArrayList<Integer> resultArr = new ArrayList<Integer>();

        for (char current : inputArr) {
            if (Character.isDigit(current)) {
            int shiftedSymbol = (Character.getNumericValue(current) + 5) % 10;
            resultArr.add(shiftedSymbol);
            }
        }

        return resultArr.toString();
    }

    @Override
    public  String decode(String input) {
        char[] inputArr = input.toCharArray();
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
