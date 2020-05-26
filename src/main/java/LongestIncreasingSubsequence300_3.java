public class LongestIncreasingSubsequence300_3 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = 1;

        for (int i = 1; i < n; i++) {
            int targetIndex = -1;
            int l = 0, r = res - 1;
            while (l <= r) {
                if (l == r) {
                    if (nums[i] > dp[l]) {
                        targetIndex = l + 1;
                    } else {
                        targetIndex = l;
                    }
                    break;
                }
                int m = l + (r - l) / 2;
                if (nums[i] == dp[m]) {
                    targetIndex = m;
                    break;
                } else if (nums[i] > dp[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (targetIndex == res) {
                res++;
            }
            if (targetIndex < 0) {
                targetIndex = 0;
            }
            dp[targetIndex] = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] nums = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        System.out.println(lengthOfLIS(nums));
    }
}