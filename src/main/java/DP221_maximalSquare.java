public class DP221_maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        int dp[][] = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    if (dp[i][j] > res) res = dp[i][j];
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] arr = new int[][]{
                new int[]{1, 0, 1, 0, 0}
                , new int[]{1, 0, 1, 1, 1}
                , new int[]{1, 1, 1, 1, 1}
                , new int[]{1, 0, 0, 1, 0}
        };
        char[][] cs = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                cs[i][j] = (char) ('0' + arr[i][j]);
            }
        }
        Object o = new DP221_maximalSquare().maximalSquare(cs);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}