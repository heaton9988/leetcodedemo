import java.util.ArrayList;
import java.util.List;

public class DfsBfs051_solveNQueens {
    int rows[]; // queens positions
    int cols[];
    int hills[];
    int dales[];
    int n;
    List<List<String>> output = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        backtrack(0);
        return output;
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row == n - 1) { // if n queens are already placed
                    addSolution();
                } else { // if not proceed to place the rest
                    backtrack(row + 1);
                }
                removeQueen(row, col); // backtrack
            }
        }
    }

    public boolean isNotUnderAttack(int row, int col) {
        int res = cols[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col) {
        rows[row] = col;
        cols[col] = 1;
        hills[row - col + 2 * n] = 1;  // "hill" diagonals
        dales[row + col] = 1;   //"dale" diagonals
    }

    public void removeQueen(int row, int col) {
        rows[row] = 0;
        cols[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = rows[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; ++j) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < n - col - 1; ++j) {
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public static void main(String[] args) {
        Object o = new DfsBfs051_solveNQueens().solveNQueens(8);
        System.out.println(o);
    }
}