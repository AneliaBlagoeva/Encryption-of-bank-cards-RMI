/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.ArrayList;

public class DistinctNumbers {

    private ArrayList<Integer> sequence;

    /**
     * Get the value of sequence
     *
     * @return the value of sequence
     */
    public ArrayList<Integer> getSequence() {
        return new ArrayList(sequence);
    }

    /**
     * Set the value of sequence
     *
     * @param sequence new value of sequence
     */
    public void setSequence(ArrayList<Integer> sequence) {
        this.sequence = new ArrayList(sequence);
    }

    public DistinctNumbers(ArrayList<Integer> sequence) {
        setSequence(sequence);
    }

    public DistinctNumbers() {
        sequence = new ArrayList<>();
    }

    public void addElementToSequence(int element) {
        sequence.add(element);
    }

    public void print(ArrayList<Integer> seq) {
        int size = seq.size();
        for (int i = 0; i < size; i++) {
            System.out.println(seq.get(i));
        }
    }

    public ArrayList<Integer> distinctSequence() {
        //declaration
        ArrayList<Integer> result;
        int size;

        //initialization
        result = new ArrayList<Integer>();
        size = sequence.size();

        //processing
        for (int i = 0; i < size; i++) {
            if (!result.contains(sequence.get(i))) {
                result.add(sequence.get(i));
            }
        }//for

        return new ArrayList<Integer>(result);
    }
}
