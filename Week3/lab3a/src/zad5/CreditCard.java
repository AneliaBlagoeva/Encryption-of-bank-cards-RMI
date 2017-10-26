package zad5;

public class CreditCard {

    private long number;

    public long getNumber() {
        return number;
    }

    public void setNumber(long input) {
        if (getSize(input) > 13 || getSize(input) < 16) {
            this.number = input;
        } else {
            this.number = 0;
        }
    }

    public CreditCard(long userInput) {
        setNumber(userInput);
    }

/** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        //declaration
        int sum;
        int digit, doubleDigit;
        int size;

        //initialization;
        size = getSize(number);//size of number
        sum = 0;

        //processing
        for (int i = 0; i < size; i += 2) {
            number = number / 10;
            digit = (int) (number % 10);
            number = number / 10;
            doubleDigit = 2 * digit;

            if (doubleDigit >= 10) {
                doubleDigit = getDigit(doubleDigit);
            }

            sum += doubleDigit;
        }

        //output
        return sum;

    }

/** Return this number if it is a single digit, otherwise,
/* return the sum of the two digits */
    public static int getDigit(int number) {
        //declaration
        int firstDigit, secondDigit;

        //initialization
        firstDigit = number % 10;
        secondDigit = number / 10;

        return firstDigit + secondDigit;

    }

/** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        //declaration
        int sum;
        int size;
        int digit;

        //initialization;
        size = getSize(number);//size of number
        sum = 0;
        //processing

        for (int i = 0; i < size; i += 2) {
            digit = (int) (number % 10);
            number = number / 100;
            sum += digit;
        }

        //output
        return sum;
    }

/** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {

        if (getPrefix(number, 1) == d) {
            return true;
        } else {
            return false;
        }
    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
        //declaration
        long resultFromDivision;
        int cnt;

        //initialization
        cnt = 1;
        resultFromDivision = (long) (d / 10);

        //processing
        while (resultFromDivision != 0) {
            resultFromDivision = resultFromDivision / 10;
            cnt++;
        }

        return cnt;
    }

    /** Return the first k number of digits from number. If the
* number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) {
        //declaration
        long resultFromDevision;
        int digit;
        StringBuilder result = new StringBuilder();
        int sizeOfNumber;

        //initialization
        sizeOfNumber = getSize(number);
        digit = (int) (number / Math.pow(10, sizeOfNumber));

        //processing
        result.append(digit);
        sizeOfNumber--;

        if (getSize(number) < k) {
            resultFromDevision = number;
        } else {
            for (int i = 1; i <= k; i++) {
                digit = (int) ((number / Math.pow(10, sizeOfNumber)) % 10);
                sizeOfNumber--;
                result.append(digit);
            }

            resultFromDevision = Long.parseLong(result.toString());
        }

        //processing
        return resultFromDevision;
    }

    /**
     * Return true if the card number is valid
     */
    public static boolean isValid(long number) {
        if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

