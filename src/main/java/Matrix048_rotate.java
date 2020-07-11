public class Matrix048_rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                new int[]{1, 2, 3}
                , new int[]{4, 5, 6}
                , new int[]{7, 8, 9}
        };
        nums = new int[][]{
                new int[]{1, 2, 3, 4}
                , new int[]{5, 6, 7, 8}
                , new int[]{9, 10, 11, 12}
                , new int[]{13, 14, 15, 16}
        };
        new Matrix048_rotate().rotate(nums);
    }
}