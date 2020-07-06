public class DP199_rob {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        if (size == 1) return nums[0];

        int[][] dp = new int[size][2];
        int res = dp[0][1] = nums[0];

        for (int i = 1; i < size - 1; i++) {
            dp[i][1] = dp[i - 1][0] + nums[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (dp[i][1] > res) res = dp[i][1];
        }

        dp = new int[size][2];
        dp[1][1] = nums[1];
        for (int i = 2; i < size; i++) {
            dp[i][1] = dp[i - 1][0] + nums[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (dp[i][1] > res) res = dp[i][1];
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP199_rob().rob(new int[]{2, 3, 2});
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}