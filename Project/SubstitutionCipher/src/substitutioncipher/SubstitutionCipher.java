/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substitutioncipher;

import java.util.ArrayList;

/**
 *
 * @author Anelia
 */
public class SubstitutionCipher {

    public String input;

    public SubstitutionCipher(String input) {
        setInput(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        if (input != "") {
            this.input = input;
        } else {
            System.out.println("Card number cannot be empty!");
            return;
        }
    }

    public static String encode(String input) {
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

    public static String decode(String input) {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String res = encode("4563 9601 2200 1999");
        System.out.println(res);

        String res2 = encode("9018 4156 7755 6444");
        System.out.println(res2);
    }

}
