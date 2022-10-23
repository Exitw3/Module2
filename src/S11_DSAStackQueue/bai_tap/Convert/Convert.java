package S11_DSAStackQueue.bai_tap.Convert;

import java.util.Scanner;
import java.util.Stack;

public class Convert {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số cần chuyển đổi : ");
        int num = Integer.parseInt(scanner.nextLine());

        while (num > 0) {
            stack.push(num % 2);
            num /= 2;
        }

        System.out.println(stack);
        System.out.println("Độ dài của mảng: " + stack.size());
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.print("Số nhị phân đã chuyển đổi là : ");
        for (int temp : arr) {
            System.out.print(temp);
        }
    }
}
