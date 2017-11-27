/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Random;
import javax.crypto.Cipher;

/**
 *
 * @author echrk
 */
public class Wrapper {

    private int size;
    public Wrapper(int size) {
        setSize(size);

    }

    /**
     * Get the value of size
     *
     * @return the value of size
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the value of size
     *
     * @param size new value of size
     */
    public void setSize(int size) {
        this.size = size >= 0 ? size : 0;
    }

    private class FixedRandom implements Cipherable {

        @Override
        public char[] getSecretChars(int seed) {
            char[] chars = new char[size];
            Random random = new Random(seed);
            for (int i = 0; i < chars.length; i++) {
                chars[i] =  (char) ('A' + random.nextInt(26));
            }
            return chars;
        }
    }
    public Cipherable makeFixedRandom(){
        return new FixedRandom();
    }
        private class FixedSelection implements Cipherable {

        @Override
        public char[] getSecretChars(int seed) {
            seed = seed>=0 && seed < 26? seed: 4;
            char[] chars = new char[size];
            Random random = new Random();
            char[] letters  = new char[seed];
            for (int i = 0; i < letters.length; i++) {
                letters[i]  = (char) ('A' + random.nextInt(26));
            }
           
            for (int i = 0; i < chars.length; i++) {
                chars[i] =  letters[random.nextInt(seed)];
            }
            return chars;
        }
    }
    public Cipherable makeFixeSelection(){
        return new FixedSelection();
    }
}
