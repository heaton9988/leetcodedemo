import java.util.Arrays;

public class DP085_maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] left = new int[cols]; // initialize left as the leftmost boundary possible
        int[] right = new int[cols];
        int[] height = new int[cols];

        Arrays.fill(right, cols); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < rows; i++) {
            int cur_left = 0, cur_right = cols;
            // update height
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            // update left
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = cols;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < cols; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] arr = new int[][]{
                new int[]{1, 0, 1, 0, 0},
                new int[]{1, 0, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1},
                new int[]{1, 0, 0, 1, 0}
        };
        char[][] cs = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                cs[i][j] = (char) ('0' + arr[i][j]);
            }
        }
        Object o = new DP085_maximalRectangle().maximalRectangle(cs);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}