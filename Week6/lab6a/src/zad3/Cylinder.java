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
public class Cylinder extends Circle implements Comparable {

    private Circle circle;

    /**
     * Get the value of circle
     *
     * @return the value of circle
     */
    public Circle getCircle() {
        return new Circle(circle);
    }

    /**
     * Set the value of circle
     *
     * @param circle new value of circle
     */
    public void setCircle(Circle circle) {
        if (circle != null) {
            this.circle = circle;
        } else {
            this.circle = new Circle();
        }
    }

    private int height;

    /**
     * Get the value of height
     *
     * @return the value of height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the value of height
     *
     * @param height new value of height
     */
    public void setHeight(int height) {
        if (height < 0) {
            this.height = 1;
        } else {
            this.height = height;
        }
    }

    public Cylinder(Circle circle, int height) {
        super(circle.getRadius(), circle.getCoordinates());
        setCircle(circle);
        setHeight(height);
    }

    public Cylinder() {
        super();
        setCircle(new Circle());
        setHeight(1);
    }

    public Cylinder(Cylinder obj) {
        super(obj.getCircle());
        setHeight(obj.getHeight());
    }

    @Override
    public String toString() {
        return "Cylinder{" + "circle=" + circle + ", height=" + height + '}';
    }

    
    @Override
    public boolean greater(Comparable obj) {
        boolean flag = false;

        if (obj.getClass().getName() == "Cylinder") {
            if (super.greater(obj)) {
                flag = true;
            } else {
                flag = false;
            }

            if (this.getHeight() > ((Cylinder) obj).getHeight()) {
                flag = flag && true;
            } else {
                flag = flag && false;
            }
        }

        return flag;
    }
    
}
