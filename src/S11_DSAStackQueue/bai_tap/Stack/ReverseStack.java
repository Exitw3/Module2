package S11_DSAStackQueue.bai_tap.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseStack<i> {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        System.out.println(stack);
//        for (int i = stack.size(); i > 0; i--) {
//            stack1.push(stack.pop());
//        }
//        System.out.println(stack1);
        while (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        System.out.println(stack1);


        Stack<String> stack2 = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi bất kì: ");
        String string = scanner.nextLine();

        String[] arr1 = string.split("");
        System.out.println(Arrays.toString(arr1));

        for (String item : arr1) {
            stack2.push(item);
        }

        string = "";
        while (!stack2.isEmpty()) {
            string += stack2.pop() + "";
        }
        System.out.println(string);
    }
}