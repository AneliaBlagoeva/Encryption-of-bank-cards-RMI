package object;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author grade
 */
public class Line extends Point {

    private Point ePoint;
    private static int cnt;
    public final String ID;

    public Line(Point ePoint, int[] coords) {
        super(coords);
        setePoint(ePoint);
        ID=String.format("%06d", cnt++);
    }

    public Line(Point ePoint) {
        this(new Point(), new int[2]);
    }

    public Line(Line line) {
        this(line.ePoint, line.getCoordinates());
    }

    public Line(Point ePoint, Point sPoint) {
//        super(sPoint);
//        setePoint(ePoint);

        this(ePoint, sPoint.getCoordinates());
    }

    public Line() {
        this(new Point(), new Point());
    }

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

    public double lineLength() {
        double deltaX = getCoordinates()[0] - ePoint.getCoordinates()[0];
        double deltaY = getCoordinates()[1] - ePoint.getCoordinates()[1];
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return String.format("%s: A %s, B %s",ID, super.toString(), ePoint);
    }

}
