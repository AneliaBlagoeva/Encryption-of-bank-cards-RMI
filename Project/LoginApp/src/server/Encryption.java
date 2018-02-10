/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Encryption extends UnicastRemoteObject implements Chryptable {

    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (!code.isEmpty()) {
            this.code = code;
        } else {
            System.out.println("The field for code cannot be empty");
        }
    }

    public Encryption() throws RemoteException {

    }

    public Encryption(String s) throws RemoteException {
        setCode(s);
    }

    @Override
    public String encode() {
        char[] inputArr = code.toCharArray();
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
    public String decode() {
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
