import util.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheMaze490_2 {
    int[][] maze;
    int height;
    int width;
    int destX;
    int destY;
    Boolean hasPath = null;
    Set<Integer> directions = new HashSet<>(Arrays.asList(0, 1, 2, 3));
    int[][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) return false;
        this.maze = maze;
        this.height = maze.length;
        this.width = maze[0].length;
        this.destX = destination[0];
        this.destY = destination[1];
        this.visited = new int[height][width];

        int currDirection = 0; // 0 right   1 down   2 left   3 up
        dfs(start[0], start[1], currDirection);
        return hasPath == null ? false : hasPath;
    }

    private int[] getNextPoint(int i, int j, int currDirection) {
        currDirection = currDirection % 4;
        if (currDirection == 0) {
            j++;
        } else if (currDirection == 1) {
            i++;
        } else if (currDirection == 2) {
            j--;
        } else if (currDirection == 3) {
            i--;
        }
        return new int[]{i, j};
    }

    private void dfs(int i, int j, int currDirection) {
        System.out.println();
        Util.printArr(maze);
        if (hasPath != null) return;

        maze[i][j] = 1;

        int[] nextPoint = getNextPoint(i, j, currDirection);
        int nextX = nextPoint[0], nextY = nextPoint[1];

        boolean outOfRange = nextX < 0 || nextY < 0 || nextX >= height || nextY >= width;
        if (!outOfRange && maze[nextX][nextY] == 0) { // 可以按照当前方向继续往后走一步
            if (i == destX && j == destY) {
                hasPath = false;
                return;
            } else {
                dfs(nextX, nextY, currDirection);
            }
        } else {
            if (i == destX && j == destY) {
                hasPath = true;
                return;
            }
        }
        for (int direction : directions) {
            if (direction == currDirection) continue;
            nextPoint = getNextPoint(i, j, direction);
            nextX = nextPoint[0];
            nextY = nextPoint[1];
            outOfRange = nextX < 0 || nextY < 0 || nextX >= height || nextY >= width;
            if (!outOfRange && maze[nextX][nextY] == 0) { // 可以按照当前方向继续往后走一步
                dfs(nextX, nextY, direction);
            }
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
        TheMaze490_2 obj = new TheMaze490_2();
        long start = System.currentTimeMillis();
        boolean b = obj.hasPath(input, pStart, pTarget);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}