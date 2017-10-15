/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class RectangleTest {

    public static void main(String[] args) {
        //declaration
        Rectangle r = new Rectangle();

        String height,//variable for height of the rectangle
                width,//variable for width of the rectangle
                color;//variable for color of the rectangle

        //initialization
        height = JOptionPane.showInputDialog("Enter height: ");
        r.setHeight(Double.parseDouble(height));

        width = JOptionPane.showInputDialog("Enter width: ");
        r.setWidth(Double.parseDouble(width));

        color = JOptionPane.showInputDialog("Enter color: ");
        r.setColor(color);

        //output
        System.out.printf("Area of the rectangle is: %.2f%nParameter of the rectangle is: %.2f%n",
                r.getArea(), r.getParameter());
    }

}
