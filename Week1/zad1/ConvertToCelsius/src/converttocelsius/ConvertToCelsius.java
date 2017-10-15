/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converttocelsius;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class ConvertToCelsius {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //declaration
        double fahrenheitTemp,//user input
                celsiusTemp;//save result
        Scanner kbd;
        
        //initialization
        kbd=new Scanner(System.in);
        
        System.out.print("Enter temperature in Fahrenheit: ");
        fahrenheitTemp=kbd.nextDouble();
        
        //processing
        celsiusTemp= 5.0 / 9.0 * ( fahrenheitTemp - 32 );
        
        //output
        System.out.printf("Celsius is: %.2f from fahrenheit: %.2f%n",
                                                   celsiusTemp, fahrenheitTemp);
    }
    
}
