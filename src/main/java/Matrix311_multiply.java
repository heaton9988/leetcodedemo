public class Matrix311_multiply {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) { // 该行代码为本题希望看到的优化, 因为是稀疏矩阵
                    for (int k = 0; k < B[0].length; k++) {
                        if(B[j][k] != 0) {
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{1, 0, 0}
                , new int[]{-1, 0, 3}
        };
        int[][] arr2 = new int[][]{
                new int[]{7, 0, 0}
                , new int[]{0, 0, 0}
                , new int[]{0, 0, 1}
        };
        new Matrix311_multiply().multiply(arr1, arr2);
        System.out.println();
    }
}