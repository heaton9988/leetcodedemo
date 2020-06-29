public class DP070_climbStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP070_climbStairs().climbStairs(4);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}