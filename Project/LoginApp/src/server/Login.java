/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import deserialization.User;
import deserialization.Users;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

/**
 *
 * @author Anelia
 */
public class Login extends UnicastRemoteObject implements ILoginable {

    String username;
    String password;

    public Login(String username, String password) throws RemoteException {
        setUsername(username);
        setPassword(password);
    }

    public Login() throws RemoteException {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean checkCredentials(Users u) {
         boolean flag=false;
         
        
        if( u.getUsers().contains(this)){
        int index=u.getUsers().indexOf(this);
        if(u.getUsers().get(index).getHasRights()==1) flag=true;
        }
        
        return flag;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        } else {
            return (this.username.equals(((User) obj).getUsername()) && this.password.equals(((User) obj).getPassword()));
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        return hash;
    }

}
