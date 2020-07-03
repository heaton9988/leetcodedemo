public class DP265_minCostII {
    public int minCostII(int[][] costs) {
        int rows = costs.length;
        int cols = costs[0].length;

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < cols; k++) {
                    if (k == j) continue;
                    if (costs[i + 1][k] < min) min = costs[i + 1][k];
                }
                costs[i][j] = costs[i][j] + min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            if (costs[0][j] < min) min = costs[0][j];
        }
        return min;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new DP265_minCostII().minCostII(new int[][]{
//                new int[]{17, 2, 17}
//                , new int[]{16, 16, 5}
//                , new int[]{14, 3, 19}
//        });
        Object o = new DP265_minCostII().minCostII(new int[][]{
                new int[]{1, 5, 3}
                , new int[]{2, 9, 4}
        });
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}