import util.Util;

public class DfsBfs200_numIslands {
    int rows, cols;
    char[][] grid;

    public int numIslands(char[][] grid) {
        int res = 0;
        this.grid = grid;
        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    public static void main(String[] args) {
        char[][] param = Util.str2charMatrix( //
                "11000"  //
                        + ",11000" + //
                        ",00100" + //
                        ",00011");
        System.out.println(new DfsBfs200_numIslands().numIslands(param));
    }
}