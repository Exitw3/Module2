package S4_LopVaDoiTuongTrongJava.bai_tap.EquadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị cho a: ");
        Double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập giá trị cho b: ");
        Double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập giá trị cho c: ");
        Double c = Double.parseDouble(scanner.nextLine());

        ClassQuadraticEquation classQuadraticEquation = new ClassQuadraticEquation(a, b ,c);
        if (classQuadraticEquation.getDiscriminant() > 0) {
            System.out.println(classQuadraticEquation.getRoot1() + " và " + classQuadraticEquation.getRoot2());
        } else if (classQuadraticEquation.getDiscriminant() == 0) {
            System.out.println(classQuadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
