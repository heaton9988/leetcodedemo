package mine;

import util.Util;

public class MergeSort {
    private void mergeSort(int[] arr, int start, int end) {
        int size = end - start + 1;
        if (size > 1) {
            int middle = start + (end - start) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    private void merge(int[] arr, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int tempIndex = 0;
        int l = start, r = middle + 1;
        while (l <= middle && r <= end) {
            if (arr[l] < arr[r]) {
                temp[tempIndex++] = arr[l++];
            } else {
                temp[tempIndex++] = arr[r++];
            }
        }
        while (l <= middle) {
            temp[tempIndex++] = arr[l++];
        }
        while (r <= end) {
            temp[tempIndex++] = arr[r++];
        }
        for (int i = 0; i < end - start + 1; i++) {
            arr[i + start] = temp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Util.printArr(arr);
        obj.mergeSort(arr, 0, arr.length - 1);
        Util.printArr(arr);
    }
}