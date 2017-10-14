/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CelsiusaAndFahrenheit;

/**
 *
 * @author user
 */
public class Fahrenheit {

    private double fahrenheit;

    /**
     * Get the value of fahrenheit
     *
     * @return the value of fahrenheit
     */
    public double getFahrenheit() {
        return fahrenheit;
    }

    /**
     * Set the value of fahrenheit
     *
     * @param fahrenheit new value of fahrenheit
     */
    public void setFahrenheit(double fahrenheit) {
        if (fahrenheit > -459) {
            this.fahrenheit = fahrenheit;
        } else {
            this.fahrenheit = 0;
        }
    }

    public Fahrenheit(double fahrenheit) {
        setFahrenheit(fahrenheit);
    }
    
    double convertToCelsius(double f){
        double celsius;
        celsius = 5.0 / 9.0 * ( fahrenheit - 32 );
        return celsius;
    }

}
