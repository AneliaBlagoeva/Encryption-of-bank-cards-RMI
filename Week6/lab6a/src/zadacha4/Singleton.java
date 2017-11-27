/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadacha4;

/**
 *
 * @author user
 */
public class Singleton {

    private Singleton() {
    }

    public static class TSingleton {

        private static Singleton obj = new Singleton();

        public static Singleton getInstance() {
            return obj;
        }
    }

}
