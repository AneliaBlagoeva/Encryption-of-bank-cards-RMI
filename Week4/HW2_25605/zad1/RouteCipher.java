/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

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
        this.key = key;
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

    private char[] leftTopCornerEncrypt(char[][] charMatrix, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

        //declaration and initialization
        char[] result = new char[rows * cols];
        int resultIter = 0;

        //processing
        while (leftCol <= rightCol && topRow <= bottomRow) {
            //print left column
            if (resultIter < (rows * cols)) {
                for (int i = topRow; i <= bottomRow; i++) {
                    result[resultIter] = charMatrix[i][leftCol];
                    resultIter++;
                }
                leftCol++;
            }

            //print bottom row
            if (resultIter < (rows * cols)) {
                for (int i = leftCol; i <= rightCol; i++) {
                    result[resultIter] = charMatrix[bottomRow][i];
                    resultIter++;
                }
                bottomRow--;
            }

            //print right col
            if (resultIter < (rows * cols)) {
                for (int i = bottomRow; i >= topRow; i--) {
                    result[resultIter] = charMatrix[i][rightCol];
                    resultIter++;
                }
                rightCol--;
            }

            //print first row
            if (resultIter < (rows * cols)) {
                for (int i = rightCol; i >= leftCol; i--) {
                    result[resultIter] = charMatrix[topRow][i];
                    resultIter++;
                }
                topRow++;
            }
        }

        return result;
    }

    private char[] rightDownCornerEncrypt(char[][] charMatrix, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

        //declaration and initialization
        char[] result = new char[rows * cols];
        int resultIter = 0;

        //processing
        while (leftCol <= rightCol && topRow <= bottomRow) {
            //print right col
            if (resultIter < (rows * cols)) {
                for (int i = bottomRow; i >= topRow; i--) {
                    result[resultIter] = charMatrix[i][rightCol];
                    resultIter++;
                }
                rightCol--;
            }

            //print first row
            if (resultIter < (rows * cols)) {
                for (int i = rightCol; i >= leftCol; i--) {
                    result[resultIter] = charMatrix[topRow][i];
                    resultIter++;
                }
                topRow++;
            }

            //print left column
            if (resultIter < (rows * cols)) {
                for (int i = topRow; i <= bottomRow; i++) {
                    result[resultIter] = charMatrix[i][leftCol];
                    resultIter++;
                }
                leftCol++;
            }

            //print bottom row
            if (resultIter < (rows * cols)) {
                for (int i = leftCol; i <= rightCol; i++) {
                    result[resultIter] = charMatrix[bottomRow][i];
                    resultIter++;
                }
                bottomRow--;
            }
        }

        return result;
    }
    
    private char[][] leftTopCornerDecrypt(char[] result, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

        //declaration and initialization
        int resultIter = 0;
        char[][] charMatrix = new char[rows][cols];

        //processing
        while (leftCol <= rightCol && topRow <= bottomRow) {
            //print left column
            if (resultIter < (rows * cols)) {
                for (int i = topRow; i <= bottomRow; i++) {
                    charMatrix[i][leftCol] = result[resultIter];
                    resultIter++;
                }
                leftCol++;
            }

            //print bottom row
            if (resultIter < (rows * cols)) {
                for (int i = leftCol; i <= rightCol; i++) {
                    charMatrix[bottomRow][i] = result[resultIter];
                    resultIter++;
                }
                bottomRow--;
            }

            //print right col
            if (resultIter < (rows * cols)) {
                for (int i = bottomRow; i >= topRow; i--) {
                    charMatrix[i][rightCol] = result[resultIter];
                    resultIter++;
                }
                rightCol--;
            }

            //print first row
            if (resultIter < (rows * cols)) {
                for (int i = rightCol; i >= leftCol; i--) {
                    charMatrix[topRow][i] = result[resultIter];
                    resultIter++;
                }
                topRow++;
            }
        }

        return charMatrix;
    }

    private char[][] rightDownCornerDecrypt(char[] result, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

        //declaration and initialization
        int resultIter = 0;
        char[][] charMatrix = new char[rows][cols];

        //processing
        while (leftCol <= rightCol && topRow <= bottomRow) {
            //print right col
            if (resultIter < (rows * cols)) {
                for (int i = bottomRow; i >= topRow; i--) {
                    charMatrix[i][rightCol] = result[resultIter];
                    resultIter++;
                }
                rightCol--;
            }

            //print first row
            if (resultIter < (rows * cols)) {
                for (int i = rightCol; i >= leftCol; i--) {
                    charMatrix[topRow][i] = result[resultIter];
                    resultIter++;
                }
                topRow++;
            }

            //print left column
            if (resultIter < (rows * cols)) {
                for (int i = topRow; i <= bottomRow; i++) {
                    charMatrix[i][leftCol] = result[resultIter];
                    resultIter++;
                }
                leftCol++;
            }

            //print bottom row
            if (resultIter < (rows * cols)) {
                for (int i = leftCol; i <= rightCol; i++) {
                    charMatrix[bottomRow][i] = result[resultIter];
                    resultIter++;
                }
                bottomRow--;
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
            result = leftTopCornerEncrypt(charMatrix, 0, (rows - 1), (cols - 1), 0, rows, cols);
        } else {
            result = rightDownCornerEncrypt(charMatrix, 0, (rows - 1), (cols - 1), 0, rows, cols);
        }

        //output
        System.out.println(result);
        return new String(result);

    }

    private char[] turnMatrixToArray(char[][] charMatrix, int rows, int cols) {

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

        return result;
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

        result = turnMatrixToArray(charMatrix, rows, cols);

        //output
        System.out.println(result);
        return new String(result);
    }

    @Override
    public String toString() {
        return String.format("SimpleTransposition code %d", key);
    }
}
