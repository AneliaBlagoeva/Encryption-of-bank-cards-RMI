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
public class SpiralDecryption {

    private char[] result;
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

    private int resultIter;

    public int getResultIter() {
        return resultIter;
    }

    public SpiralDecryption(char[] result, int leftCol, int bottomRow, int rightCol, int topRow, int rows, int cols) {
        this.result = result;
        this.leftCol = leftCol;
        this.bottomRow = bottomRow;
        this.rightCol = rightCol;
        this.topRow = topRow;
        this.rows = rows;
        this.cols = cols;
        this.resultIter = 0;
    }

    //decrypt left column
    public void leftColumnDecrypt(char[][] charMatrix) {

        for (int i = topRow; i <= bottomRow; i++) {
            charMatrix[i][leftCol] = result[resultIter];
            resultIter++;
        }
        leftCol++;
    }

    //decrypt bottom row 
    public void bottomRowDecrypt(char[][] charMatrix) {
        for (int i = leftCol; i <= rightCol; i++) {
            charMatrix[bottomRow][i] = result[resultIter];
            resultIter++;
        }
        bottomRow--;
    }

    //decrypt right column 
    public void rightColumnDecrypt(char[][] charMatrix) {
        for (int i = bottomRow; i >= topRow; i--) {
            charMatrix[i][rightCol] = result[resultIter];
            resultIter++;
        }
        rightCol--;
    }

    //encrypt top row 
    public void topRowDecrypt(char[][] charMatrix) {
        for (int i = rightCol; i >= leftCol; i--) {
            charMatrix[topRow][i] = result[resultIter];
            resultIter++;
        }
        topRow++;
    }

}
