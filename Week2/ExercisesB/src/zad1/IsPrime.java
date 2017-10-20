/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author user
 */
public class IsPrime {
    public boolean isPrime(int number){
        //decaration
        int cnt;
        
        //initialization
        cnt=0;
        
        //processing
        for(int i=1;i<Math.sqrt(number);i++){
            if(number%i==0){
                cnt++;
            }
        }
        
        if(cnt>1){
            return false;
        }else{
            return true;
        }
        
    }
}
