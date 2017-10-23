/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import javax.swing.JOptionPane;

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
        
        Celsius celsius;
        double fahrenheitTemperature;
        double inputCelsius;
        String input;

        //initialization
        celsius=new Celsius();
        input = JOptionPane.showInputDialog("Enter temperature in celsius: ");
        inputCelsius=Double.parseDouble(input);
        
        celsius.setCelsius(inputCelsius);

        //processing
        fahrenheitTemperature = celsius.convertToFahrenheit();
        JOptionPane.showMessageDialog(null, "Celsius temperature: " +  inputCelsius+ " in Fahrenheit: " + fahrenheitTemperature);
        
        //now the same for fahrenheit
        
        //declaration
        double celsiusTemperature;
        Fahrenheit fh;
        double inputFahrenheit;

        //initialization
        
        input = JOptionPane.showInputDialog("Enter temperature in Fahrenheit: ");
        inputFahrenheit=Double.parseDouble(input);
        
        fh=new Fahrenheit(inputFahrenheit);

        //processing
        celsiusTemperature = fh.convertToCelsius(inputFahrenheit);
        JOptionPane.showMessageDialog(null, "Fahrenheit temperature: " +  inputFahrenheit+ " in Celsius: " + celsiusTemperature);
    }

}
