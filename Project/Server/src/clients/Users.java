package clients;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Anelia
 */
public class Users {
    ArrayList<User> users=new ArrayList<User>();

    public Users() {
    }

    public Users(ArrayList<User> u) {
        setUsers(u);
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    
}
