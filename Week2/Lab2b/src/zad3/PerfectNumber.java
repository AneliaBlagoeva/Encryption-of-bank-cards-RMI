/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author user
 */
public class PerfectNumber {

    public static final int NUMBER_PER_LINE = 5;
    public static final int NUMBER_OF_PERFECTS = 10000;

    public boolean isPerfect(int number) {
        //declaration
        int sum;
        //initialization
        sum = 0;

        //processing
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }

        if (sum == number) {
            sum = 0;
            return true;
        } else {
            sum = 0;
            return false;
        }
        //output
    }

    public void showMultipliers(int number) {
        //decaration
        int counter;//count elements per line

        //initialization
        counter = 0;

        //processing
        if (isPerfect(number)) {
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    if (counter <= NUMBER_PER_LINE) {
                        System.out.printf("%d ", i);
                        counter++;
                    } else {
                        System.out.printf("%n%d ", i);
                        counter = 0;
                    }
                }
            }
        }

    }

}
