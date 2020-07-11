public class Matrix240_searchMatrix {
    int[][] matrix;
    int target;
    int rows, cols;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        this.rows = matrix.length;
        if (rows == 0) return false;
        this.cols = matrix[0].length;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i == rows || j == cols) return false;
        if (matrix[i][j] == target) return true;
        return (i + 1 < rows && dfs(i + 1, j)) || (j + 1 < cols && dfs(i, j + 1));
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{1, 3, 5, 7}
                , new int[]{10, 11, 16, 20}
                , new int[]{23, 30, 34, 50}
        };
        System.out.println(new Matrix240_searchMatrix().searchMatrix(arr1, 17));
    }
}