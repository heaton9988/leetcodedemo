package cspiration.sort;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void insertBinarySort(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i + 1];
            int low = 0;
            int high = i;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (temp > nums[middle]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
            for (int j = i; j > high; j--) {
                nums[j + 1] = nums[j];
            }
            nums[high + 1] = temp;
        }
    }

    public static void main(String[] args) {
        {
            int[] nums = {6, 5, 1, 5, 4, 3, 2, 1};
//        nums = new int[]{3};
            System.out.println(Arrays.toString(nums));
            insertSort(nums);
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = {6, 5, 1, 5, 4, 3, 2, 1};
//        nums = new int[]{3};
            System.out.println(Arrays.toString(nums));
            insertBinarySort(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}