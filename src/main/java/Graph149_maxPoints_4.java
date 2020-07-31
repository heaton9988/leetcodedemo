public class Graph149_maxPoints_4 {
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            long dx = x - points[i - 1][0];
            long dy = y - points[i - 1][1];
            int count = 0;
            if (dx == 0 && dy == 0) { // 相同的点
                for (int[] point : points) {
                    if (point[0] != x || point[1] != y) {
                        continue;
                    }
                    count++;
                }
            } else { // 不相同的点
                for (int[] point : points) {
                    if ((point[0] - x) * dy != (point[1] - y) * dx) {
                        continue;
                    }
                    count++;
                }
            }
            res = Math.max(res, count);
        }
        int diag = 0;
        for (int[] point : points) {
            if (point[0] != point[1]) continue;
            diag++;
        }
        return Math.max(res, diag);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Graph149_maxPoints_4 obj = new Graph149_maxPoints_4();
        obj.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}});
//        obj.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}