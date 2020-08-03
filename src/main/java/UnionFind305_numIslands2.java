import java.util.*;

public class UnionFind305_numIslands2 {
    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();

        int[] parents = new int[m * n];
        Arrays.fill(parents, -1);

        HashMap<Integer, HashSet> root2childs = new HashMap<>();

        for (int[] position : positions) {
            int x1 = position[0], y1 = position[1];
            int index1 = getIndex(n, x1, y1);
            parents[index1] = index1;
            HashSet<Integer> childIndexs = root2childs.computeIfAbsent(index1, k -> new HashSet());
            childIndexs.add(index1);
            for (int[] direct : directions) {
                int x2 = x1 + direct[0], y2 = y1 + direct[1];
                int index2 = getIndex(n, x2, y2);
                if (parents[index2] != -1) {
                    if (parents[index1] == index1) { // 上下左右遍历过程中, 遇到的第一个可连通的index2
                        parents[index1] = parents[index2];
                        childIndexs.remove(index1);
                        childIndexs.add(parents[index2]);
                    } else {
                        // todo
                    }
                }
            }
        }
        return res;
    }

    private void union() {

    }

    private int getIndex(int cols, int i, int j) {
        return cols * i + j;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind305_numIslands2 obj = new UnionFind305_numIslands2();
        System.out.println(obj.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}