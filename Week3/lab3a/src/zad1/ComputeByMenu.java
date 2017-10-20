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
public class ComputeByMenu {

    private double x;
    private Scanner kbd;
    private int userChoice;

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
        kbd = new Scanner(System.in);
        this.x = x;
    }

    public ComputeByMenu(double x) {

        setX(x);
    }

    public ComputeByMenu() {
    }

    public void getUserChoice() {
        while(true){
        displayMenu();
        System.out.println("Select a menu option: ");
        do {
            userChoice = kbd.nextInt();
        } while (userChoice < 1 || userChoice >= 6);
        doSelection(userChoice);
        }
    }

    public void displayMenu() {
        for (int i = 0; i < 60; i++) {
            System.out.println("    ");
        }
            System.out.println("1. Въведи число x  в плаваща запетая\n");
            System.out.println("2. Пресметни  и изведи exp(x)\n");
            System.out.println("3. Пресметни и изведи sin(x0\n");
            System.out.println("4. Пресметни и изведи floor(x)\n");
            System.out.println("5. Край");
        
    }

    private void pressAnyKey() {
        System.out.println(" Press any key to continue");
        kbd.nextLine();//read return entry
        kbd.nextLine();
    }

    private void inputX() {
        System.out.print("Enter x: ");//issue prompt text
        x = kbd.nextDouble();//enter new value for x
        pressAnyKey();//ask user to continue
    }

    private void computeExp() {
        double result = Math.exp(x);
        System.out.printf("Exp(%.4f)=%.4f %n",x,result);//issue prompt text
        pressAnyKey();//ask user to continue
    }

    private void computeSin() {
        double result = Math.sin(x);
        System.out.printf("sin(%.4f)=%.4f %n",x,result);//issue prompt text
        pressAnyKey();//ask user to continue
    }

    private void computeFloor() {
        double result = Math.floor(x);
        System.out.printf("floor(%.4f)=%.4f %n",x,result);//issue prompt text
        pressAnyKey();//ask user to continue
    }

    public void doSelection(int choice) {

        switch (choice) {
            case 1:
                inputX();
                break;
            case 2:
                computeExp();
                break;
            case 3:
                computeSin();
                break;
            case 4:
                computeFloor();
                break;
            case 5:
                System.exit(0);
        }
        displayMenu();
    }

}
