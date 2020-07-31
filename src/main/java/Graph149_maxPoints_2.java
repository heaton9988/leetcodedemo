import java.util.HashSet;

public class Graph149_maxPoints_2 {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int i = 0;
        //判断所有点是否都相同的特殊情况
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                break;
            }
        }
        if (i == points.length - 1) return points.length;

        HashSet<String> set = new HashSet<>();
        int max = 0;
        for (i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                String key = getK(points[i][0], points[i][1], points[j][0], points[j][1])
                        + "@"
                        + getB(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (set.contains(key)) { // 如果set里包含了这个斜率, 那么说明这种斜率的点已经在后面的代码中全部统计过了
                    continue;
                }
                int tempMax = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                            tempMax++;
                        }
                    }
                }
                if (tempMax > max) {
                    max = tempMax;
                }
                set.add(key);
            }
        }
        return max + 2;
    }

    private double getB(int x1, int y1, int x2, int y2) {
        if (x2 == x1) return Double.POSITIVE_INFINITY;
        return (double) (y1 * x2 - x1 * y2) / (x2 - x1);
    }

    private double getK(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 0) return Double.POSITIVE_INFINITY;
        return (double) (y2 - y1) / (x2 - x1);
    }

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        return (long) (y2 - y1) * (x - x2) == (long) (y - y2) * (x2 - x1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Graph149_maxPoints_2 obj = new Graph149_maxPoints_2();
        obj.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}});
//        obj.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}