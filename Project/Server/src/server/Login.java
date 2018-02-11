package server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import clients.DeserealizationWarpper;
import clients.User;
import clients.Users;
import common.ILoginable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Anelia
 */
public class Login extends UnicastRemoteObject implements ILoginable {

    String username;
    String password;
    Users u;

    public Login(String username, String password) throws RemoteException {
        u = DeserealizationWarpper.deserealization();
        setUsername(username);
        setPassword(password);
    }

    public Login() throws RemoteException {
    u = DeserealizationWarpper.deserealization();
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
    public boolean checkCredentials(String uname,String pass) {
        boolean flag = false;

        User user=new User(uname,pass);
        if (u.getUsers().contains(user)) {
            int index = u.getUsers().indexOf(user);
            if (u.getUsers().get(index).getHasRights() == 1) {
                flag = true;
            }
        }

        return flag;
    }

         
}

