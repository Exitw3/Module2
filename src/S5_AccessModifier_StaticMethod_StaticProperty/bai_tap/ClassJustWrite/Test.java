package S5_AccessModifier_StaticMethod_StaticProperty.bai_tap.ClassJustWrite;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);
        Student.setName("Tài");
        Student.setClasses("C08");
        System.out.println(student.toString());
    }
}
