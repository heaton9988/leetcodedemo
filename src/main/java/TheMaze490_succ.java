import util.Util;

public class TheMaze490_succ {
    int[][] maze;
    int height, width;
    int destX, destY;
    int[][] directionOffset = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited; // 往一个方向走到底的时候, 把这个底临时记录为 [ 访问过 ]

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) return false;
        this.maze = maze;
        this.height = maze.length;
        this.width = maze[0].length;
        this.destX = destination[0];
        this.destY = destination[1];
        this.visited = new boolean[height][width];

        for (int i = 0; i <= 3; i++) {
            if (dfs(start[0], start[1], i)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int directId) {
        System.out.println("maze\n");
        Util.printArr(maze);
        System.out.println("visited\n");
        Util.printArr(visited);

        int iCurr = i, jCurr = j;
        while (true) {
            int iTemp = iCurr + directionOffset[directId][0];
            int jTemp = jCurr + directionOffset[directId][1];
            if (iTemp < 0 || iTemp >= height || jTemp < 0 || jTemp >= width || maze[iTemp][jTemp] == 1) {
                break;
            }
            iCurr = iTemp;
            jCurr = jTemp;
        }
        if (iCurr == destX && jCurr == destY) return true;
        if (iCurr == i && jCurr == j) return false;

        if (!visited[iCurr][jCurr]) {
            visited[iCurr][jCurr] = true;
            if (directId == 0 || directId == 1) {
                return dfs(iCurr, jCurr, 2) || dfs(iCurr, jCurr, 3);
            } else {
                return dfs(iCurr, jCurr, 0) || dfs(iCurr, jCurr, 1);
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        int[] pStart = new int[]{0, 1};
        int[] pTarget = new int[]{0, 3};
        String str2dgrid = "00100,00000,00010,11011,00000";
        str2dgrid = "00000,11001,00000,01001,01000";
        str2dgrid = "00100";
        str2dgrid = "00100,00000,00010,11011,00000";
        str2dgrid = "01010000001,01011101100,10000000001,00011101001,11000100011,01000001010,00001001110";
        pStart = new int[]{5, 8};
        pTarget = new int[]{3, 8};
        int[][] input = Util.str2matrix(str2dgrid);
        TheMaze490_succ obj = new TheMaze490_succ();
        long start = System.currentTimeMillis();
        boolean b = obj.hasPath(input, pStart, pTarget);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}