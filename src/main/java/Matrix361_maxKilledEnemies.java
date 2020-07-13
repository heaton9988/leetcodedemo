public class Matrix361_maxKilledEnemies {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int result = 0;
        int rowhits = 0;
        //为什么row用int,而col用int[]记录？因为遍历顺序是每行每行的遍历，假设一次遍历同一行的a,b,c, 那么这三个数字的colhits是完全不相同的，是分别属于它们自己的col，而它们的rowhits若无'W'的话是同一行的同一个结果
        int[] colhits = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowhits = 0;
                    for (int k = j; k < cols && grid[i][k] != 'W'; k++) {
                        rowhits += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colhits[j] = 0;
                    for (int k = i; k < rows && grid[k][j] != 'W'; k++) {
                        colhits[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0') {
                    result = Math.max(result, rowhits + colhits[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Object a = new Matrix361_maxKilledEnemies().maxKilledEnemies(new char[][]{
                new char[]{'W', 'E', 'E', '0'}
                , new char[]{'E', '0', 'W', 'E'}
                , new char[]{'0', 'E', '0', '0'}
//                new char[]{'0', 'E', '0', '0'}
//                , new char[]{'E', '0', 'W', 'E'}
//                , new char[]{'0', 'E', '0', '0'}
        });
        System.out.println(a);
    }
}