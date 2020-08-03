import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionFind305_numIslands2_timeout {
    void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        dfs(grid, r - 1, c, visited);
        dfs(grid, r + 1, c, visited);
        dfs(grid, r, c - 1, visited);
        dfs(grid, r, c + 1, visited);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        boolean[][] visited = new boolean[nr][nc];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    ++num_islands;
                    dfs(grid, r, c, visited);
                }
            }
        }
        return num_islands;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        char[][] grid = new char[m][n];
        for (char[] row : grid) {
            Arrays.fill(row, '0');
        }
        for (int[] pos : positions) {
            grid[pos[0]][pos[1]] = '1';
            ans.add(numIslands(grid));
        }
        return ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind305_numIslands2_timeout obj = new UnionFind305_numIslands2_timeout();
        System.out.println(obj.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}