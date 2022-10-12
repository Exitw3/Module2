package S3_MangVaPhuongThucTrongJava.thuc_hanh;

import java.util.Scanner;

public class FindValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Nhập tên sinh viên: ");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++){
            if (students[i].equals(input_name)){
                System.out.printf("Vị trí của sinh viên %s ở vị trí %d", students[i],i+1);
                isExist = true;
                break;
            }
        } if (!isExist)
            System.out.printf("Sinh viên %s không có trong danh sách.",input_name);
    }
}
