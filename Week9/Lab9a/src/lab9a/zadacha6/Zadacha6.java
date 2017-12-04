/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9a.zadacha6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author grade
 */
public class Zadacha6 {

    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("Kyle");
        nameList.add("Cathy");
        nameList.add("Sam");
        nameList.add("Sara");
        
        System.out.println("backward with ListIterator    ");
        ListIterator<String> listIterator = nameList.listIterator(nameList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        
        System.out.println("backward with Iterator    ");
        Collections.reverse(nameList);
        Iterator<String> nameIterator = nameList.iterator();
        while (nameIterator.hasNext()) {
            System.out.println(nameIterator.next());
        }

    }
}
