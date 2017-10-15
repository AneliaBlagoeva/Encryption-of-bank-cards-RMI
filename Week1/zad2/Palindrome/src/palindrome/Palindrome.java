/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //declaration
        int userInput,//number that is entered by user
                originalNumber;//copy of user input

        int digit1,//stores right first digit
                digit2,
                digit3,
                digit4,
                digit5;

        Scanner kbd;

        String resultString;//indicate whether userInput is palidrome

        //initialization
        kbd = new Scanner(System.in);

        System.out.print("Enter five digit number: ");
        userInput = kbd.nextInt();
        if (userInput < 10000 || userInput > 99999) {
            System.out.println("Wrong input! Number have to be 5 digit integer!");
            return;
        }

        originalNumber = userInput;

        //processing
        digit1 = userInput % 10;
        digit2 = (userInput / 10) % 10;
        digit3 = (userInput / 100) % 10;
        digit4 = (userInput / 1000) % 10;
        digit5 = userInput / 10000;

        if (digit1 == digit5 && digit2 == digit4) {
            resultString = "Number is palindrome!";
        } else {
            resultString = "Number is not palindomre!";
        }
        //output
        System.out.println(resultString);
    }

}
