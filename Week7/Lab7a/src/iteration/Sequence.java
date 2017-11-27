/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteration;

import java.util.Random;

/**
 *
 * @author grade
 */
public class Sequence { // outer class
// Holds a sequence of Objects.

    private Object[] obs;
    private int next = 0;

    public Sequence(int size) {
        obs = new Object[size];
    }

    public void add(Object x) {
        if (next < obs.length) {
            obs[next] = x;
            next++;
        }
    }

    private class Sselector implements Selector {
// inner class манипулира преместване от първия към последния

        int i = 0;

        public boolean end() {
            return i == next;
        }

        public Object current() {
            return obs[i];
        }

        public void next() {
            if (i < next) {
                i++;
            }
        }
    } // end of inner class

    private class SBselector implements SelectorBackward {
// inner class манипулира преместване от последния към първия 

        int i = next-1;

        public boolean first() {
            return i < 0;
        }

        public Object current() {
            return obs[i];
        }

        public void previous() {
            if (i >= 0) {
                i--;
            }
        }
    } // end of inner class

    public SBselector getSBselector() {
        return new SBselector();
    }

    //MAIN
    public static void main(String[] args) {
        // (1)създайте Sequence последователност от 8 елемента
        Random r = new Random();
        Sequence seq = new Sequence(8);

        // (2)инициализирайте Sequence елементите 
        for (int i = 0; i < 4; i++) {
            seq.add(10 + r.nextInt(91));
        }

        // (3)използвайте метода getSelector(),за да разпечатате 
// тези числа на конзолата 
        SBselector s = seq.getSBselector();
        while (!s.first()) {
            System.out.println(s.current());
            s.previous();
        }
    }
} // end of Sequence.java

