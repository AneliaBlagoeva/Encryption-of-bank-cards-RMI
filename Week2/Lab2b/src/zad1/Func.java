/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Func {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //declaration
        double start,//start of the interval
                end,//end of the virtual
                step;//step between values in the interval
        double result;//stores the result
        Scanner kbd;
        int counter;//helps for partitioning the output

        //initialization
        counter = 0;
        kbd = new Scanner(System.in);

        System.out.print("Enter start of the interval: ");
        start = kbd.nextDouble();

        System.out.print("Enter end of the interval: ");
        end = kbd.nextDouble();

        if (start > end) {
            double temp = start;
            end = start;
            start = temp;
        }

        System.out.print("Enter step of the interval: ");
        step = kbd.nextDouble();

        //processing
        for (double i = start; i <= end; i = i + step) {
            if (counter <= 20) {
                result = (Math.pow((i - 2.0), 2)) / (Math.pow(i, 2) + 1.0);
                System.out.printf("%.2f%,20.4f\n", i, result);
                counter++;
            } else {
                System.out.println("Press return to continue.");
                kbd.nextLine();
                counter = 0;
            }
        }
        //output
    }

}
