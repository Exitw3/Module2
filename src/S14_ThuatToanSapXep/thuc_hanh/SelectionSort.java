package S14_ThuatToanSapXep.thuc_hanh;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double currenMin = list[i];
            int currenMinIndex = i;

            for (int j = i; j < list.length; j++){
                if (currenMin > list[j]){
                    currenMin = list[j];
                    currenMinIndex = j;
                }
            }

            if (currenMinIndex != i){
                list[currenMinIndex] = list[i];
                list[i] = currenMin;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}