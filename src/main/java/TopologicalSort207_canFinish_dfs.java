import java.util.ArrayList;
import java.util.List;

public class TopologicalSort207_canFinish_dfs {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TopologicalSort207_canFinish_dfs obj = new TopologicalSort207_canFinish_dfs();
//        System.out.println(obj.canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
        System.out.println(obj.canFinish(2, new int[][]{new int[]{1, 0}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}