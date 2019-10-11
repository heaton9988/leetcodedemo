public class MaximalSquare221_dp {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int lenHeight = matrix.length;
        int lenWidth = matrix[0].length;

        int maxLength = 0;
        int dp[][] = new int[lenHeight][lenWidth];

        for (int i = 0; i < lenHeight; i++) {
            for (int j = 0; j < lenWidth; j++) {
                if (matrix[i][j] == '1') {
                    int left = 0, up = 0, leftUp = 0;
                    if (j - 1 >= 0) left = dp[i][j - 1];
                    if (i - 1 >= 0) up = dp[i - 1][j];
                    if (i >= 1 && j >= 1) leftUp = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(Math.min(left, up), leftUp);
                    int length = dp[i][j];
                    if (length > maxLength) maxLength = length;
                }
            }
        }

        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        MaximalSquare221_dp obj = new MaximalSquare221_dp();
        long start = System.currentTimeMillis();
        System.out.println(obj.maximalSquare(new char[][]{
                new char[]{'0', '0', '0', '1', '0', '1', '1', '1'},
                new char[]{'0', '1', '1', '0', '0', '1', '0', '1'},
                new char[]{'1', '0', '1', '1', '1', '1', '0', '1'},
                new char[]{'0', '0', '0', '1', '0', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0', '0', '1', '0'},
                new char[]{'1', '1', '1', '0', '0', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '1', '0', '0', '1'},
                new char[]{'0', '1', '0', '0', '1', '1', '0', '0'},
                new char[]{'1', '0', '0', '1', '0', '0', '0', '0'},
        }));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}