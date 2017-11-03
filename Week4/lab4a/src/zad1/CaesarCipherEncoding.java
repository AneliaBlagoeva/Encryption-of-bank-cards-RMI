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
public class CaesarCipherEncoding {

    private int shiftLength;

    public CaesarCipherEncoding(int shiftLength) {
        setShiftLength(shiftLength);
    }

    public int getShiftLength() {
        return shiftLength;
    }

    public void setShiftLength(int shiftLength) {
        if (shiftLength != 0) {
            this.shiftLength = shiftLength;
        } else {
            shiftLength = 3;
        }

    }

    public String encrypt(String plainText) {
        //declaration & initialization
        char[] plainTextChars = plainText.toCharArray();//safe each on of the letters from plaintext
        char[] encodedChars = new char[plainTextChars.length];

        //processing
        for (int i = 0; i < encodedChars.length; i++) {
            encodedChars[i] = (char) ('A' + (plainTextChars[i] - 'A'
                    + shiftLength + 26) % 26);
        }

        //output
        return new String(encodedChars);
    }

    public String decrypt(String encodedText) {
        //declaration & initialization
        char[] encodedTextChars = encodedText.toCharArray();//safe each on of the letters from encoded chars
        char[] plainTextChars = new char[encodedTextChars.length];

        //processing
        for (int i = 0; i < encodedTextChars.length; i++) {
            plainTextChars[i] = (char) ('A' + (encodedTextChars[i] - 'A'
                    - shiftLength + 26) % 26);
        }

        //output
        return new String(plainTextChars);
    }

    @Override
    public String toString() {
        return String.format("CeasarCipter code = %d" + shiftLength);
    }

}
