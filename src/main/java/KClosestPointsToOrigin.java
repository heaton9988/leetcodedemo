import java.util.Arrays;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Point[] pointObjs = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointObjs[i] = new Point(points[i][0], points[i][1], points[i][0] * points[i][0] + points[i][1] * points[i][1]);
        }
        Arrays.sort(pointObjs);
        int[][] ret = new int[K][];
        for (int i = 0; i < K; i++) {
            Point p = pointObjs[i];
            ret[i] = new int[]{p.x, p.y};
        }
        return ret;
    }

    static class Point implements Comparable<Point> {
        private int x;
        private int y;
        private int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) {
//        System.out.println(findMaxElement(new int[]{2, 1, 3})[0] + "," + findMaxElement(new int[]{2, 1, 3})[1]);
        int[][] arr = new int[][]{{1, 3}, {1, 3}, {-2, 2}, {-20, 20}};
        int k = 3;
        int[][] points = new KClosestPointsToOrigin().kClosest(arr, k);
        for (int[] point : points) {
            System.out.println("point[" + point[0] + "," + point[1] + "]");
        }
    }
}