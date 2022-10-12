package S2_VongLapTrongJava.thuc_hanh;

import java.util.Scanner;

public class UCLN {
    public static void main(String[] args) {
        System.out.println("Nhập vào 2 số để tìm ước chung lớn nhất.");
        Scanner scanner = new Scanner (System.in);
        int num1,num2,UCLN = 1;
        System.out.print("Nhập số thứ nhât: ");
        num1 = scanner.nextInt();
        System.out.print("Nhập số thứ 2: ");
        num2 = scanner.nextInt();
        for (int i = 1; i <= num1 && i <= num2; i++)
        {
            if (num1 % i == 0 && num2 % i == 0)
                UCLN = i;
        }
        System.out.printf("Ước chung lớn nhất của %d và %d là: %d", num1, num2, UCLN);
    }
}
