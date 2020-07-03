public class DP174_calculateMinimumHP_dp {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rowSize = dungeon.length;
        int colSize = dungeon[0].length;
        int[][] dp = new int[rowSize][colSize];
        // 设置最后一个值。
        dp[rowSize - 1][colSize -1] = Math.max(0, -dungeon[rowSize - 1][colSize - 1]);

        // 设置最后一列的值
        for (int i = rowSize - 2; i >= 0; --i) {
            int needMin = dp[i + 1][colSize - 1] - dungeon[i][colSize - 1];
            dp[i][colSize -1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
        for (int i = colSize - 2; i >= 0; --i) {
            int needMin = dp[rowSize - 1][i + 1] - dungeon[rowSize - 1][i];
            dp[rowSize - 1][i] = Math.max(0, needMin);
        }

        for (int i = rowSize - 2; i >= 0; --i) {
            for (int j = colSize - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        return dp[0][0] + 1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP174_calculateMinimumHP_dp().calculateMinimumHP(new int[][]{
                new int[]{-1, -5}
                , new int[]{-4,-3}
        });
//        Object o = new DP174_calculateMinimumHP().calculateMinimumHP(new int[][]{
//                new int[]{-2, -3, 3}
//                , new int[]{-5, -10, 1}
//                , new int[]{10, 30, -5}
//        });
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}