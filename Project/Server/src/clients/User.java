package clients;

import java.util.Objects;

/**
 * class User which is filled from an xml file Every user has username, password
 * and flag if he has rights for encyprt and decrypt.
 *
 */
/**
 *
 * @author Anelia
 */
public class User {

    String username;
    String password;
    int hasRights;

    /**
     * constrructor with 3 parameters
     *
     * @param username
     * @param password
     * @param hasRights
     */
    public User(String username, String password, int hasRights) {
        setHasRights(hasRights);
        setPassword(password);
        setUsername(username);
    }

    /**
     * constructor with 2 parameters
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        setPassword(password);
        setUsername(username);
    }

    /**
     * getter for flag has rights
     *
     * @return
     */
    public int getHasRights() {
        return hasRights;
    }

    /**
     * setter for flag has rights
     *
     * @param hasRights
     */
    public void setHasRights(int hasRights) {
        this.hasRights = hasRights;
    }

    /**
     * getter for user name
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for user name
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter for password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    /**
     * override method equals for using contains we check if user contains in
     * xml file.
     *
     * @param obj
     * @return
     */
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
