public class DP256_minCost {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length + 1][3];

        for (int i = costs.length - 1; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP256_minCost().minCost(new int[][]{
                new int[]{17, 2, 17}
                , new int[]{16, 16, 5}
                , new int[]{14, 3, 19}
        });
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}