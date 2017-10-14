package CelsiusaAndFahrenheit;

import java.util.HashSet;
import java.util.Set;

public class Celsius {

    private double celsius;

    /**
     * Get the value of celsius
     *
     * @return the value of celsius
     */
    public double getCelsius() {
        return celsius;
    }

    /**
     * Set the value of celsius
     *
     * @param celsius new value of celsius
     */
    public void setCelsius(double celsius) {

        if (celsius > -277) {
            this.celsius = celsius;
        } else {
            this.celsius = 0;
        }
    }

    public Celsius() {
    }

    public Celsius(double celsius) {
        setCelsius(celsius);
    }

    double convertToFahrenheit() {
        double fahrenheit;
        fahrenheit = 9.0 / 5.0 * celsius + 32;
        return fahrenheit;
    }
}
