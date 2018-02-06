/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Anelia
 */
public class LoginTest {
    public static void main(String[] args) {
            try {
            ILoginable o = new Login();
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("Login", o);
        } catch (RemoteException ex) {
            System.out.println("remote" + ex);
        }
    }
    
}
