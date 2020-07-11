import java.util.ArrayList;
import java.util.List;

public class Matrix329_longestIncreasingPath_dp {
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        // padding the matrix with zero as boundaries
        // assuming all positive integer, otherwise use INT_MIN as boundaries
        int[][] matrix = new int[rows + 2][cols + 2];
        for (int i = 0; i < rows; ++i) {
            System.arraycopy(grid[i], 0, matrix[i + 1], 1, cols);
        }

        // calculate outdegrees
        int[][] outdegree = new int[rows + 2][cols + 2];
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                for (int[] d : dir) {
                    if (matrix[i][j] < matrix[i + d[0]][j + d[1]]) {
                        outdegree[i][j]++;
                    }
                }
            }
        }

        // find leaves who have zero out degree as the initial level
        cols += 2;
        rows += 2;
        List<int[]> leaves = new ArrayList<>();
        for (int i = 1; i < rows - 1; ++i) {
            for (int j = 1; j < cols - 1; ++j) {
                if (outdegree[i][j] == 0) {
                    leaves.add(new int[]{i, j});
                }
            }
        }

        // remove leaves level by level in topological order
        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            List<int[]> newLeaves = new ArrayList<>();
            for (int[] node : leaves) {
                for (int[] d : dir) {
                    int x = node[0] + d[0], y = node[1] + d[1];
                    if (matrix[node[0]][node[1]] > matrix[x][y]) {
                        if (--outdegree[x][y] == 0) {
                            newLeaves.add(new int[]{x, y});
                        }
                    }
                }
            }
            leaves = newLeaves;
        }
        return height;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{9, 9, 4}
                , new int[]{6, 6, 8}
                , new int[]{2, 2, 1}
        };
        System.out.println(new Matrix329_longestIncreasingPath_dp().longestIncreasingPath(arr1));
    }
}