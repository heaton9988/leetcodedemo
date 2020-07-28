import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort210_findOrder_dfs {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited;
    boolean[] visitedNow;
    List<List<Integer>> nextList = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        visitedNow = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) nextList.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            nextList.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[]{};
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }

    private boolean dfs(int course) {
        if (visitedNow[course]) {
            return false;
        }
        if (visited[course]) {
            return true;
        }
        visited[course] = true;
        visitedNow[course] = true;
        for (int next : nextList.get(course)) {
            if (!dfs(next)) return false;
        }
        visitedNow[course] = false;
        stack.push(course);
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TopologicalSort210_findOrder_dfs obj = new TopologicalSort210_findOrder_dfs();
        System.out.println(obj.findOrder(4, new int[][]{
                new int[]{1, 0}
                , new int[]{2, 0}
                , new int[]{3, 1}
                , new int[]{3, 2}
        }));
//        System.out.println(obj.findOrder(4, new int[][]{
//                new int[]{1, 0}
//                , new int[]{0, 1}
//        }));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}