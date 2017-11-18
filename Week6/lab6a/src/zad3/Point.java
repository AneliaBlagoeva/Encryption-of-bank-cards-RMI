/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author user
 */
public class Point implements Comparable {

    private int[] coordinates;

    public Point(int[] coordinates) {
        setCoordinates(coordinates);
    }

    public Point() {
        this(new int[2]);
    }

    public Point(Point point) {
        this(new int[]{point.coordinates[0], point.coordinates[1]});
    }

    /**
     * Get the value of coordinates
     *
     * @return the value of coordinates
     */
    public int[] getCoordinates() {
        return new int[]{coordinates[0], coordinates[1]};
    }

    /**
     * Set the value of coordinates
     *
     * @param coordinates new value of coordinates
     */
    public void setCoordinates(int[] coordinates) {
        if (coordinates != null && coordinates.length == 2) {
            this.coordinates = new int[]{coordinates[0], coordinates[1]};
        } else {
            this.coordinates = new int[]{0, 0};//new int[2]
        }
    }

    @Override
    public String toString() {
        return "Point(" + coordinates[0] + ','+coordinates[1]+')';
    }

    
    
    @Override
    public boolean greater(Comparable obj) {
        boolean flag = true;
        if (obj instanceof Point) {

            if ((((Point) obj).coordinates[0] < this.coordinates[0])
                    && (((Point) obj).coordinates[1] < this.coordinates[1])) {
                flag = true;
            } else {
                flag = false;
            }
        }else{
            flag=false;
        }
        return flag;
    }
}


