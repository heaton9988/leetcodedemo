package cspiration.sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = partition(nums, i, j);
        quickSort(nums, i, mid - 1);
        quickSort(nums, mid + 1, j);
    }

    public static int partition(int[] nums, int begin, int end) {
        int temp = nums[begin];
        int i = begin;
        int j = end;
        while (i < j) {
            while (i < j && nums[j] > temp) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= temp) {
                i++;
            }
            nums[j] = nums[i];
        }

        nums[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{7,6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
