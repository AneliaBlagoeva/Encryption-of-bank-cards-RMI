/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2_25605;

import hw2_25605.RouteCipher;

public class RouteCipherTest {
    public static void main(String[] args) {
           RouteCipher r=new RouteCipher(5);
           String s=r.encrypt("LIFE IS WAY TOO SHORT FOR WHOLE-WHEAT DONUTS");
           r.decrypt(s);
    }
    
}
