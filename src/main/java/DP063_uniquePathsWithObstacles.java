public class DP063_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] param = new int[][]{
                new int[]{0, 0, 0}
                , new int[]{0, 1, 0}
                , new int[]{0, 0, 0}
        };
        Object o = new DP063_uniquePathsWithObstacles().uniquePathsWithObstacles(param);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}