package S5_AccessModifier_StaticMethod_StaticProperty.bai_tap.ClassJustWrite;

public class Student {
    private static String name = "John";
    private static String classes = "C08";
    public Student (){

    }

    public static void setName(String name){
        Student.name = name;
    }
    public static void setClasses(String classes){
        Student.classes = classes;
    }


    public String toString() {
        return name + " and " + classes;
    }
}
