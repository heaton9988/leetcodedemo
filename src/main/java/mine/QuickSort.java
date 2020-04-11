package mine;

import util.Util;

public class QuickSort {
    private void quickSort(int[] arr, int start, int end) {
        if (start <= end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pivotIndex = start;

        int l = start + 1;
        int r = end;

        while (l <= r) {
            if (arr[l] > pivot && arr[r] < pivot) {
                swap(arr, l++, r--);
            }
            if (arr[l] <= pivot) {
                l++;
            }
            if (arr[r] >= pivot) {
                r--;
            }
        }
        swap(arr, pivotIndex, r);
        return r;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Util.printArr(arr);
        obj.quickSort(arr, 0, arr.length - 1);
        Util.printArr(arr);
    }
}