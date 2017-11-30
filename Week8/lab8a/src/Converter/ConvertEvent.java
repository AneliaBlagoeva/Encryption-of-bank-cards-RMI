/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

/**
 *
 * @author Haemimont
 */
public class ConvertEvent {

    private double value;

    /**
     * Get the value of value
     *
     * @return the value of value
     */
    public double getValue() {
        return value;
    }

    /**
     * Set the value of value
     *
     * @param value new value of value
     */
    public void setValue(double value) {
        if (value < 0) {
            this.value = 0;
        } else {
            this.value = value;
        }
    }

    public ConvertEvent(double value) {
        setValue(value);
    }
    
    

}
