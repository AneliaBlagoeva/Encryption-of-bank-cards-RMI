package clients;

/**
 * class users contains all users
 * from xml file
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
