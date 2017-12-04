/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author grade
 */
public class ArrayListTest {

    private ArrayList<String> list;
    Scanner kbd;

    public ArrayListTest() {
    }
    
    

    public ArrayListTest(ArrayList<String> list) {
        this.list = list;
        kbd = new Scanner(System.in);
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void getNames() {
        String endString = "&";
        String inputFirst, inputLast;
        while (true) {
            System.out.print("Enter first name: (& to quit)");
            inputFirst = kbd.nextLine();
            if (inputFirst.equals(endString)) {
                break;
            }

            System.out.print("Enter last name: (& to quit)");
            inputLast = kbd.nextLine();
            if (inputLast.equals(endString)) {
                break;
            }

            list.add(String.format("%s,$%s", inputLast, inputFirst));
        }
    }

    public void sort(boolean ascending)//asc order
    {
        if (ascending) {
            Collections.sort(list);
        } else {
            Collections.sort(list, Collections.reverseOrder());
        }

    }

    public void searchName(String keyName) {
        int result;
        sort(true);

        result = Collections.binarySearch(list, keyName);

        System.out.printf("%s is %s", keyName, result >= 0 ? "found" : "not found");

        //print list
        System.out.println(list);
    }
    
    
    public static void main(String[] args) {
       ArrayListTest test= new ArrayListTest();
       test.getNames();
       test. sort(true);
       test.searchName("Ivan Ivanov");
    }
    
    public String toString(){
        Collections.sort(list);
        String sorted = list.toString();
        
        Collections.sort(list, Collections.reverseOrder());
        sorted += list.toString();
        
        
        return sorted; 
    }

}
