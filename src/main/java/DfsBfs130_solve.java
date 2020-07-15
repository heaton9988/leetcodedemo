import util.Util;

public class DfsBfs130_solve {
    int rows, cols;
    char[][] board;

    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        if (rows == 0) return;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || j == 0 || i == rows - 1 || j == cols - 1) && board[i][j] == 'O') {
                    dfs(i, j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != 'O') return;
        board[i][j] = '#';
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    public static void main(String[] args) {
//        char[][] param = Util.str2charMatrix("XXXX,XOOX,XXOX,XOXX");
        char[][] param = Util.str2charMatrix("OOOOXX,OOOOOO,OXOXOO,OXOOXO,OXOXOO,OXOOOO");
        new DfsBfs130_solve().solve(param);
        System.out.println();
    }
}