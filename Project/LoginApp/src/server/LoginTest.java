/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
            Chryptable obj = new Encryption();
            
            registry.rebind("Encryption", obj);
            System.in.read();
            System.exit(0);
            
        } catch (RemoteException ex) {
            System.out.println("remote" + ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
