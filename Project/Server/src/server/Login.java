package server;

import clients.DeserealizationWarpper;
import clients.User;
import clients.Users;
import common.ILoginable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Another main class Login
 * Here is the main logic
 * for checking right of user 
 * and his credentials.
 * implements interface ILoginable.
 */

/**
 *
 * @author Anelia
 */
public class Login extends UnicastRemoteObject implements ILoginable {

    String username;
    String password;
    Users u;

    /**
     * constructor
     * First we deserialize xml file
     * and fill our class users - list from user
     * @param username
     * @param password
     * @throws RemoteException 
     */
    public Login(String username, String password) throws RemoteException {
        u = DeserealizationWarpper.deserealization();
        setUsername(username);
        setPassword(password);
    }

    /**
     * constructor - deserialize xml file first
     * @throws RemoteException 
     */
    public Login() throws RemoteException {
    u = DeserealizationWarpper.deserealization();
    }

    /**
     * getter for usename
     * @return 
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for username
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter for password
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * check credentials method
     * Main logic. 
     * search an object from class user
     * in list of users, created by
     * deserealization.
     * @param uname
     * @param pass
     * @return 
     */
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

