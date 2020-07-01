public class DP375_getMoneyAmount_dp {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP375_getMoneyAmount_dp().getMoneyAmount(10);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}