package S7_AbtractAndInterface.bai_tap.Colorable;

public class SquareColorableMain extends Square  {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square();
        squares[1] = new Square(2.0);
        squares[2] = new Square(5);
        for (int i = 0; i < squares.length; i++) {
            System.out.println("Area square " + i + " is: " + squares[i].getArea());
            squares[i].howToColor();
//            if (squares[i] instanceof SquareColorable) {
//                System.out.println("Square has Colorable is Square " + i + ": ");
//                squares[i].howToColor();
//            }
        }
    }
}