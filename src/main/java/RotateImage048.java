import java.util.ArrayList;
import java.util.List;

public class RotateImage048 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1 || matrix[0].length <= 1) return;
        int N = matrix.length;
        // 对角线反转
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 中轴线反转
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int j2 = N - 1 - j;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][j2];
                matrix[i][j2] = temp;
            }
        }
    }


    public static void main(String[] args) {
        RotateImage048 obj = new RotateImage048();
        int[][] input = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };
        input = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16}
        };
        long start = System.currentTimeMillis();
        obj.rotate(input);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}