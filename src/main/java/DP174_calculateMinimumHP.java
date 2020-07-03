public class DP174_calculateMinimumHP {
    private int rowSize = 0;
    private int colSize = 0;
    private int[][] globalDun = null;
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        rowSize = dungeon.length;
        colSize = dungeon[0].length;
        globalDun = dungeon;
        int[][] memory = new int[rowSize][colSize];
        // 初始化为-1，便于区别是否计算过结果了。
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                memory[i][j] = -1;
            }
        }
        return dfs(0, 0, memory) + 1;
    }

    public int dfs (int rowIndex, int colIndex,  int[][] memory) {
        if (rowIndex >= rowSize || colIndex  >=  colSize) {
            return Integer.MAX_VALUE;
        }
        // 不为-1就是计算过了，直接返回结果。
        if (memory[rowIndex][colIndex] != -1) {
            return memory[rowIndex][colIndex];
        }
        if (rowIndex == rowSize - 1 && colIndex == colSize - 1) {
            if (globalDun[rowIndex][colIndex] >= 0) {
                return 0;
            } else {
                return -globalDun[rowIndex][colIndex];
            }
        }
        int right = dfs(rowIndex, colIndex + 1, memory);
        int down = dfs(rowIndex + 1, colIndex, memory);
        int needMin = Math.min(right, down) - globalDun[rowIndex][colIndex];
        int res = 0;
        if (needMin < 0) {
            res =  0;
        } else {
            res =  needMin;
        }
        memory[rowIndex][colIndex] = res;
        System.out.println(rowIndex+ " "+colIndex + " "  + res);
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP174_calculateMinimumHP().calculateMinimumHP(new int[][]{
                new int[]{-1, -5}
                , new int[]{-4,-3}
        });
//        Object o = new DP174_calculateMinimumHP().calculateMinimumHP(new int[][]{
//                new int[]{-2, -3, 3}
//                , new int[]{-5, -10, 1}
//                , new int[]{10, 30, -5}
//        });
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}