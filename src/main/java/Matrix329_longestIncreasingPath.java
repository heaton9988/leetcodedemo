public class Matrix329_longestIncreasingPath {
    int res = 0;
    int[][] matrix;
    int rows, cols;
    boolean[][] visit;
    int[][] cache;
    int count = 0;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        if (rows == 0) return res;
        this.cols = matrix[0].length;
        visit = new boolean[rows][cols];
        cache = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, 1);
            }
        }
        System.out.println("count=" + count);
        return res;
    }

    private void dfs(int i, int j, int lastStep) {
        if (cache[i][j] >= lastStep) {
            count++;
            return;
        }
        cache[i][j] = lastStep;
        visit[i][j] = true;
        if (lastStep > res) res = lastStep;

        if (i + 1 < rows && matrix[i + 1][j] > matrix[i][j] && !visit[i + 1][j]) {
            dfs(i + 1, j, lastStep + 1);
        }
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j] && !visit[i - 1][j]) {
            dfs(i - 1, j, lastStep + 1);
        }
        if (j + 1 < cols && matrix[i][j + 1] > matrix[i][j] && !visit[i][j + 1]) {
            dfs(i, j + 1, lastStep + 1);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j] && !visit[i][j - 1]) {
            dfs(i, j - 1, lastStep + 1);
        }
        visit[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{9, 9, 4}
                , new int[]{6, 6, 8}
                , new int[]{2, 2, 1}
        };
        System.out.println(new Matrix329_longestIncreasingPath().longestIncreasingPath(arr1));
    }
}