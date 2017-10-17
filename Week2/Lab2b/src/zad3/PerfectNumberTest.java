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
public class PerfectNumberTest {

    public static void main(String[] args) {
        //declaration
        PerfectNumber p;

        //initialization
        p = new PerfectNumber();

        //processing
        for (int i = 1; i < p.NUMBER_OF_PERFECTS; i++) {

            if (p.isPerfect(i)) {
                System.out.printf("Perfect number %d: ", i);

                p.showMultipliers(i);
                System.out.printf("%n");
            }
        }

    }

}
