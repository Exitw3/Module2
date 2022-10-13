package S4_LopVaDoiTuongTrongJava.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    double height, width;

    public Rectangle(double height, double withd) {
        this.height = height;
        this.width = withd;
    }

    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return (this.height + this.width) * 2;
    }

    public String display() {
        return "Rectangle{" +
                "height=" + height +
                ", withd=" + width +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều cao: ");
        double height = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập chiều rộng: ");
        double width = Double.parseDouble(scanner.nextLine());
        Rectangle rectangle = new Rectangle(height, width);
        System.out.println("Hình chữ nhật là:  " + rectangle.display());
        System.out.println("Chu vi hình chữ nhật là: " + rectangle.getPerimeter());
        System.out.println("Diện tích hình chữ nhật là: " + rectangle.getArea());
    }
}