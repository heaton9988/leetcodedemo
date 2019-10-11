package base;

import util.Util;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        if (arr == null) return null;
        int len = arr.length;
        if (len <= 1) return arr;
        return _mergeSort(arr, 0, len - 1); // len >= 2
    }

    private int[] _mergeSort(int[] arr, int start, int end) {
        if (start == end) return new int[]{arr[start]};

        int middle = (start + end) / 2;
        int[] arrLeft = _mergeSort(arr, start, middle);
        int[] arrRight = _mergeSort(arr, middle + 1, end);
        return _merge(arrLeft, arrRight);
    }

    private int[] _merge(int[] arrLeft, int[] arrRight) {
        int lenLeft = arrLeft.length, lenRight = arrRight.length;
        int[] arrResult = new int[lenLeft + lenRight];
        int left = 0, right = 0, result = 0;

        while (left < lenLeft || right < lenRight) {
            if (left < lenLeft && right < lenRight) {
                if (arrLeft[left] < arrRight[right]) {
                    arrResult[result++] = arrLeft[left++];
                } else {
                    arrResult[result++] = arrRight[right++];
                }
            } else if (left < lenLeft) {
                arrResult[result++] = arrLeft[left++];
            } else if (right < lenRight) {
                arrResult[result++] = arrRight[right++];
            }
        }
        return arrResult;
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int[] arr = new int[]{9, 8,9, 8, 7, 6, 5, 4, 3, 2,9, 8, 7, 6, 5, 4, 3, 2, 1};
        Util.printArr(arr);
        int[] result = obj.mergeSort(arr);
        Util.printArr(result);
    }
}