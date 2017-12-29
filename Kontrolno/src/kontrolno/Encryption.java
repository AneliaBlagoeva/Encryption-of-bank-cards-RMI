/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolno;

import java.util.ArrayList;

/**
 *
 * @author Anelia
 */
public class Encryption {

    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private ArrayList<Character> cipherPad = new ArrayList<Character>();

    private ArrayList<Character> generateCipherPad(String cipher) {

        char[] cipherCpy = cipher.toCharArray();
        for (Character el : cipherCpy) {
            if (!cipherPad.contains(el)) {
                cipherPad.add(el);
            }
        }

        StringBuilder reversedAlphabet = new StringBuilder();
        reversedAlphabet.append(alphabet);
        reversedAlphabet = reversedAlphabet.reverse();

        char[] reversedAlphabetArr = reversedAlphabet.toString().toCharArray();

        for (Character el : reversedAlphabetArr) {
            if (!cipherPad.contains(el)) {
                cipherPad.add(el);
            }
        }

        return cipherPad;
    }

    class MonoEncryption implements IEncryptable {

        @Override
        public String encrypt(String plainText, String cipher) {

            generateCipherPad(cipher);
            char[] plaintextArr = plainText.toCharArray();
            StringBuilder result = new StringBuilder();

            for (Character letter : plaintextArr) {
                int indexInAlphabet = alphabet.indexOf(letter);
                result.append(cipherPad.get(indexInAlphabet));
            }

            return result.toString();
        }

        @Override
        public String decrypt(String cipherText, String cipher) {

            generateCipherPad(cipher);
            char[] encodedTextArr = cipherText.toCharArray();
            StringBuilder result = new StringBuilder();

            for (Character letter : encodedTextArr) {
                int indexInCipherPad = cipherPad.indexOf(letter);
                result.append(alphabet.charAt(indexInCipherPad));
            }

            return result.toString();
        }

    }
    
    public IEncryptable getMonoCipherMethod(){
        return new MonoEncryption();
    }

}
