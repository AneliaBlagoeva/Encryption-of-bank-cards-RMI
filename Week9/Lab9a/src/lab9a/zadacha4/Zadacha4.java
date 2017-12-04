package lab9a.zadacha4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author grade
 */
public class Zadacha4 {
    public static List<Character> merge(List<Character> l1, List<Character> l2){
        if(l1 == null || l2 == null) return null;
        List<Character> output = new LinkedList<>(l1);
        output.addAll(l2); 
        return output;
    }
    public static void main(String[] args) {
        Random random = new Random();
        List<Character> chars = new LinkedList<>();
        List<Character> reversed ;
        for (int i = 0; i < 10; i++) {
            chars.add((char)('A' + random.nextInt(26)));
            
        }
        reversed = new LinkedList<>(chars);
        Collections.reverse(reversed);
        System.out.println(chars);
        System.out.println(reversed);
        System.out.println(merge(chars, reversed));
    }
}
