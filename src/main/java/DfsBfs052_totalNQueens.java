public class DfsBfs052_totalNQueens {
    int n;
    int res = 0;
    int[] rows, cols, slashTop, slashBottom;

    public int totalNQueens(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        slashTop = new int[n * 2];
        slashBottom = new int[n * 3];
        backtrack(0);
        return res;
    }

    void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row == n - 1) {
                    res++;
                } else {
                    backtrack(row + 1);
                }
                removeQueen(row, col);
            }
        }
    }

    private void removeQueen(int row, int col) {
        rows[row] = 0;
        cols[col] = 0;
        slashTop[row + col] = 0;
        slashBottom[row - col + n] = 0;
    }

    private void placeQueen(int row, int col) {
        rows[row] = col;
        cols[col] = 1;
        slashTop[row + col] = 1;
        slashBottom[row - col + n] = 1;
    }

    private boolean isNotUnderAttack(int row, int col) {
        int sum = slashTop[row + col] + slashBottom[row - col + n] + cols[col];
        return sum == 0;
    }

    public static void main(String[] args) {
        Object o = new DfsBfs052_totalNQueens().totalNQueens(4);
        System.out.println(o);
    }
}