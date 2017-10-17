package zad2;

public class Rectangle {

    private double width;

    private double height;

    private String color;

    public Rectangle(double widht, double height, String color) {
        setColor(color);
        setHeight(height);
        setWidth(width);
    }

    public Rectangle() {
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setWidth(double width) {
        if(width<=0)
        {
            this.width=0;
        }
        else{
            this.width=width;
        }
    }

    public void setHeight(double height) {
        if(height<=0)
        {
            this.height=0;
        }
        else{
            this.height=height;
        }
    }

    public void setColor(String color) {
        
            this.color=color;
        
    }

    public double getArea() {
        return height*width;
    }

    public double getParameter() {
        return (2*height + 2*width);
    }
}
