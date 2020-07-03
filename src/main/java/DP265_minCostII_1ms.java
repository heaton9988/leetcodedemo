public class DP265_minCostII_1ms {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int r = costs.length;//room
        int c = costs[0].length;//cost

        int min1 = 0;//minimum cost to paint house i-1 to color j
        int min2 = 0;//second minumum cost to paint house i-1 to color j
        int idx1 = -1;//color of last house

        for(int i = 0; i < r; i++) {
            int m1 = Integer.MAX_VALUE, m2 = m1, id1 = -1;
            for(int j = 0; j < c; j++) {// for painting to different colors for this house, update lowest and second lowerst cost and final color
                int cost = costs[i][j] + (j == idx1 ? min2 : min1);//min1 and min2 are for last house
                if(cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    id1 = j;
                } else if(cost < m2) {
                    m2 = cost;
                }
            }

            min1 = m1; min2 = m2; idx1 = id1;//min 1 and min2 are for each house, get updated after each cycle of k colors
        }
        return min1;

    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new DP265_minCostII().minCostII(new int[][]{
//                new int[]{17, 2, 17}
//                , new int[]{16, 16, 5}
//                , new int[]{14, 3, 19}
//        });
        Object o = new DP265_minCostII_1ms().minCostII(new int[][]{
                new int[]{1, 5, 3}
                , new int[]{2, 9, 4}
        });
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}