public class DP276_numWays {
    public int numWays(int n, int k) {
        int[] dp = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP276_numWays().numWays(3, 3);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}