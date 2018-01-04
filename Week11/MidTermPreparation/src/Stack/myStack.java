/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Anelia
 * @param <T>
 */
public class myStack <T>{
    private T[] arr;
    private int top;

    public myStack(T[] arr) {
        this.arr = arr;
        top=arr.length;
    }
    
     public myStack(int size){
        arr=(T[]) new Object[size];
        top=-1;
    }
    
    public myStack(){
        this(4);
        top=-1;
    }
    
    public void push (T el){
        top++;
        arr[top]=el;
    }
    
    public T pop(){  
        T temp=arr[top];
        arr[top--]=null;
        return arr[top--];
    }
    
    public void print(){
        Stream.of(arr).forEach(System.out::println);
//        for (int i = 0; i <= top; i++) {
//            System.out.println(arr[i]);
//        }
    }
    
    public void sort(){
       Arrays.sort(arr);
    }
    
    
    
     public static void main(String[] args) {
//            myStack<Integer> st=new myStack<Integer>(4);
//            st.push(5);
//            st.push(12);
//            st.push(1);
//            st.push(9);
//            //st.pop();
//            st.print();
//            st.sort();
//            st.print();
            
            myStack<Person> st=new myStack<Person>(4);
            st.push(new Person(20,"Ani"));
            st.push(new Person(20,"Kris"));
            st.push(new Person(25,"Maria"));
            st.push(new Person(21,"Krisi"));
            st.sort();
            st.print();
            
    }
}
