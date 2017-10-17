package zad2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class ComputeSin {

    private double x;

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public double getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(double x) {
        this.x = x;
    }

    private static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    double computeSin(double x) {

        //declaration
        double result;
        int iter;//stores next odd number
        double curr,//stores current element
                previous;//stores previous element
        //initialization
        result = 0.0;
        iter = 1;
        curr = Math.pow(x, iter) / fact(iter);

        //processing
        do {
            result = result + curr;
            previous = curr;
            iter = iter + 2;
            curr = Math.pow(x, iter) / fact(iter);

            result = result - curr;
            previous = curr;
            iter = iter + 2;
            curr = Math.pow(x, iter) / fact(iter);
        } while ((curr - previous > 0) && (curr - previous < 1));

        //output
        return result;
    }
}
