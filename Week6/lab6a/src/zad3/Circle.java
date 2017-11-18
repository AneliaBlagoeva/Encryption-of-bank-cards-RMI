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
public class Circle extends Point implements Comparable{

    private int radius;

    public Circle(int radius, int[] coordinates) {
        super(coordinates);
        setRadius(radius);
    }

    public Circle() {
        super();
        setRadius(0);
    }

    public Circle(Circle circle) {
        super(circle.getCoordinates());
        setRadius(circle.getRadius());
    }

    /**
     * Get the value of radius
     *
     * @return the value of radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Set the value of radius
     *
     * @param radius new value of radius
     */
    public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1;
        }
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }

    
    @Override
    public boolean greater(Comparable obj) {
        boolean flag = true;
        if (obj instanceof Circle) {
            Point center = new Point(((Circle) obj).getCoordinates());
            if (this.greater(center)) {
                flag = true;
            } else {
                flag = false;
            }
            
            if(((Circle) obj).getRadius()<this.getRadius()){
                flag=flag && true;
            }else{
                flag=flag && false;
            }
        }else{
            flag=false;
        }
        return flag;
    }
}
