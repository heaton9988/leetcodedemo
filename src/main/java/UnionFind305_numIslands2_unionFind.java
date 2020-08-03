import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UnionFind305_numIslands2_unionFind {
    int count = 0;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] parents = new int[m * n];
        Arrays.fill(parents, -1);
        int[] rank = new int[m * n];
        HashSet<Integer> prevIndexs = new HashSet<>();
        for (int[] pos : positions) {
            int i = pos[0], j = pos[1];
            int index = i * n + j;
            if (prevIndexs.contains(index)) {
                res.add(count);
                continue;
            }
            prevIndexs.add(index);

            parents[index] = index;
            count++;

            ArrayList<Integer> neighbours = new ArrayList<>();
            if (i >= 1 && parents[(i - 1) * n + j] != -1) {
                neighbours.add((i - 1) * n + j);
            }
            if (i + 1 < m && parents[(i + 1) * n + j] != -1) {
                neighbours.add((i + 1) * n + j);
            }
            if (j - 1 >= 0 && parents[i * n + j - 1] != -1) {
                neighbours.add(i * n + j - 1);
            }
            if (j + 1 < n && parents[i * n + j + 1] != -1) {
                neighbours.add(i * n + j + 1);
            }
            for (int neighbour : neighbours) {
                union(parents, index, neighbour, rank);
            }
            res.add(count);
        }
        return res;
    }

    private void union(int[] parents, int index, int neighbour, int[] rank) {
        int root1 = find(index, parents);
        int root2 = find(neighbour, parents);
        if (root1 != root2) {
            count--;
            if (rank[root1] < rank[root2]) {
                parents[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parents[root2] = root1;
            } else {
                parents[root1] = root2;
                rank[root2]++;
            }
        }
    }

    private int find(int index, int[] parents) {
        if (index != parents[index]) {
            parents[index] = find(parents[index], parents);
        }
        return parents[index];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind305_numIslands2_unionFind obj = new UnionFind305_numIslands2_unionFind();
        System.out.println(obj.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}