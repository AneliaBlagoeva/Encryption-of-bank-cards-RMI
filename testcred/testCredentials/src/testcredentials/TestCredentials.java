/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcredentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anelia
 */
public class TestCredentials {
public static boolean isValidPassword(String password) {

        String PASSWORD_REGEXP =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
                
        Pattern pattern = Pattern.compile(PASSWORD_REGEXP);
        Matcher matcher;
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

public static boolean isValidUsername(String username) {

        String  USERNAME_REGEXP = "^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$";

        Pattern pattern = Pattern.compile(USERNAME_REGEXP);
        Matcher matcher;
        matcher = pattern.matcher(username);
        return matcher.matches();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(isValidPassword("123aB@aB"));
        System.out.println(isValidUsername("Desi"));
        // TODO code application logic here
    }
    
}
