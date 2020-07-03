public class DP363_maxSumSubmatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) { // 枚举左边界
            int[] rowSum = new int[rows]; // 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) { // 枚举右边界
                for (int i = 0; i < rows; i++) { // 按每一行累计到 dp
                    rowSum[i] += matrix[i][r];
                }

                // 求 rowSum 连续子数组 的 和
                // 和 尽量大，但不大于 k
                max = Math.max(max, dpmax(rowSum, k));
            }
        }
        return max;
    }

    // 在数组 arr 中，求不超过 k 的最大值
    private int dpmax(int[] arr, int k) {
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] arr = new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, -2, 3}
        };
        char[][] cs = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                cs[i][j] = (char) ('0' + arr[i][j]);
            }
        }
        Object o = new DP363_maxSumSubmatrix().maxSumSubmatrix(arr, 2);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}