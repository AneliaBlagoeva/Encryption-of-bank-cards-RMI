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
public class OuterClassA {
    public class InnerClassA{
        private String data;

        public InnerClassA(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "InnerClassA{" + "data=" + data + '}';
        }
    }
}
