/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import deserialization.User;
import deserialization.Users;

/**
 *
 * @author Anelia
 */
public class Login implements ILoginable{
    String username;
    String password;

    public Login(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public Login() {
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
    public boolean checkCredentials(String username, String password, Users u) {
        boolean result=u.getUsers().contains(new User(username,password));
        System.out.printf("User is signed up: " + result );
        return result;
        
    }
    
    
    
    
}
