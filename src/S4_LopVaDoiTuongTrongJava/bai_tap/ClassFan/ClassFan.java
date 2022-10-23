package S4_LopVaDoiTuongTrongJava.bai_tap.ClassFan;

public class ClassFan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "Blue";

    public ClassFan() {
    }

    public double getRadius() {
        return radius;
    }

    public boolean getOn() {
        return on;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String toString() {
        if (this.on) {
            return "Fan is on " + getSpeed() + " " + getColor() + " " + getRadius();
        } else {
            return "Fan is off " + getColor() + " " + getRadius();
        }
    }

}
