import util.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheMaze490_answer {
    int[][] directions;
    boolean[][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited = new boolean[maze.length][maze[0].length];
        for (int i = 0; i < 4; i++)
            if (dfs(maze, start[0], start[1], destination, i)) return true;

        return false;
    }

    public boolean dfs(int[][] maze, int x, int y, int[] dest, int dIdx) {
        int next_x = x + directions[dIdx][0];
        int next_y = y + directions[dIdx][1];
        // cannot move in this direction
        if (next_x < 0 || next_x > maze.length - 1 || next_y < 0 || next_y > maze[0].length - 1 || maze[next_x][next_y] == 1)
            return false;

        while (next_x >= 0 && next_x <= maze.length - 1 && next_y >= 0 && next_y <= maze[0].length - 1 && maze[next_x][next_y] == 0) {
            x = next_x;
            y = next_y;
            next_x = x + directions[dIdx][0];
            next_y = y + directions[dIdx][1];
        }
        //ball stop at {x,y}
        if (x == dest[0] && y == dest[1]) return true;
        if (!visited[x][y]) {
            visited[x][y] = true;
            //change direction
            if (dIdx == 0 || dIdx == 1) {
                if (dfs(maze, x, y, dest, 2) || dfs(maze, x, y, dest, 3)) return true;
            } else {
                if (dfs(maze, x, y, dest, 0) || dfs(maze, x, y, dest, 1)) return true;
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
        pStart = new int[]{0, 4};
        pTarget = new int[]{1, 2};
        int[][] input = Util.str2matrix(str2dgrid);
        TheMaze490_answer obj = new TheMaze490_answer();
        long start = System.currentTimeMillis();
        boolean b = obj.hasPath(input, pStart, pTarget);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}