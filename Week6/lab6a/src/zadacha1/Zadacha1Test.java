/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadacha1;

import object.Line;
import object.Point;
import java.util.Random;


/**
 *
 * @author grade
 */
public class Zadacha1Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Line line1,line2;
        Point pointA, pointB;
        Random rand=new Random();
        pointA=new Point(new int[]{rand.nextInt(101),rand.nextInt(101)});
        pointB=new Point(new int[]{rand.nextInt(101),rand.nextInt(101)});
        
        line1=new Line(pointA,pointB);
        line2=new Line(pointA,pointB);
        
        System.out.printf("Line %s,%s %n",pointA, pointB);
        System.out.printf("Line %s %n",line1);
        System.out.printf("Line %s %n",line2);
        
    }
    
}
