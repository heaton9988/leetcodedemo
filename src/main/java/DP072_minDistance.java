public class DP072_minDistance {
    public int minDistance(String word1, String word2) {
        int cols = word1.length(), rows = word2.length();
        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= cols; i++) dp[0][i] = i;
        for (int i = 1; i <= rows; i++) dp[i][0] = i;

        for (int i = 1; i <= rows; i++) {
            char c2 = word2.charAt(i - 1);
            for (int j = 1; j <= cols; j++) {
                char c1 = word1.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[rows][cols];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP072_minDistance().minDistance("horse", "ros");
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}