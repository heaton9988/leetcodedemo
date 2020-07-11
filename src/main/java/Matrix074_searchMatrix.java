public class Matrix074_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        int l = 0, r = rows * cols - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) return true;
            if (target < matrix[i][j]) {
                r = mid - 1;
            } else {
                l = mid + 1;
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
        System.out.println(new Matrix074_searchMatrix().searchMatrix(arr1, 0));
    }
}