import java.util.HashMap;

public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int lenHeight = matrix.length;
        int lenWidth = matrix[0].length;

        HashMap<String, Integer> ij2length = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < lenHeight; i++) {
            for (int j = 0; j < lenWidth; j++) {
                if (i == 2 && j == 3) {
                    System.out.println();
                }
                if (matrix[i][j] == '1') {
                    int step = 1;
                    boolean isSquare = true;
                    outer:
                    while (i + step < lenHeight && j + step < lenWidth && isSquare) {
                        for (int k = 0; k <= step; k++) {
                            if (matrix[i + k][j + step] == '0') {
                                isSquare = false;
                                break outer;
                            }
                        }
                        for (int k = 0; k < step; k++) {
                            if (matrix[i + step][j + k] == '0') {
                                isSquare = false;
                                break outer;
                            }
                        }

                        if (isSquare) {
                            step++;
                        }
                    }
                    ij2length.put("i=" + i + ",j=" + j, step);
                    if (step > maxLength) maxLength = step;
                }
            }
        }
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        MaximalSquare221 obj = new MaximalSquare221();
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