public class Matrix378_kthSmallest_binarySearch {
    public int kthSmallest(int[][] matrix, int kth) {
        int n = matrix.length;
        int minVal = matrix[0][0];
        int maxVal = matrix[n - 1][n - 1];
        while (minVal < maxVal) {
            int midVal = minVal + ((maxVal - minVal) >> 1);
            if (check(matrix, midVal, kth, n)) {
                maxVal = midVal;
            } else {
                minVal = midVal + 1;
            }
        }
        return minVal;
    }

    public boolean check(int[][] matrix, int midVal, int kth, int n) {
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= midVal) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count >= kth;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{1, 3, 5, 7}
                , new int[]{10, 11, 16, 20}
                , new int[]{23, 30, 34, 50}
                , new int[]{24, 31, 35, 51}
        };
        arr1 = new int[][]{
                new int[]{1, 5, 9}
                , new int[]{10, 11, 12}
                , new int[]{13, 13, 15}
        };
        System.out.println(new Matrix378_kthSmallest_binarySearch().kthSmallest(arr1, 13));
    }
}