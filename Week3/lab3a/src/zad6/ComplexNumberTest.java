/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad6;

import javax.swing.JOptionPane;

public class ComplexNumberTest {

    public static void main(String[] args) {
        //declaration
        ComplexNumber c ;
        double imaginaryPart, realPart;

        //initialization
        imaginaryPart=Double.parseDouble(JOptionPane.showInputDialog("Enter imaginary part: "));
        realPart=Double.parseDouble(JOptionPane.showInputDialog("Enter real part: "));
        
        c = new ComplexNumber(imaginaryPart, realPart);
        
        //output
        JOptionPane.showMessageDialog(null,"Angle: " + c.getAngle() + " Magnitute: " + c.getMagnitute());
        
    }

}
