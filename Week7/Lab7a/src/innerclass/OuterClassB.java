/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innerclass;

/**
 *
 * @author grade
 */
public class OuterClassB {
    private class InnerClassB extends OuterClassA.InnerClassA{
        public InnerClassB(OuterClassA outer, String data){
            outer.super(data);
        }
        
    }
}

