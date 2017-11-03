/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

/**
 *
 * @author grade
 */
public class SimpleTranspositionTest {
    public static void main(String[] args) {
            SimpleTransposition simple = new SimpleTransposition("beauty");
            System.out.println(simple.encrypt("thisistheplaintext")); 
            System.out.println(simple.decrypt("ttihhnietspeilxsat"));
            
    }
}
