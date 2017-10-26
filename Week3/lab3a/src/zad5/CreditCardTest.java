/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

public class CreditCardTest {
     public static void main(String[] args) {
        CreditCard c = new CreditCard(1114563289712L);
        boolean flag=c.isValid(4388576018410707L);
         System.out.printf("Is the card valid: %b%n",flag);
    }
    
}
