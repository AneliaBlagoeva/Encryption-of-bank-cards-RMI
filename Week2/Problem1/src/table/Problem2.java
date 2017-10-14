/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Problem2 {

    public static void main(String[] args) {
        //declaration

        double begin,
                end;
        int step;
        Scanner kbd;

        //initialiation
        kbd = new Scanner(System.in);

        System.out.print("Enter begin: ");
        begin = kbd.nextDouble();

        System.out.print("Enter end: ");
        end = kbd.nextDouble();

        System.out.print("Enter step: ");
        step = kbd.nextInt();

        //validation
        if (end < begin) { //swaping
            double temp = begin;
            begin = end;
            end = temp;
        }

        Table t = new Table(begin, end, step);

        //output
        t.makeTable();
    }

}
