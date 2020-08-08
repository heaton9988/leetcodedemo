public class Design304_NumMatrix {
    int[][] matrix;
    int rows, cols;

    public Design304_NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        if (rows == 0) {
            cols = 0;
        } else {
            cols = matrix[0].length;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;

        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                res += matrix[i][col2];
            } else {
                res += matrix[i][col2] - matrix[i][col1 - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design304_NumMatrix obj = new Design304_NumMatrix(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}});

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}