import java.util.ArrayList;
import java.util.List;

public class Matrix054_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) return res;
        int cols = matrix[0].length;

        int rowStart = 0, rowEnd = rows - 1;
        int colStart = 0, colEnd = cols - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                res.add(matrix[rowStart][j]);
            }
            rowStart++;
            if (rowStart > rowEnd) break;
            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (colStart > colEnd) break;
            for (int j = colEnd; j >= colStart; j--) {
                res.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            if (rowStart > rowEnd) break;
            for (int i = rowEnd; rowStart <= rowEnd && i >= rowStart; i--) {
                res.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return res;
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
        Object o = new Matrix054_spiralOrder().spiralOrder(nums);
        System.out.println(o);
    }
}