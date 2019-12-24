package cspiration.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            a(nums, low, mid, high);
        }
    }

    private static void a(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int x = low; x <= high; x++) {
            nums[x] = temp[x - low];
        }
    }


    public static void main(String[] args) throws Exception {
        {
            int[] nums = {6, 5, 1, 5, 4, 3, 2, 1};
//        nums = new int[]{3};
            System.out.println(Arrays.toString(nums));
            mergeSort(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
        }
    }
}