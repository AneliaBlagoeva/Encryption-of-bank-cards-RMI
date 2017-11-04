/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2_25605;

/**
 *
 * @author user
 */
public class SpiralEncryption {

    private char[][] charMatrix;
    int rows;
    int cols;

    private int leftCol;

    public int getLeftCol() {
        return leftCol;
    }

    private int bottomRow;

    public int getBottomRow() {
        return bottomRow;
    }

    private int rightCol;

    public int getRightCol() {
        return rightCol;
    }

    private int topRow;

    public int getTopRow() {
        return topRow;
    }

    int resultIter;

    public int getResultIter() {
        return resultIter;
    }

    public SpiralEncryption(char[][] charMatrix, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {
        this.charMatrix = charMatrix;
        this.leftCol = leftCol;
        this.bottomRow = bottomRow;
        this.rightCol = rightCol;
        this.topRow = topRow;
        this.rows = rows;
        this.cols = cols;
        int resultIter=0;
    }

    //encrypt left column
    public void leftColumnEncrypt(char[] result) {

        for (int i = topRow; i <= bottomRow; i++) {
            result[resultIter] = charMatrix[i][leftCol];
            resultIter++;
        }
        leftCol++;
    }

    //encrypt bottom row 
    public void bottomRowEncrypt(char[] result) {

        for (int i = leftCol; i <= rightCol; i++) {
            result[resultIter] = charMatrix[bottomRow][i];
            resultIter++;
        }
        bottomRow--;
    }

//encrypt right column 
    public void rightColumnEncrypt(char[] result) {
        for (int i = bottomRow; i >= topRow; i--) {
            result[resultIter] = charMatrix[i][rightCol];
            resultIter++;
        }
        rightCol--;
    }

    //encrypt top row 
    public void topRowEncrypt(char[] result) {
        for (int i = rightCol; i >= leftCol; i--) {
            result[resultIter] = charMatrix[topRow][i];
            resultIter++;
        }
        topRow++;
    }

}
