package cspiration.sort;

public class LongestIncreasingSubsequence300 {
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0; // 当前能统计到的最大的size
        for (int num : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 4, 5, 3, 2, 1, 1, 2, 3};
        System.out.println(lengthOfLIS(nums));
    }
}