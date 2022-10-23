package S5_AccessModifier_StaticMethod_StaticProperty.bai_tap.access_modifier;

public class Circle {

    private double radius = 1.0;
    private String color = "Red";

    public Circle() {

    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public String toString() {
        return radius + " + " + color + " + " + getArea();
    }
}