package S1_Introduction_to_Java.thuc_hanh;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào tháng bạn muốn đếm ngày: ");
        byte month = scanner.nextByte();

        switch (month) {
            case 2:
                System.out.printf("Tháng %d Có 28 hoặc 29 ngày.", month);
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.printf("Tháng %d Có 31 ngày.", month);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.printf("Tháng %d Có 30 ngày.", month);
                break;
            default:
                System.out.printf("Tháng %d không hợp lệ.", month);
        }
    }
}