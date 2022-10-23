package S5_AccessModifier_StaticMethod_StaticProperty.bai_tap.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setColor("Blue");
        circle.setRadius(5);
        System.out.println(circle.toString());
    }
}
