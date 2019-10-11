public class MaximalSquare221_test {
    char[][] matrix;

    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0;i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int lR = i + 1;
                int lC = j + 1;
                while(lR < rows && lC < cols) {
                    if (isRect(new int[]{i,j}, new int[]{lR,lC})) {
                        result = Math.max(result, (lR - i) * (lR - i));
                    }
                    lR++;
                    lC++;
                }
            }
        }
        return result;
    }

    private boolean isRect(int[] start, int[] end) {
        int sR = start[0];
        int sC = start[1];
        int eR = end[0];
        int eC = end[1];
        if (eR - sR != eC - sC) {
            return  false;
        }
        for (int i = sR; i < eR; i++) {
            for (int j = sC; j < eC; j++) {
                if (matrix[i][j] != '1') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MaximalSquare221_test obj = new MaximalSquare221_test();
        long start = System.currentTimeMillis();
        System.out.println(obj.maximalSquare(new char[][]{
                new char[]{'0', '0', '0', '1', '0', '1', '1', '1'},
                new char[]{'0', '1', '1', '0', '0', '1', '0', '1'},
                new char[]{'1', '0', '1', '1', '1', '1', '0', '1'},
                new char[]{'0', '0', '0', '1', '0', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0', '0', '1', '0'},
                new char[]{'1', '1', '1', '0', '0', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '1', '0', '0', '1'},
                new char[]{'0', '1', '0', '0', '1', '1', '0', '0'},
                new char[]{'1', '0', '0', '1', '0', '0', '0', '0'},
        }));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}