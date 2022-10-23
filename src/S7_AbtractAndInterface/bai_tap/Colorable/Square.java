package S7_AbtractAndInterface.bai_tap.Colorable;

public class Square implements Colorable{
    private double side=1;

    public Square(double side) {
        this.side = side;
    }

    public Square() {
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return side + "+" + getArea();
    }

    @Override
    public void howToColor() {
        System.out.println("vẽ 4 cạnh ");
    }
}