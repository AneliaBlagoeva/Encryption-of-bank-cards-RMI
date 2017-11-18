package object;



import javafx.scene.Group;

public class Point {

    private int[] coordinates;

    public Point(int[] coords) {
        setCoordinates(coords);
    }

    //NB!!!!
    public Point(Point point) {
        this(point.coordinates);
    }

    //annonymos
    public Point() {
        this(new int[2]);//the same as this(new int[]{0,0})
    }

    ///deep copy, referent mutable type
    public int[] getCoordinates() {
        return new int[]{coordinates[0],coordinates[1]};
    }

    public void setCoordinates(int[] coordinates) {
        if (coordinates!=null && coordinates.length==2) {
            this.coordinates = new int[]{coordinates[0],coordinates[1]};
        }else{
            this.coordinates = new int[2];
        }
        
    }
    

    @Override
    public String toString() {
        return String.format("(%d,%d)", coordinates[0],coordinates[1]);
    }
    
    
}
