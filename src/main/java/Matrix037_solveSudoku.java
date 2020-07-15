import util.Util;

public class Matrix037_solveSudoku {
    int n = 3;
    int N = n * n;

    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    int countPlaceNumber;
    int countRemoveNumber;

    public boolean couldPlace(int d, int row, int col) { // Check if one could place a number d in (row, col) cell
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) { // Place a number d in (row, col) cell
        int idx = (row / n) * n + col / n;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    public void removeNumber(int d, int row, int col) { // Remove a number which didn't lead to a solution
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) { // Call backtrack function in recursion to continue to place numbers till the moment we have a solution
        // if we're in the last cell, that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        } else { // if not yet
            // if we're in the end of the row, go to the next row
            if (col == N - 1) {
                backtrack(row + 1, 0);
            } else { // go to the next column
                backtrack(row, col + 1);
            }
        }
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') { // if the cell is empty
            // iterate over all numbers from 1 to 9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    countPlaceNumber++;
                    placeNextNumbers(row, col);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) {
                        removeNumber(d, row, col);
                        countRemoveNumber++;
                    }
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);

        System.out.println("countPlaceNumber=" + countPlaceNumber);
        System.out.println("countRemoveNumber=" + countRemoveNumber);
    }

    public static void main(String[] args) {
        char[][] param = Util.str2charMatrix(
                "53..7...." +
                        ",6..195..." +
                        ",.98....6." +
                        ",8...6...3" +
                        ",4..8.3..1" +
                        ",7...2...6" +
                        ",.6....28." +
                        ",...419..5" +
                        ",....8..79");
        new Matrix037_solveSudoku().solveSudoku(param);
        System.out.println();
    }
}