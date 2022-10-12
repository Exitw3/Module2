package S1_Introduction_to_Java.bai_tap;

import java.util.Scanner;

public class MoneyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter USD: ");
        int USD = scanner.nextInt();
        int rate = 23000 * USD;
        System.out.printf("Money change VNĐ: %d VNĐ",rate);
    }
}