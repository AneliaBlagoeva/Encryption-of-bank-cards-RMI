/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;

/**
 *
 * @author echrk
 */
public class Result {
    
    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        this.chars = chars;
        this.data = data;
    }

    /**
     * Get the value of data
     *
     * @return the value of data
     */
    public int getData() {
        return data;
    }

    /**
     * Set the value of data
     *
     * @param data new value of data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Get the value of chars
     *
     * @return the value of chars
     */
    public char[] getChars() {
        return chars;
    }

    /**
     * Set the value of chars
     *
     * @param chars new value of chars
     */
    public void setChars(char[] chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return String.format("Chars: %s%nResult: %d%n",
                                            Arrays.toString(chars), data);
    }

}
