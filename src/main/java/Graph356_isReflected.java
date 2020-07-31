import java.util.HashSet;
import java.util.Set;

public class Graph356_isReflected {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 17 * 17 * x + 17 * y;
        }

        @Override
        public boolean equals(Object obj) {
            Point other = (Point) obj;
            if (x != other.x) return false;
            if (y != other.y) return false;
            return true;
        }
    }

    public boolean isReflected(int[][] points) {
        Set<Point> set = new HashSet<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            set.add(new Point(x, y));
        }
        int xSum = minX + maxX;
        for (int[] point : points) {
            if (!set.contains(new Point(xSum - point[0], point[1]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Graph356_isReflected obj = new Graph356_isReflected();
        System.out.println(obj.isReflected(new int[][]{{1, 1}, {-1, 1}}));
        System.out.println(obj.isReflected(new int[][]{{1, 1}, {-1, -1}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}