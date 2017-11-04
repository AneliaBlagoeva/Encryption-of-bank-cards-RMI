/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometryObjectsPackage;

import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 *
 * @author grade
 */
public class Line {

    private Point ePoint;

    /**
     * Get the value of ePoint
     *
     * @return the value of ePoint
     */
    public Point getePoint() {
        return new Point(ePoint);
    }

    /**
     * Set the value of ePoint
     *
     * @param ePoint new value of ePoint
     */
    public void setePoint(Point ePoint) {
        if (ePoint != null) {
            this.ePoint = new Point(ePoint);
        } else {
            this.ePoint = new Point();
        }

    }

    private Point sPoint;

    /**
     * Get the value of sPoint
     *
     * @return the value of sPoint
     */
    public Point getsPoint() {
        return new Point(sPoint);
    }

    /**
     * Set the value of sPoint
     *
     * @param sPoint new value of sPoint
     */
    public void setsPoint(Point sPoint) {
        if (sPoint != null) {
            this.sPoint = new Point(sPoint);
        } else {
            this.sPoint = new Point();
        }

    }

    public Line(Point ePoint, Point sPoint) {
        setsPoint(sPoint);
        setePoint(ePoint);
    }

    public Line() {
        this(new Point(), new Point());
    }
    
    public Line(Line line){
        this(line.sPoint,line.ePoint);
    }

    
     public void draw(Group group){
        int[] pointACoordinates=sPoint.getCoordinates();
        int[] pointBCoordinates=ePoint.getCoordinates();

        javafx.scene.shape.Line line=new javafx.scene.shape.Line(pointACoordinates[0],pointACoordinates[1],
                pointBCoordinates[0],pointBCoordinates[1]);
    
        line.setStroke(Color.RED);
        group.getChildren().add(line);
    }
    @Override
    public String toString() {
        return String.format("Line{S%s,E%s}",sPoint,ePoint);
    }
    

}
