/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometryObjectsPackage;

import javafx.scene.Group;
import javafx.scene.shape.Line;

/**
 *
 * @author grade
 */
public class LineObj {

    private PointObj ePoint;

    /**
     * Get the value of ePoint
     *
     * @return the value of ePoint
     */
    public PointObj getePoint() {
        return new PointObj(ePoint);
    }

    /**
     * Set the value of ePoint
     *
     * @param ePoint new value of ePoint
     */
    public void setePoint(PointObj ePoint) {
        if (ePoint != null) {
            this.ePoint = new PointObj(ePoint);
        } else {
            this.ePoint = new PointObj();
        }

    }

    private PointObj sPoint;

    /**
     * Get the value of sPoint
     *
     * @return the value of sPoint
     */
    public PointObj getsPoint() {
        return new PointObj(sPoint);
    }

    /**
     * Set the value of sPoint
     *
     * @param sPoint new value of sPoint
     */
    public void setsPoint(PointObj sPoint) {
        if (sPoint != null) {
            this.sPoint = new PointObj(sPoint);
        } else {
            this.sPoint = new PointObj();
        }

    }

    public LineObj(PointObj ePoint, PointObj sPoint) {
        setsPoint(sPoint);
        setePoint(ePoint);
    }

    public LineObj() {
        this(new PointObj(), new PointObj());
    }
    
    public LineObj(LineObj line){
        this(line.sPoint,line.ePoint);
    }

    
     public void draw(Group group){
        int[] pointACoordinates=sPoint.getCoordinates();
        int[] pointBCoordinates=ePoint.getCoordinates();

        javafx.scene.shape.Line line=new Line(pointACoordinates[0],pointACoordinates[1],
                pointBCoordinates[0],pointBCoordinates[1]);
    
        group.getChildren().add(line);
    }
    @Override
    public String toString() {
        return String.format("Line{S%s,E%s}",sPoint,ePoint);
    }
    

}
