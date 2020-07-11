import util.Util;

public class Matrix059_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;

        int count = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                res[rowStart][j] = count++;
            }
            rowStart++;
            if (rowStart > rowEnd) break;
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = count++;
            }
            colEnd--;
            if (colStart > colEnd) break;
            for (int j = colEnd; j >= colStart; j--) {
                res[rowEnd][j] = count++;
            }
            rowEnd--;
            if (rowStart > rowEnd) break;
            for (int i = rowEnd; rowStart <= rowEnd && i >= rowStart; i--) {
                res[i][colStart] = count++;
            }
            colStart++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] o = new Matrix059_generateMatrix().generateMatrix(4);
        Util.printArr(o);
    }
}