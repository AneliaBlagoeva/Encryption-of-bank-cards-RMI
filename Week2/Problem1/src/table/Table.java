/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Table {

    private double begin;//
    private double end;
    private int step;

    /**
     * Get the value of begin
     *
     * @return the value of begin
     */
    public double getBegin() {
        return begin;
    }

    /**
     * Set the value of begin
     *
     * @param begin new value of begin
     */
    public void setBegin(double begin) {
        this.begin = begin;
    }

    /**
     * Get the value of end
     *
     * @return the value of end
     */
    public double getEnd() {
        return end;
    }

    /**
     * Set the value of end
     *
     * @param end new value of end
     */
    public void setEnd(double end) {
        this.end = end;
    }

    /**
     * Get the value of step
     *
     * @return the value of step
     */
    public int getStep() {
        return step;
    }

    /**
     * Set the value of step
     *
     * @param step new value of step
     */
    public void setStep(int step) {

        if (step != 0) {
            this.step = step;
        } else {
            this.step = 1;
        }
    }

    public Table(double begin, double end, int step) {
        setBegin(begin);
        setStep(step);
        setEnd(end);
    }

    public void makeTable() {

        //declaration
        double delta;
        double x;
        double function;
        Scanner kbd;
        int counter;

        //initialization
        delta = (end - begin) / step;
        x = begin;
        kbd = new Scanner(System.in);
        counter = 1;

        //processing
        System.out.printf("%8s%20s%n", "X", "F(X)");

        while (x <= end) {
            function = (x - 2) * (x - 2) / (x * x + 1);

            System.out.printf("%8.2f%20.2f%n", x, function);

            x = x + delta;

            if (counter % 20 == 0) {
                System.out.println("Press Return to continue");
                kbd.nextLine();
            }

            counter++;
        }
        //output

    }

}
