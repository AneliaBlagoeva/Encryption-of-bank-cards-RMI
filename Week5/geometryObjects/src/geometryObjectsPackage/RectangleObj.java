/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometryObjectsPackage;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author grade
 */
public class RectangleObj {
    
    private Point[] points;

    /**
     * Get the value of points
     *
     * @return the value of points
     */
    public Point[] getPoints() {
       Point[] temp= new Point[points.length];
        for(int i=0;i<points.length;i++){
            temp[i]= new Point(points[i]);//temp[i]=points[i] - plitko kopirane
        }
        
        return temp;
    }

    /**
     * Set the value of points
     *
     * @param points new value of points
     */
    public void setPoints(Point[] points) {
        if (points!=null && points.length==2) {
        //this.points = new Point[]{new Point(points[0]),new Point(points[1])};
        this.points = new Point[points.length];
        for(int i=0;i<points.length;i++){
            this.points[i]=points[i]!=null ? new Point(points[i]):new Point();
        }
        } else {
            this.points=new Point[]{new Point(),new Point()};
        }
        
        
        
    }

    public RectangleObj(Point[] points) {
        setPoints(points);
    }

    public RectangleObj() {
        this(new Point[]{new Point(),new Point()});
    }
    
    public RectangleObj(RectangleObj rect){
        this(rect.points);
    }

    public void draw(Group group){
        int[] pointACoordinates=points[0].getCoordinates();
        int[] pointBCoordinates=points[1].getCoordinates();
        double width=Math.abs(pointBCoordinates[0]-pointACoordinates[0]);
        
        double height=Math.abs(pointBCoordinates[1]-pointACoordinates[1]);
        
        
        Rectangle rectangle=new Rectangle(pointACoordinates[0], pointACoordinates[1],width,height);
    
        rectangle.setStroke(Color.RED);
        rectangle.setFill(null);
        group.getChildren().add(rectangle);
    }
    @Override
    public String toString() {
        return String.format("Rectangle{A%s,B%s}",points[0],points[1]);
    }
    
    
    
    

}
