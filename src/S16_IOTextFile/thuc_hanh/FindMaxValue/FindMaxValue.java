package S16_IOTextFile.thuc_hanh.FindMaxValue;

import java.util.List;

public class FindMaxValue {

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\Module2\\S16_IOTextFile\\src\\FindMaxValue\\number.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\Module2\\S16_IOTextFile\\src\\FindMaxValue\\number.txt\\result.txt", maxValue);
    }
}