package S4_LopVaDoiTuongTrongJava.bai_tap.ClassFan;

public class Main {
    public static void main(String[] args) {
        ClassFan classFan = new ClassFan();
        ClassFan classFan1 = new ClassFan();
        classFan.setSpeed(classFan.FAST);
        classFan.setRadius(10);
        classFan.setColor("Yellow");
        classFan.setOn(true);
        classFan1.setSpeed(classFan.MEDIUM);
        classFan1.setRadius(5);
        classFan1.setColor("Blue");
        classFan1.setOn(false);
        System.out.println(classFan + " và " + classFan1);
    }
}
