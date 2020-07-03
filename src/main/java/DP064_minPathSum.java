public class DP064_minPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][] = new int[rows][cols];

        int sum = 0;
        for (int i = 0; i < cols; i++) {
            dp[0][i] = sum = sum + grid[0][i];
        }
        sum = dp[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = sum = sum + grid[i][0];
        }

        for (int i = 1; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                dp[j][i] = Math.min(dp[j - 1][i], dp[j][i - 1]) + grid[j][i];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP064_minPathSum().minPathSum(new int[][]{
                new int[]{1, 3, 1}
                , new int[]{1, 5, 1}
                , new int[]{4, 2, 1}
        });
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}