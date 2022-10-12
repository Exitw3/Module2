package S2_VongLapTrongJava.thuc_hanh;

import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền gửi: ");
        money = scanner.nextDouble();
        System.out.print("Nhập số tháng gửi: ");
        month = scanner.nextInt();
        System.out.print("Nhập lãi suất: ");
        interestRate = scanner.nextDouble();
        double totalInterestRate = 0;
        for (int i = 1; i <= month; i++)
            totalInterestRate += money * (interestRate / 100)/12 * month;
        System.out.printf("Lãi suất nhận được là: %f", totalInterestRate);
    }
}
