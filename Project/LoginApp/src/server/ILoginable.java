/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import deserialization.Users;
import java.rmi.Remote;

/**
 *
 * @author Anelia
 */
public interface ILoginable extends Remote{
    public boolean checkCredentials(String username, String password, Users list);
}
