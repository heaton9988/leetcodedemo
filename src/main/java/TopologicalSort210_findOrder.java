import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort210_findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int dataIndex = 0;
        int[] indegrees = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) list.add(new ArrayList<>());
        for (int[] arr : prerequisites) {
            indegrees[arr[0]]++;
            list.get(arr[1]).add(arr[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[dataIndex++] = curr;
            for (int next : list.get(curr)) {
                if (--indegrees[next] == 0) {
                    queue.addLast(next);
                }
            }
        }
        if (dataIndex == numCourses) {
            return res;
        } else {
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TopologicalSort210_findOrder obj = new TopologicalSort210_findOrder();
        System.out.println(obj.findOrder(4, new int[][]{
                new int[]{1, 0}
                , new int[]{2, 0}
                , new int[]{3, 1}
                , new int[]{3, 2}
        }));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}