/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptphonenumber;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class EncryptPhoneNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //declaration
        int userInput, //number from user
                digit1, //right first digit
                digit2, //second digit
                digit3, //third digit
                digit4, //forth digit
                result;//save result
        Scanner kbd;
        
        //initialization
        
        kbd=new Scanner(System.in);
        
        System.out.print("Enter four digit number: ");
        userInput=kbd.nextInt();
        
        //processing
        digit1=userInput % 10;
        digit2=(userInput/10) % 10;
        digit3=(userInput/100) % 10;
        digit4=userInput /1000;
        
        digit1=(digit1+7) % 10;
        digit2=(digit2+7) %10;
        digit3=(digit3+7) %10;
        digit4=(digit4+7) %10;
        
        
        result=digit2*1000 + digit1*100 + digit4*10 + digit3;
        
        //output
        
        System.out.println("Result:" + result );
    }
    
}
