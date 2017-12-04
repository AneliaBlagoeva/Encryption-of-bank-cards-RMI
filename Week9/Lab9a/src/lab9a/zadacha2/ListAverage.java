/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadacha2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author grade
 */
public class ListAverage {
    public static List<Integer> distinct(List <Integer> list){
    List<Integer> output=new ArrayList<>();
    
        for (Integer integer:list) {
          if(!output.contains(integer)){
              output.add(integer);
          }  
        }
        
        return output;
}

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int total = 0;
        double average;
        Random r = new Random();

        for (int i = 0; i < 25; i++) {
            list.add(r.nextInt(101));
        }

        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }
        if (list.size() != 0) {
            average = total / list.size();
            System.out.printf("Average: %.2f %n",average);
        } else {
            System.out.println("List is empty");
        }
        
        
        List<Integer> dist =  distinct(list);
        for (int i = 0; i < dist.size(); i++) {
            int current;
            current=list.get(i);
            
            System.out.printf("%d frequency %d %n", current,Collections.frequency(list, current));
        }
        
        System.out.println(list);
    }
}
