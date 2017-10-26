
package zad6;

public class ComplexNumber {

    private double imaginaryPart;

    private double realPart;

    public double getAngle() {
        return Math.atan2(imaginaryPart, realPart);
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getMagnitute() {
        return Math.abs(Math.sqrt(Math.pow(realPart, 2) 
                + Math.pow(imaginaryPart, 2)));
    }

    public ComplexNumber add(ComplexNumber c){
        return null;
    }

    public ComplexNumber() {
    }
    
    
    public ComplexNumber(double imaginaryPart, double realPart) {
        this.imaginaryPart = imaginaryPart;
        this.realPart = realPart;
    }
    
    
}
