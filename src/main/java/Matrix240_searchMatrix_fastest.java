public class Matrix240_searchMatrix_fastest {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        if (cols == 0) return false;

        int i = rows - 1, j = 0;
        while (i >= 0 && j < cols) {
            int v = matrix[i][j];
            if (target < v) {
                i--;
            } else if (target > v) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{1, 3, 5, 7}
                , new int[]{10, 11, 16, 20}
                , new int[]{23, 30, 34, 50}
        };
        System.out.println(new Matrix240_searchMatrix_fastest().searchMatrix(arr1, 16));
    }
}