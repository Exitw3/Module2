package S14_ThuatToanSapXep.bai_tap.InsertionSortByStep;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Nhập độ dài mảng: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.printf("Nhập %d giá trị: ", arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Mảng nhập vào là: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("\nChương trình bắt đầu xử lý sắp xếp... ");
        InsertionSortBysStep(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    public static void InsertionSortBysStep(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int k = arr[i];
            int j = i -1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = k;
            System.out.printf("\nMảng sau %d lần sắp xếp: ", i);
            for (int l = 0; l < arr.length; l++)
                System.out.print(arr[l] + "\t");
        }
        System.out.print("\nMảng sau khi sắp xép là: ");
    }
}