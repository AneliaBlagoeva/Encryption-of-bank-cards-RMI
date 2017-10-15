/// LargeSmall.java
// Calculates the largest and smallest
// of five integers entered one at a time.
package zad1;
// Java core packages

import java.awt.*;

// Java extension packages
import javax.swing.*;

public class LargeSmall {

    // Compute the smallest and the largest among 4 input numbers
    // obtain numerical input and determine results
    public static void main(String[] args) {
        String dataString;   // output string
        String smallString;  // smallest number string
        String largeString;  // largest number string
        String input;     // string entered by user
        int largest, smallest; // largest and smallest integers

        // variables to store integers input by user
        int firstNumber, secondNumber, thirdNumber,
                fourthNumber, fifthNumber;

        // obtain first value
        input = JOptionPane.showInputDialog("Enter first number :");
        firstNumber = Integer.parseInt(input);

        /* Read second number from user and assign it to variable secondNumber */
        input = JOptionPane.showInputDialog("Enter second number :");
        secondNumber = Integer.parseInt(input);

        /* Compare variables smallest and largest 
        with the input and set them appropriately */
        if (firstNumber < secondNumber) {
            smallest = firstNumber;
            largest = secondNumber;
        } else {
            smallest = secondNumber;
            largest = firstNumber;
        }

        /* Perform the same steps with the
        third, fourth and fifth values */
        input = JOptionPane.showInputDialog("Enter third number :");
        thirdNumber = Integer.parseInt(input);

        if (thirdNumber < smallest) {
            smallest = thirdNumber;
        } else {
            if (thirdNumber > largest) {
                largest = thirdNumber;
            }
        }
        //fourth
        input = JOptionPane.showInputDialog("Enter fourth number :");
        fourthNumber = Integer.parseInt(input);

        if (fourthNumber > largest) {
            largest = fourthNumber;
        } else {
            if (fourthNumber < smallest) {
                smallest = fourthNumber;
            }
        }

        //fifth
        input = JOptionPane.showInputDialog("Enter fifth number :");
        fifthNumber = Integer.parseInt(input);

        if (fifthNumber < smallest) {
            smallest = fifthNumber;
        } else {
            if (fifthNumber > largest) {
                largest = fifthNumber;
            }
        }

        /* Create a formatted output String  with the obtained  
         smallest and largest input numbers*/
        String result = String.format("The smallest number is: %d%nThe largest number is: %d%n",
                smallest, largest);

        /* Output the formatted output String  using a dialog box */
        JOptionPane.showMessageDialog(null, result);
        // end method main
    }
}// end class LargeSmall

