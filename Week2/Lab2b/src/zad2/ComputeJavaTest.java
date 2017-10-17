/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

/**
 *
 * @author user
 */
public class ComputeJavaTest {

    public static void main(String[] args) {
        //declaration
        double result;
        double pi;
        ComputeSin c;
        //initialization
        c = new ComputeSin();
        pi = 3.14;
        //processing
        for (double x = 0; x <= (pi / 2); x = x + 0.1) {
            result = c.computeSin(x);
            System.out.printf("%.3f\n", result);
        }
        //output
    }

}
