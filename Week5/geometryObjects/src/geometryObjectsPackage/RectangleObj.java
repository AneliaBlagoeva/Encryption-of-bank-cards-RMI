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
    
    private PointObj[] points;

    /**
     * Get the value of points
     *
     * @return the value of points
     */
    public PointObj[] getPoints() {
       PointObj[] temp= new PointObj[points.length];
        for(int i=0;i<points.length;i++){
            temp[i]= new PointObj(points[i]);//temp[i]=points[i] - plitko kopirane
        }
        
        return temp;
    }

    /**
     * Set the value of points
     *
     * @param points new value of points
     */
    public void setPoints(PointObj[] points) {
        if (points!=null && points.length==2) {
        //this.points = new PointObj[]{new PointObj(points[0]),new PointObj(points[1])};
        this.points = new PointObj[points.length];
        for(int i=0;i<points.length;i++){
            this.points[i]=points[i]!=null ? new PointObj(points[i]):new PointObj();
        }
        } else {
            this.points=new PointObj[]{new PointObj(),new PointObj()};
        }
        
        
        
    }

    public RectangleObj(PointObj[] points) {
        setPoints(points);
    }

    public RectangleObj() {
        this(new PointObj[]{new PointObj(),new PointObj()});
    }
    
    public RectangleObj(RectangleObj rect){
        this(rect.points);
    }

    public void draw(Group group){
        int[] pointACoordinates=points[1].getCoordinates();
        int[] pointBCoordinates=points[0].getCoordinates();
        double width=Math.abs(pointACoordinates[0]-pointBCoordinates[0]);
        
        double height=Math.abs(pointACoordinates[1]-pointBCoordinates[1]);
        
        
        javafx.scene.shape.Rectangle rectangle=new Rectangle(pointACoordinates[0], pointACoordinates[1],width,height);
    
        rectangle.setStroke(Color.RED);
        rectangle.setFill(null);
        group.getChildren().add(rectangle);
    }
    @Override
    public String toString() {
        return String.format("Rectangle{A%s,B%s}",points[0],points[1]);
    }
    
    
    
    

}
