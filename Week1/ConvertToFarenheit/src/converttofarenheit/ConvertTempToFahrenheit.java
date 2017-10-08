/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converttofarenheit;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class ConvertTempToFahrenheit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //declaration
        
        double celsiusTemp, //celsius temp
                fahrenheitTemp; // fahrenheit temp
        
        Scanner kbd;
        
        //initialization
        
        kbd=new Scanner(System.in);
       
        System.out.print("Enter temp in Celsius:  ");
        celsiusTemp=kbd.nextDouble();
        
        //processing
        
        fahrenheitTemp=9.0/5.0*celsiusTemp + 32;
        //output
        System.out.printf("Fahrenheit : %.2f from celsius: %.2f%n ", 
                                                    fahrenheitTemp,celsiusTemp);
    }
    
}
