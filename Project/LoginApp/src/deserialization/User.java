/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserialization;

/**
 *
 * @author Anelia
 */
public class User {
    String username;
    String password;
    int hasRights;
    
    public User(String username, String password, int hasRights) {
        setHasRights(hasRights);
        setPassword(password);
        setUsername(username);
    }
    

    public int getHasRights() {
        return hasRights;
    }

    public void setHasRights(int hasRights) {
        this.hasRights = hasRights;
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

    public User() {
    }
    
    
    
}
