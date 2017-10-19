package zad3;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Filtered5DigitNumber {

    public static void main(String[] args) {

        //declaration
        int digit1,//first digit reading lefto to right
                digit2,
                digit3,
                digit4,
                digit5;
        int counterCondOne,//condition for digit intervals
                counterCondTwo;//mod 12==0
        double probability;//stores probability of satisfying both cond

        //initialization
        counterCondOne = 0;
        counterCondTwo = 0;
        probability = 0;

        //processing
        for (int input = 10000; input <= 99999; input++) {
            digit5 = input % 10;
            digit4 = (input / 10) % 10;
            digit3 = (input / 100) % 10;
            digit2 = (input / 1000) % 10;
            digit1 = (input / 10000);

            if ((digit1 >= 3 && digit1 <= 9)
                    && (digit2 >= 2 && digit2 <= 8)
                    && (digit3 >= 4 && digit3 <= 9)
                    && (digit4 >= 1 && digit4 <= 6)
                    && (digit5 >= 6 && digit5 <= 9)) {
                counterCondOne++;
                if (input % 12 == 0) {
                    counterCondTwo++;
                }
            }//for

        }

        probability = (counterCondTwo / 89999.0);
        //output
        String result = String.format("Probability: %0$.5f%n"
                + "Numbers that satisfiy condition one: %d%n"
                + "Numbers that satisfy condition two: %d%n", probability,
                counterCondOne, counterCondTwo);

        System.out.println(result);
    }

}
