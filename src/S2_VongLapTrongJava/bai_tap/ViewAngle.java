package S2_VongLapTrongJava.bai_tap;

import java.util.Scanner;

public class ViewAngle {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0){
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Lựa chọn ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Print the rectangle");
                    for (int i = 1; i <= 4; i++){
                        for (int j = 1; j <= 10; j++ ){
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    int i = 1;
                    while (i <= 5) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        i++;
                        System.out.println("");
                    }

                    System.out.printf("\n");

                    for (int k = 5; k >= 1; k--) {
                        for (int j = 1; j <= k; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    System.out.println("     *");
                    System.out.println("    * *");
                    System.out.println("   * * *");
                    System.out.println("  * * * *");
                    System.out.println(" * * * * * ");
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice");
            }
        }
    }
}
