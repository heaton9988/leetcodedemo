import java.util.Arrays;

public class BinarySearch354_maxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n <= 1) return n;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] second = new int[n];
        for (int i = 0; i < n; i++) {
            second[i] = envelopes[i][1];
        }
        return lengthOfLIS(second);
    }

    private int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int res = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int dpValue = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpValue = Math.max(dpValue, dp[j] + 1);
                }
            }
            dp[i] = dpValue;
            if (dpValue > res) res = dpValue;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                new int[]{5, 4}
                , new int[]{6, 4}
                , new int[]{6, 7}
                , new int[]{2, 3}
        };
        nums = new int[][]{
                new int[]{4, 5}
                , new int[]{4, 6}
                , new int[]{6, 7}
                , new int[]{2, 3}
                , new int[]{1, 1}
        };
        int result = new BinarySearch354_maxEnvelopes().maxEnvelopes(nums);
        System.out.println(result);
    }
}