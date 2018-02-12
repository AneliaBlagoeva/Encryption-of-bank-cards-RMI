package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for login feature shared by server and client
 * */
public interface ILoginable extends Remote{
    
    /**
     * method that checks if user is signed up and if he has right for encrypt and decrypt cards
     * */
    public boolean checkCredentials(String username, String password) throws RemoteException ;
   
}
