package base;

import util.Util;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, j, i);
                }
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        int[] arr = new int[]{6, 5, 4};
        Util.printArr(arr);
        obj.bubbleSort(arr);
        Util.printArr(arr);

        System.out.println();
    }
}