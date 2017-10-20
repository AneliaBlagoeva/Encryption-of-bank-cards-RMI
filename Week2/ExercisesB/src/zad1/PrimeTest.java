/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author user
 */
public class PrimeTest {

    public static void main(String[] args) {
        //declaration
        final int nLimit = 10000;
        IsPrime p;
        //initialization
        
        p=new IsPrime();
        //processing
        //output

        for (int i = 1; i <= Math.sqrt(nLimit); i++) {
            if (p.isPrime(i)) {
                System.out.printf("%d%n", i);
            }

        }

    }
}