package S6_Inheritance.bai_tap.CircleAndCylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){

    }
    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getVolume(){
        return getArea()* this.height;
    }

    public String toString() {
        return " height = " + height + super.toString();
    }
}