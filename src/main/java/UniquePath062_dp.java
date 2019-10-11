public class UniquePath062_dp {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePath062_dp obj = new UniquePath062_dp();
        long start = System.currentTimeMillis();
        System.out.println(obj.uniquePaths(3, 2));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}