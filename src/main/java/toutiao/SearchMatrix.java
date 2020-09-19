package toutiao;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while (j >= 0 && i < rows) {
            if (matrix[i][j] == target) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{1, 4, 7, 11, 15}
                , new int[]{2, 5, 8, 12, 19}
                , new int[]{3, 6, 9, 16, 22}
                , new int[]{10, 13, 14, 17, 24}
                , new int[]{18, 21, 23, 26, 30}
        };
        for (int i = 0; i < 51; i++) {
            boolean result = new SearchMatrix().searchMatrix(arr1, i);
            if (result)
                System.out.println(i);
        }
    }
}