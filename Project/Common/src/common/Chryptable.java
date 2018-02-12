package common;

/**
 * Interface for encryption feature shared by server and client
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Chryptable extends Remote {

    /**
    method with main logic for encoding card id code
*/
    String encode(String code) throws RemoteException;

    /**
     * method for decoding card id code
     * */
    String decode(String code) throws RemoteException;
    
}
