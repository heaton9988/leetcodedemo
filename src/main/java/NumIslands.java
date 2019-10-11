public class NumIslands {
    int width;
    int height;

    public int numIslands(char[][] grid) {
        height = grid.length;
        if (height == 0) return 0;
        width = grid[0].length;

        int[][] hasGone = new int[height][width];

        int ret = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (hasGone[i][j] == 1) {
                    continue;
                }
                String c = grid[i][j] + "";
                if (c.equals("1")) {
                    markCounted(hasGone, grid, i, j);
                    ret++;
                } else if (c.equals("0")) {
                    continue;
                } else {
                    throw new RuntimeException("error input");
                }
            }
        }
        return ret;
    }

    private void markCounted(int[][] hasGone, char[][] grid, int i, int j) {
        if ((grid[i][j] + "").equals("0")) {
            return;
        } else {
            hasGone[i][j] = 1;
        }
        if (i - 1 >= 0) {
            if (hasGone[i - 1][j] == 0) {
                markCounted(hasGone, grid, i - 1, j);
            }
        }
        if (j - 1 >= 0) {
            if (hasGone[i][j - 1] == 0) {
                markCounted(hasGone, grid, i, j - 1);
            }
        }
        if (i + 1 < height) {
            if (hasGone[i + 1][j] == 0) {
                markCounted(hasGone, grid, i + 1, j);
            }
        }
        if (j + 1 < width) {
            if (hasGone[i][j + 1] == 0) {
                markCounted(hasGone, grid, i, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
//        char[][] grid = new char[][]{
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };

        int ints = new NumIslands().numIslands(grid);
        System.out.println(ints);
    }
}