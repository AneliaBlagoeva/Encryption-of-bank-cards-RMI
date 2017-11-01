/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author Haemimont
 */
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

    private char[][] makeMatrix(String plainText) {
        //DECLARATION
        char[] plainTextChars; //safe all charakters from plain text
        char[] plainTextLetters; //safe only letters from plain text
        int rows; //how much rows will we need
        char[][] charMatrix;//matrix from letters from the plaintext
        int iter = 0;//counT of LETTERS from plain text

        //INITIALIZATION 
        plainTextChars = plainText.toCharArray();
        plainTextLetters = new char[plainTextChars.length];

        //initialize plainTextLetters only with letters from plain text
        for (int i = 0; i < plainTextChars.length; i++) {
            if ((plainTextChars[i] >= 65 && plainTextChars[i] <= 90)
                    || (plainTextChars[i] >= 97 && plainTextChars[i] <= 122)) {
                plainTextLetters[iter] = plainTextChars[i];
                iter++;
            }
        }

        //calculate number of rows
        if ((iter % Math.abs(key)) == 0) {
            rows = (iter / Math.abs(key));
        } else {
            rows = ((iter / Math.abs(key)) + 1);
        }

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

    private char[] leftTopCornerIteration(char[][] charMatrix, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

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

    private char[][] leftTopCornerIterationDecrypt(char[] result, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

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

    private char[][] rightDownCornerIterationDecrypt(char[] result, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

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

    private char[] rightDownCornerIteration(char[][] charMatrix, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {

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

    String encrypt(String plainText) {
        //DECLARATION & INITIALIZATION
        char[][] charMatrix = makeMatrix(plainText);
        char[] result = new char[charMatrix.length * Math.abs(key)];
        int rows = charMatrix.length;
        int cols = Math.abs(key);

        //processing
        if (key > 0) {
            result = leftTopCornerIteration(charMatrix, 0, (rows - 1), (cols - 1), 0, rows, cols);
        } else {
            result = rightDownCornerIteration(charMatrix, 0, (rows - 1), (cols - 1), 0, rows, cols);
        }

        //output
        System.out.println(result);
        return new String(result);

    }

    String decrypt(String ciphertext) {
        //DECLARATION
        char[] plainTextChars; //safe all characters from plain text
        char[][] charMatrix;//matrix from letters from the plaintext
        char[] result;
        int iter = 0;//counT of LETTERS from plain text

        //INITIALIZATION 
        plainTextChars = ciphertext.toCharArray();
        int rows = plainTextChars.length / (Math.abs(key));
        int cols = Math.abs(key);
        result=new char[rows*cols];

        //initialize matrix 
        if (key > 0) {
            charMatrix = leftTopCornerIterationDecrypt(plainTextChars, 0, rows - 1, cols - 1, 0, rows, cols);
        } else {
            charMatrix = rightDownCornerIterationDecrypt(plainTextChars, 0, rows - 1, cols - 1, 0, rows, cols);
        }
        
        //turn matrix into 1d arr
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(charMatrix[row][col]=='X'){
                    break;
                }
                
                result[iter]=charMatrix[row][col];
                iter++;
            }
        }
        
        //output
        System.out.println(result);
        return new String(result);
    }

    @Override
    public String toString() {
        return String.format("SimpleTransposition code %d", key);
    }
}
