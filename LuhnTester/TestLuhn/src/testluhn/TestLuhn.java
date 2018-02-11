/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testluhn;

import java.util.ArrayList;

/**
 *
 * @author Anelia
 */
public class TestLuhn {
    public static boolean luhnTest(String s){
       char[] inputArr = s.toCharArray();
       int sumOdd=0;
        int sumDoubledEven=0;
        
        ArrayList<Integer> resultArr = new ArrayList<Integer>();

        for (char current : inputArr) {
                int digit = (Character.getNumericValue(current));
                resultArr.add(digit);
            }
        
        for(int i=0;i<resultArr.size();i+=2){
            sumOdd+=resultArr.get(i);
        }
        System.out.println(sumOdd);
        
        for(int i=1;i<resultArr.size();i+=2){
            int temp=resultArr.get(i)*2;
            int sumDigitsTemp=(temp%10)+(temp/10);
            sumDoubledEven+=sumDigitsTemp;          
        }
        System.out.println(sumDoubledEven);
      return ((sumOdd+sumDoubledEven)%10)==0;  
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(luhnTest("3540651119394381"));
    }
    
}
