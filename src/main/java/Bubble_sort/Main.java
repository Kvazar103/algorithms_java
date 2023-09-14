package Bubble_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{64, 12, 14, 29, 80, 20, 57, 19, 10, 105, 78};

        System.out.println(Arrays.toString(array));
        boolean isSorted = false;

        while (!isSorted) { //isSorted!=true
            isSorted=true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted=false;// Це означає, що ще потрібно провести щонайменше ще одну ітерацію, оскільки масив не впорядкований.
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

//метод для виведення масиву
//    private static void printArray(int[] arr) {
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            if (i > 0) {
//                System.out.print(", ");
//            }
//            System.out.print(arr[i]);
//        }
//        System.out.print("]");
//    }
}
