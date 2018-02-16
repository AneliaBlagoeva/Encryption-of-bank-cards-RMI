package common;

/**
 * Interface for encryption feature shared by server and client
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Chryptable extends Remote {

    /**
    method with main logic for encoding card id code
     * @throws java.rmi.RemoteException
*/
    String encode(String code) throws RemoteException;

    /**
     * method for decoding card id code
     *
     * @throws java.rmi.RemoteException */
    String decode(String code) throws RemoteException;
    
}
