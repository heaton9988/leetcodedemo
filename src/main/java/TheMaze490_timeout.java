import util.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheMaze490_timeout {
    int[][] maze;
    int height, width;
    int destX, destY;
    Boolean hasPath = null;
    int[][] directionOffset = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}};
    Set<Integer> directions = new HashSet<>(Arrays.asList(0, 1, 2, 3));
    boolean[][] visited; // 往一个方向走到底的时候, 把这个底临时记录为 [ 访问过 ]

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) return false;
        this.maze = maze;
        this.height = maze.length;
        this.width = maze[0].length;
        this.destX = destination[0];
        this.destY = destination[1];
        this.visited = new boolean[height][width];

        dfs(start[0], start[1], null);
        return hasPath == null ? false : hasPath;
    }

    private void dfs(int i, int j, Integer lastDirection) {
        System.out.println("maze\n");
        Util.printArr(maze);
        System.out.println("visited\n");
        Util.printArr(visited);
        if (hasPath != null) return;

        visited[i][j] = true;

        for (int direction : directions) {
            if (lastDirection != null && lastDirection.equals(direction)) continue;
            int[] finalPoint = getFinalPointByDirection(i, j, direction);
            if (finalPoint != null) {
                if (finalPoint[0] == destX && finalPoint[1] == destY) {
                    hasPath = true;
                    return;
                } else {
                    dfs(finalPoint[0], finalPoint[1], direction);
                }
            }
        }

        visited[i][j] = false;
    }

    private int[] getFinalPointByDirection(int iStart, int jStart, int currDirection) {
        int iCurr = iStart, jCurr = jStart;
        while (true) {
            int iTemp = iCurr + directionOffset[currDirection][0];
            int jTemp = jCurr + directionOffset[currDirection][1];
            if (iTemp < 0 || iTemp >= height || jTemp < 0 || jTemp >= width) {
                break;
            } else if (visited[iTemp][jTemp]) {
                return null;
            } else if (maze[iTemp][jTemp] == 0) {
                iCurr = iTemp;
                jCurr = jTemp;
            } else {
                break;
            }
        }
        if (iStart == iCurr && jStart == jCurr) {
            return null;
        } else {
            return new int[]{iCurr, jCurr};
        }
    }

    public static void main(String[] args) throws Exception {
        int[] pStart = new int[]{0, 1};
        int[] pTarget = new int[]{0, 3};
        String str2dgrid = "00100,00000,00010,11011,00000";
        str2dgrid = "00000,11001,00000,01001,01000";
        str2dgrid = "00100";
        str2dgrid = "00100,00000,00010,11011,00000";
        pStart = new int[]{0, 4};
        pTarget = new int[]{1, 2};
        int[][] input = Util.str2matrix(str2dgrid);
        TheMaze490_timeout obj = new TheMaze490_timeout();
        long start = System.currentTimeMillis();
        boolean b = obj.hasPath(input, pStart, pTarget);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}