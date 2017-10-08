/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converttemperature;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class ConvertTemperature {

    /**
     * @param args the command line arguments
     */
    
    public static double convertToCelsius(double fahrenheitTemp)
    {
        //declaration
        double celsiusTemp;//save result

        //processing
        celsiusTemp= 5.0 / 9.0 * ( fahrenheitTemp - 32 );
        
        return celsiusTemp;
    }
    
    public static double convertToFahrenheit(double celsiusTemp)
    {
        //declaration
        double fahrenheitTemp; // fahrenheit temp
        
        //processing
        fahrenheitTemp=9.0/5.0*celsiusTemp + 32;
        
        return fahrenheitTemp;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //declaration
        double userInput;//user input
        char typeFrom; //symbol from which type temp we will convert
                
        Scanner kbd; //keyboard
        
        //initialization
        kbd=new Scanner(System.in);
        
        System.out.println("Type F for Fahrenheit and C for Celsius!");
        
        System.out.print("Convert from (enter type) ");
        typeFrom=kbd.nextLine().charAt(0);
        if(typeFrom != 'F' && typeFrom != 'C')
        {
            System.out.println("Wrong input!");
            return;
        }
        
        
        System.out.print("Enter temperature: ");
        userInput=kbd.nextDouble();
        
        //processing
        
        //output 
        if(typeFrom=='F')
        {
            System.out.printf("Converted temperature is: %.2f%n",convertToCelsius(userInput));
        }
        else
        {
           System.out.printf("Converted temperature is: %.2f%n",convertToFahrenheit(userInput)); 
        }
    }
    
}
