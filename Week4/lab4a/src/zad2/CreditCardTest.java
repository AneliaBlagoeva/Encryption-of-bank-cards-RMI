/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import javax.swing.JOptionPane;

public class CreditCardTest {

    public static void main(String[] args) {
        //declaration
        String input;
        CreditCard c;

        //initialization
        input = JOptionPane.showInputDialog(null, "Enter a credit card number as a long integer: ");
        c = new CreditCard(input);

        //processing
        boolean flag = c.isValid();

        //output
        if (flag) {
            JOptionPane.showMessageDialog(null, input + " is valid");
        } else {
            JOptionPane.showMessageDialog(null, input + " is invalid");
        }
    }

}
