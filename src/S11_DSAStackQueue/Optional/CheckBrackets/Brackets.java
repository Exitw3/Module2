package S11_DSAStackQueue.Optional.CheckBrackets;

import java.util.LinkedList;
import java.util.Scanner;

public class Brackets {
    public static void main(String[] args) {
        LinkedList<Character> bStack = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("kiểm tra chuỗi đầu vào : ");
        String str = sc.nextLine();
        boolean isTrue = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                bStack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (bStack.size() == 0) {
                    isTrue = false;
                    break;
                } else {
                    bStack.pop();
                }
            }
        }
        if (bStack.size() != 0) {
            isTrue = false;
        }
        if (isTrue) {
            System.out.println("well");
        } else System.out.println("???");
    }
}