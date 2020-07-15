import util.Util;

public class Matrix036_isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] col = new int[9][9];
        int[][][] block = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int digit = board[i][j] - '1';
                row[digit]++;
                if (row[digit] > 1) return false;
                col[j][digit]++;
                if (col[j][digit] > 1) return false;

                int blockX = i / 3, blockY = j / 3;
                block[blockX][blockY][digit]++;
                if (block[blockX][blockY][digit] > 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Object obj = new Matrix036_isValidSudoku().isValidSudoku(Util.str2charMatrix(
                "53..7...." +
                        ",6..195..." +
                        ",.98....6." +
                        ",8...6...3" +
                        ",4..8.3..1" +
                        ",7...2...6" +
                        ",.6....28." +
                        ",...419..5" +
                        ",....8..79"));
        System.out.println(obj);
    }
}