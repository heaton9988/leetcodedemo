public class DP198_rob {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;

        int dp[][] = new int[size][2];
        int res = dp[0][1] = nums[0];

        for (int i = 1; i < size; i++) {
            dp[i][1] = dp[i - 1][0] + nums[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (dp[i][1] > res) res = dp[i][1];
        }
        return res;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP198_rob().rob(new int[]{1, 2, 3, 1});
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}