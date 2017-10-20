/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class ComputeCosineTest {
    public static void main(String[] args) {
            //declaration
            Scanner kbd;
            ComputeCosine c;
            double x;
            double epsilon;
            double result;
            
            //initialization
            kbd=new Scanner(System.in);
            System.out.print("Enter x:");

            x=kbd.nextDouble();
            
            System.out.print("Enter epsilon:");
            epsilon=kbd.nextDouble();
            
            c=new ComputeCosine(epsilon);
            //processing
            result=c.computeCos(x);
            
            //output
            System.out.printf("Cos(%.6f)=%.6f %n",x,result);
            
    }
}
