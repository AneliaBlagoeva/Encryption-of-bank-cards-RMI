/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

/**
 *
 * @author user
 */
public class ComputeCosine {

    private double epsilon;

    /**
     * Get the value of epsilon
     *
     * @return the value of epsilon
     */
    public double getEpsilon() {
        return epsilon;
    }

    /**
     * Set the value of epsilon
     *
     * @param epsilon new value of epsilon
     */
    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public ComputeCosine(double epsilon) {
        setEpsilon(epsilon);
    }

    public double computeCos(double x) {
        //declaration
        double sum;//sum of terms
        double term;//single term
        int counter;//term sequence
        int fact;

        //initialization
        sum = 1;
        term = 1;
        counter = 1;
        fact=1;
        //processing
        do {
            fact=fact*(2*counter-1)*(2*counter);
            term =Math.pow(-1,counter)*Math.pow(x,2*counter) /(fact);
            sum += term;
            counter++;
        } while (Math.abs(term) > epsilon);

        //output
        return sum;
    }
}
