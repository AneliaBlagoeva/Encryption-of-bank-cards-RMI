/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Haemimont
 */
public class DistinctNumbersTest {

    public static void main(String[] args) {
        //declaration
        DistinctNumbers sequence;
        ArrayList<Integer> result;
        int input;

        //initialization
        result = new ArrayList<>();
        sequence = new DistinctNumbers();

        //processing
        while (true) {
            input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter element:"));
            if (input != 0) {
                sequence.addElementToSequence(input);
            } else {
                break;
            }
        }

        result = sequence.distinctSequence();

        //output
        sequence.print(result);

    }

}
