/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2_25605;

import com.sun.scenario.animation.SplineInterpolator;

public class RouteCipher {

    private int key;

    /**
     * Get the value of key
     *
     * @return the value of key
     */
    public int getKey() {
        return key;
    }

    /**
     * Set the value of key
     *
     * @param key new value of key
     */
    public void setKey(int key) {
        if (key != 0) {
            this.key = key;
        } else {
            System.out.println("The key cannot be 0!");
            return;
        }

    }

    public RouteCipher(int key) {
        setKey(key);
    }

    //return string only with letters from user input string
    private String removeSpecialCharacters(String plainText) {
        //DECLARATION
        char[] plainTextLetters; //safe only letters from plain text
        char[] plainTextChars = plainText.toCharArray();

        //INITIALIZATION 
        plainTextLetters = new char[plainTextChars.length];
        int iter = 0;//counT of LETTERS from plain text

        //initialize plainTextLetters only with letters from plain text
        //processing
        for (int i = 0; i < plainTextChars.length; i++) {
            if ((plainTextChars[i] >= 65 && plainTextChars[i] <= 90)
                    || (plainTextChars[i] >= 97 && plainTextChars[i] <= 122)) {
                plainTextLetters[iter] = plainTextChars[i];
                iter++;
            }
        }

        char[] result = new char[iter];
        System.arraycopy(plainTextLetters, 0, result, 0, iter);
        //output
        return new String(result);
    }

    /**
     * method that calculates number of rows from number of column and length of
     * given char[] for generating a matrix
     */
    private int getRowsCount(int iter) {
        int rows;

        if ((iter % Math.abs(key)) == 0) {
            rows = (iter / Math.abs(key));
        } else {
            rows = ((iter / Math.abs(key)) + 1);
        }

        return rows;
    }

    //make matrix from letters
    private char[][] makeMatrix(String plainText) {
        //declaration
        int rows; //how much rows will we need
        char[][] charMatrix;//matrix from letters from the plaintext
        char[] plainTextLetters;//array only from letters
        int iter;//safe length of array from letters

        //initialization
        plainTextLetters = removeSpecialCharacters(plainText).toCharArray();
        iter = plainTextLetters.length;
        rows = getRowsCount(iter);

        //initialize matrix from letters
        charMatrix = new char[rows][Math.abs(key)];

        //PROCESSING
        //make matrix
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < Math.abs(key); col++) {
                if ((row * Math.abs(key) + col) < iter) {
                    charMatrix[row][col] = plainTextLetters[row * Math.abs(key) + col];
                } else {
                    charMatrix[row][col] = 'X';
                }
            }
        }

        //OUTPUT
        return charMatrix;
    }

    private String leftTopCornerEncrypt(char[][] charMatrix, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

        //declaration and initialization
        SpiralEncryption s = new SpiralEncryption(charMatrix, leftCol, bottomRow, rightCol, topRow, rows, cols);
        char[] result = new char[rows * cols];

        //processing
        while (s.getLeftCol() <= s.getRightCol() && s.getTopRow() <= s.getBottomRow()) {
            //print left column
            if (s.getResultIter() < (rows * cols)) {
                s.leftColumnEncrypt(result);
            }

            //print bottom row
            if (s.getResultIter() < (rows * cols)) {
                s.bottomRowEncrypt(result);
            }

            //print right col
            if (s.getResultIter() < (rows * cols)) {
                s.rightColumnEncrypt(result);
            }

            //print first row
            if (s.getResultIter() < (rows * cols)) {
                s.topRowEncrypt(result);
            }
        }

        return new String(result);
    }

    private String rightDownCornerEncrypt(char[][] charMatrix, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {
        //declaration and initialization
        SpiralEncryption s = new SpiralEncryption(charMatrix, leftCol, bottomRow, rightCol, topRow, rows, cols);
        char[] result = new char[rows * cols];

        //processing
        while (s.getLeftCol() <= s.getRightCol() && s.getTopRow() <= s.getBottomRow()) {
            //print right col
            if (s.getResultIter() < (rows * cols)) {
                s.rightColumnEncrypt(result);
            }

            //print first row
            if (s.getResultIter() < (rows * cols)) {
                s.topRowEncrypt(result);
            }

            //print left column
            if (s.getResultIter() < (rows * cols)) {
                s.leftColumnEncrypt(result);
            }

            //print bottom row
            if (s.getResultIter() < (rows * cols)) {
                s.bottomRowEncrypt(result);
            }

        }

        return new String(result);

    }

    private char[][] leftTopCornerDecrypt(char[] result, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {
        char[][] charMatrix = new char[rows][cols];
        SpiralDecryption s = new SpiralDecryption(result, leftCol, bottomRow, rightCol, topRow, rows, cols);
        //processing
        while (s.getResultIter() < result.length) {
            //print left column
            if (s.getResultIter() < result.length) {
                s.leftColumnDecrypt(charMatrix);
            }

            //print bottom row
            if (s.getResultIter() < result.length) {
                s.bottomRowDecrypt(charMatrix);
            }

            //print right col
            if (s.getResultIter() < result.length) {
                s.rightColumnDecrypt(charMatrix);
            }

            //print first row
            if (s.getResultIter() < result.length) {
                s.topRowDecrypt(charMatrix);
            }
        }

        return charMatrix;
    }

    private char[][] rightDownCornerDecrypt(char[] result, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

        char[][] charMatrix = new char[rows][cols];
        SpiralDecryption s = new SpiralDecryption(result, leftCol, bottomRow, rightCol, topRow, rows, cols);
        //processing
        while (s.getResultIter() < result.length) {

            //print right col
            if (s.getResultIter() < result.length) {
                s.rightColumnDecrypt(charMatrix);
            }

            //print first row
            if (s.getResultIter() < result.length) {
                s.topRowDecrypt(charMatrix);
            }

            //print left column
            if (s.getResultIter() < result.length) {
                s.leftColumnDecrypt(charMatrix);
            }

            //print bottom row
            if (s.getResultIter() < result.length) {
                s.bottomRowDecrypt(charMatrix);
            }
        }

        return charMatrix;
    }

    public String encrypt(String plainText) {
        //DECLARATION & INITIALIZATION
        char[][] charMatrix = makeMatrix(plainText);
        int rows = charMatrix.length;
        int cols = Math.abs(key);
        char[] result;

        //processing
        if (key > 0) {
            result = leftTopCornerEncrypt(charMatrix, 0, (rows - 1), (cols - 1), 0, rows, cols).toCharArray();
        } else {
            result = rightDownCornerEncrypt(charMatrix, 0, (rows - 1), (cols - 1), 0, rows, cols).toCharArray();
        }

        //output
        System.out.println(result);
        return new String(result);

    }

    private String turnMatrixToString(char[][] charMatrix, int rows, int cols) {

        int iter = 0;//counT of LETTERS from plain text
        char[] result = new char[rows * cols];

        //turn matrix into 1d arr
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (charMatrix[row][col] == 'X') {
                    break;
                }

                result[iter] = charMatrix[row][col];
                iter++;
            }
        }

        return new String(result);
    }

    public String decrypt(String ciphertext) {
        //DECLARATION
        char[] plainTextChars; //safe all characters from plain text
        char[][] charMatrix;//matrix from letters from the plaintext
        char[] result;

        //INITIALIZATION 
        plainTextChars = ciphertext.toCharArray();
        int rows = plainTextChars.length / (Math.abs(key));
        int cols = Math.abs(key);

        //initialize matrix 
        if (key > 0) {
            charMatrix = leftTopCornerDecrypt(plainTextChars, 0, rows - 1, cols - 1, 0, rows, cols);
        } else {
            charMatrix = rightDownCornerDecrypt(plainTextChars, 0, rows - 1, cols - 1, 0, rows, cols);
        }

        result = turnMatrixToString(charMatrix, rows, cols).toCharArray();

        //output
        System.out.println(result);
        return new String(result);
    }

    @Override
    public String toString() {
        return String.format("SimpleTransposition code %d", key);
    }
}
