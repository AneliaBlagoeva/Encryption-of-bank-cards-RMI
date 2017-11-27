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
public class SingletonTest {
    public static void main(String[] args) {
            Singleton s1=Singleton.TSingleton.getInstance();
            Singleton s2=Singleton.TSingleton.getInstance();
            
            System.out.println(s1);
            System.out.println(s2);
            
    }
    
}
