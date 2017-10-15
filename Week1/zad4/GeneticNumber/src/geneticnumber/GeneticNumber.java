/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticnumber;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class GeneticNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //declaration
        Scanner kbd;//keyboard
        int userInput, //number that enter the user
                inputCpy;  //copy of user input
        StringBuilder convertedInput; //save user input into 3-based number
        StringBuilder result; //variable for denoted string
        
        //initialization  
        kbd = new Scanner(System.in);

        System.out.print("Enter number: ");
        userInput = kbd.nextInt();
        inputCpy = userInput;
        convertedInput = new StringBuilder();
        result=new StringBuilder();

        //processing
        while (inputCpy != 0) //convert to 4 - based counting system {0,1,2,3}
        {
            int digit = inputCpy % 4;
            convertedInput.append(digit);
            inputCpy = inputCpy / 4;
        }

        convertedInput = convertedInput.reverse();

        for (int i = 0; i < convertedInput.length(); i++) {
            char currChar = convertedInput.charAt(i);

            switch (currChar) {
                case '0':
                    result.append('A');
                    break;
                case '1':
                    result.append('C');
                    break;
                case '2':
                    result.append('G');
                    break;
                case '3':
                    result.append('T');
                    break;
                default:
                    System.out.println("Error! ");
                    break;
            }

        }
        
        //output
        System.out.printf("The number %d is doneted as: %s%n",
                userInput, result);
    }
}
