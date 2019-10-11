import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Dijkstra 在Leetcode上超时
 */
public class CutOffTree_Dijkstra {
    int lengthX;
    int lengthY;
    int[][] deltas = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.get(0).size() == 0) return -1;

        lengthX = forest.size();
        lengthY = forest.get(0).size();

        List<int[]> trees = new ArrayList<>(lengthX * lengthY);
        for (int x = 0; x < lengthX; x++) {
            for (int y = 0; y < lengthY; y++) {
                if (forest.get(x).get(y) > 1) {
                    trees.add(new int[]{forest.get(x).get(y), x, y});
                }
            }
        }

        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        int ret = 0;
        int currX = 0, currY = 0;
        for (int[] tree : trees) {
            int dist = dist(forest, currX, currY, tree[1], tree[2]);
            if (dist < 0) {
                return -1;
            } else {
                ret += dist;
                currX = tree[1];
                currY = tree[2];
            }
        }
        return ret;
    }

    private int dist(List<List<Integer>> forest, int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX == targetX && sourceY == targetY) {
            return 0;
        }
        if (lengthY == 0) {
            lengthX = forest.size();
            lengthY = forest.get(0).size();
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        q.add(new int[]{0, sourceX, sourceY});

        int[][] visited = new int[lengthX][lengthY];
        while (true) {
            int[] firstEle = q.poll();
            if (firstEle == null) {
                break;
            }
            int currX = firstEle[1];
            int currY = firstEle[2];
            visited[currX][currY] = 1;

            for (int[] delta : deltas) {
                int deltaX = currX + delta[0];
                int deltaY = currY + delta[1];
                if (deltaX >= 0 && deltaX < lengthX && deltaY >= 0 && deltaY < lengthY && visited[deltaX][deltaY] == 0 && forest.get(deltaX).get(deltaY) != 0) {
                    if (deltaX == targetX && deltaY == targetY) {
                        return 1 + firstEle[0];
                    }
                    q.add(new int[]{1 + firstEle[0], deltaX, deltaY});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(2, 3, 4), Arrays.asList(0, 0, 5), Arrays.asList(8, 7, 6));

        long start = System.currentTimeMillis();

//        int result = new CutOffTree_Dijkstra().dist(list, 0, 0, 2, 0);
        int result = new CutOffTree_Dijkstra().cutOffTree(list);
        System.out.println(result);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}