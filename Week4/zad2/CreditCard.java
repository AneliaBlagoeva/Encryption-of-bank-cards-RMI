/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

public class CreditCard {

    private char[] number;

    public String getNumber() {
        return new String(number);
    }

    public void setNumber(String input) {
        char[] numberChars = input.toCharArray();
        number = new char[numberChars.length];

        if (numberChars.length > 13 || numberChars.length < 16) {
            for (int i = 0; i < numberChars.length; i++) {
                number[i] = numberChars[i];
            }
        } else {
            for (int i = 0; i < numberChars.length; i++) {
                number[i] = new Character(' ');
            }
        }
    }

    public CreditCard(String userInput) {
        setNumber(userInput);
    }

    /**
     * Get the result from Step 2
     */
    public int sumOfDoubleEvenPlace() {
        //declaration
        int sum;
        int digit, doubleDigit;
        int size;

        //initialization;
        size = number.length;//size of number
        sum = 0;

        //processing
        for (int i = 0; i < size; i += 2) {
            digit = Character.getNumericValue(number[i]);
            doubleDigit = 2 * digit;

            if (doubleDigit >= 10) {
                doubleDigit = getDigit(doubleDigit);
            }

            sum += doubleDigit;
        }

        //output
        return new Integer(sum);

    }

    /**
     * Return this number if it is a single digit, otherwise, /* return the sum
     * of the two digits
     */
    public int getDigit(int number) {
        //declaration
        int firstDigit, secondDigit;

        //initialization
        firstDigit = number % 10;
        secondDigit = number / 10;

        return new Integer(firstDigit + secondDigit);

    }

    /**
     * Return sum of odd-place digits in number
     */
    public int sumOfOddPlace() {
        //declaration
        int sum;
        int size;
        int digit;

        //initialization;
        size = number.length;//size of number
        sum = 0;
        //processing

        for (int i = 1; i < size; i += 2) {
            digit = Character.getNumericValue(number[i]);
            sum += digit;
        }

        //output
        return new Integer(sum);
    }

    public boolean isValid() {
        if ((sumOfDoubleEvenPlace() + sumOfOddPlace()) % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
