public class Matrix329_longestIncreasingPath_dfs_memory {
    // DFS + Memoization Solution
    // Accepted and Recommended
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j, cache));
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        return ++cache[i][j];
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{9, 9, 4}
                , new int[]{6, 6, 8}
                , new int[]{2, 2, 1}
        };
        System.out.println(new Matrix329_longestIncreasingPath_dfs_memory().longestIncreasingPath(arr1));
    }
}