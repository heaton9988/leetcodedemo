public class Design304_NumMatrix_dp {
    int[][] dp;
    int rows, cols;

    public Design304_NumMatrix_dp(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) {
            cols = 0;
        } else {
            cols = matrix[0].length;
        }
        dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return dp[row2][col2];
        if (row1 == 0) return dp[row2][col2] - dp[row2][col1 - 1];
        if (col1 == 0) return dp[row2][col2] - dp[row1 - 1][col2];
        return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design304_NumMatrix_dp obj = new Design304_NumMatrix_dp(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}});

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}