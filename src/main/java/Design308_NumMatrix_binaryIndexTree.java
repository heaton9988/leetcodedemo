public class Design308_NumMatrix_binaryIndexTree {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        Design308_NumMatrix_binaryIndexTree obj = new Design308_NumMatrix_binaryIndexTree(new int[]{});
        Design308_NumMatrix_binaryIndexTree obj = new Design308_NumMatrix_binaryIndexTree(new int[][]{{1, 2, 3, 4}, {2, 2, 3, 4}, {3, 2, 3, 4}, {4, 2, 3, 4}});
//        obj.update(3, 100);
//        for (int i = 0; i < 4; i++) {
//            for (int j = i; j < 4; j++) {
//                System.out.println(i + "," + j);
//                System.out.println(obj.sumRange(i, j));
//            }
//        }
//        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    int[][] matrix;
    int[][] tree;
    int rows, cols;

    public Design308_NumMatrix_binaryIndexTree(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        if (rows > 0) {
            cols = matrix[0].length;
            if (cols > 0) {
                this.tree = new int[rows + 1][cols + 1];

                for (int j = 0; j < cols; j++) {
                    for (int k = j + 1; k <= cols; k += k & -k) {
                        tree[1][k] += matrix[0][j];
                    }

                }
                for (int i = 0; i < rows; i++) {
                    for (int x = i + 1; x <= rows; x += x & -x) {
                        tree[x][1] += matrix[i][0];
                    }
                }

                System.out.println();
            }
        }
    }

    public void update(int row, int col, int val) {
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 0;
    }
}