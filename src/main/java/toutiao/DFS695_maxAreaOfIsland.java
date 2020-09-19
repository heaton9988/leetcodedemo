package toutiao;

import util.Util;

public class DFS695_maxAreaOfIsland {
    int res = 0;
    int rows, cols;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;
        if (cols == 0) return 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, help(grid, i, j));
            }
        }
        return res;
    }

    private int help(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        return 1 +
                help(grid, i - 1, j) +
                help(grid, i + 1, j) +
                help(grid, i, j - 1) +
                help(grid, i, j + 1);
    }

    public static void main(String[] args) {
        DFS695_maxAreaOfIsland obj = new DFS695_maxAreaOfIsland();
        int i = obj.maxAreaOfIsland(Util.str2matrix("0010000100000,0000000111000,0110100000000,0100110010100,0100110011100,0000000000100,0000000111000,0000000110000"));
        System.out.println(i);
    }
}