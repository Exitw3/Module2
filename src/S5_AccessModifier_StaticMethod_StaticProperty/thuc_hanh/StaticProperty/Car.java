package S5_AccessModifier_StaticMethod_StaticProperty.thuc_hanh.StaticProperty;

public class Car {

    private String name;

    private String engine;

    public static int numberOfCars;

    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }
}