/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.Random;

/**
 *
 * @author user
 */
public class hierarhyTest {
    public static void main(String[] args) {
        Random r=new Random();
        Point p=new Point();
        Circle c=new Circle();
        Cylinder cy=new Cylinder();
        
        Comparable[] arr = new Comparable[9];
        
        for(int i=0;i<3;i++)
        {
            p=new Point(new int[]{10+r.nextInt(50),10+r.nextInt(50)});
            arr[i]=p;
            c=new Circle(10+r.nextInt(30),p.getCoordinates());
            arr[i+3]=c;
            cy=new Cylinder(c,10+r.nextInt(60));
            arr[i+6]=cy;
        }
          
            
            BubbleSort b=new BubbleSort();
            b.sortArray(arr);
            
            
            for(Comparable el : arr){
                System.out.println(el.toString());
            }
    }
}
