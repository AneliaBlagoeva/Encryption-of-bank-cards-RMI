/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author grade
 */
public interface Chryptable extends Remote {

    String encode() throws RemoteException;

    String decode() throws RemoteException;

}
