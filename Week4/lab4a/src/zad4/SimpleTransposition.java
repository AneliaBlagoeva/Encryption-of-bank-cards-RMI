/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

public class SimpleTransposition {

    private int cipherCode;

    public SimpleTransposition(String cipherCode) {
        setCipherCode(cipherCode.length());
    }

    public int getCipherCode() {
        return cipherCode;
    }

    public void setCipherCode(int cipherCode) {
        if (cipherCode > 1) {
            this.cipherCode = cipherCode;
        } else {
            this.cipherCode = 3;
        }
    }

    public String encrypt(String plainText) {
        char[] plainTextChars = plainText.toCharArray();
        int cols = cipherCode;
        int rows = (int) Math.ceil((double) plainTextChars.length / cols);
        char[] cipherTextChars = new char[rows * cols];

        char[][] grid = new char[rows][cols];

        int currentChar = 0;
        // write by rows
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (currentChar < plainTextChars.length) {
                    grid[i][j] = plainTextChars[currentChar++];
                } else {
                    grid[i][j] = ' ';
                }
            }
        }

        currentChar = 0;
        for (int i = 0; i < cols; i++) {
            for (int q = 0; q < rows; q++) {
                cipherTextChars[currentChar++] = grid[q][i];
            }
        }

        return new String(cipherTextChars);
    }

    public String decrypt(String cipherText) {
        char[] cipherTextChars = cipherText.toCharArray();
        int cols = cipherCode;
        int rows = (int) Math.ceil((double) cipherTextChars.length / cols);
        char[] plainTextChars = new char[rows * cols];
        char[][] grid = new char[rows][cols];
        int currentChar = 0;
        for (int i = 0; i < cols; i++) {
            for (int q = 0; q < rows; q++) {
                if (currentChar < cipherTextChars.length) {
                    grid[q][i] = cipherTextChars[currentChar++];
                } else {
                    grid[q][i] = ' ';
                }
            }
        }
        currentChar = 0;
        // read by rows
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (currentChar < plainTextChars.length) {
                    plainTextChars[currentChar++] = grid[i][j];
                }
            }
        }
        return new String(plainTextChars);
    }

    @Override
    public String toString() {
        return String.format("SimpleTransposition code %d", cipherCode);
    }
}
