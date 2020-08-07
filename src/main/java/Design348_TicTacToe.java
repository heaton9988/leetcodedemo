public class Design348_TicTacToe {
    int n;
    int[][] rowCount;
    int[][] colCount;
    int[][] slash;

    public Design348_TicTacToe(int n) {
        this.n = n;
        rowCount = new int[3][n];
        colCount = new int[3][n];
        slash = new int[3][2];
    }

    public int move(int row, int col, int player) {
        if (++rowCount[player][row] == 3) return player;
        if (++colCount[player][col] == 3) return player;
        if (row == col) {
            if (++slash[player][0] == 3) return player;
        }
        if (row + col == n - 1) {
            if (++slash[player][1] == 3) return player;
        }
        return 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design348_TicTacToe toe = new Design348_TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}