package S11_DSAStackQueue.bai_tap.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String string = "aae bb aa";
        Stack<Object> stack = new Stack<>();
        Queue<Object> queue = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        System.out.println(stack);
        for (int i = string.length() - 1; i >= 0; i--) {
            queue.add(string.charAt(i));
        }
        System.out.println(queue);
        if (stack.equals(queue)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}