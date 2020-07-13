import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matrix296_minTotalDistance_median {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        int row = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }

    public static void main(String[] args) {
        Object a = new Matrix296_minTotalDistance_median().minTotalDistance(new int[][]{
                new int[]{1, 0, 0, 0, 1},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0}
        });
        System.out.println(a);
    }
}