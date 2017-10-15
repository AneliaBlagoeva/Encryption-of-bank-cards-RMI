/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class TestConvert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //declaration
        Scanner kbd;
        double celsiusTemperature;
        Celsius celsius;
        double fahrenheitTemperature;

        //initialization
        kbd = new Scanner(System.in);
        System.out.print("Enter celsius temp: ");
        celsiusTemperature = kbd.nextDouble();

        celsius = new Celsius(celsiusTemperature);

        //processing
        fahrenheitTemperature = celsius.convertToFahrenheit();

        //output
        System.out.printf("Celsius temperature: %.2f in Fahrenheit: %.2f%n",
                celsiusTemperature, fahrenheitTemperature);
    }

}
