import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class NumberOfDistinctIslands694 {
    int height, width;

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        this.height = grid.length;
        this.width = grid[0].length;
        HashSet set = new HashSet();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ArrayList<String> list = new ArrayList<>();
                dfs(grid, i, j, i, j, list);
                if (list.size() > 0) {
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, int startI, int startJ, ArrayList<String> list) {
        if (i < 0 || i >= height || j < 0 || j >= width || grid[i][j] == 0) return;
        list.add((i - startI) + "," + (j - startJ));
        grid[i][j] = 0;
        dfs(grid, i - 1, j, startI, startJ, list);
        dfs(grid, i + 1, j, startI, startJ, list);
        dfs(grid, i, j - 1, startI, startJ, list);
        dfs(grid, i, j + 1, startI, startJ, list);
    }

    public static void main(String[] args) {
//        ArrayList<String> list1 = new ArrayList<>();
//        list1.add("1,1");
//        list1.add("1,1");
//        ArrayList<String> list2 = new ArrayList<>();
//        list2.add("1,1");
//        list2.add("1,1");
//
//        HashSet set = new HashSet();
//        set.add(list1);
//        set.add(list2);

        String str2dgrid = "11000,11000,00011,00011";
        str2dgrid = "11011,10000,00001,11011";
        int[][] input = Util.str2matrix(str2dgrid);
        NumberOfDistinctIslands694 obj = new NumberOfDistinctIslands694();
        long start = System.currentTimeMillis();
        int i = obj.numDistinctIslands(input);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}