package cspiration.sort;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        for (int i = 0; i < nums.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 1, 5, 4, 3, 2, 1};
//        nums = new int[]{3};
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}