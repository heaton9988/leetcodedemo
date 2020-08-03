import java.util.HashSet;

public class UnionFind261_validTree_2 {
    int count = 0;
    int n;
    HashSet<Integer>[] node2neighbours;

    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) return true;
        if (edges.length != n - 1) return false;
        this.n = n;
        node2neighbours = new HashSet[n];

        int[] indegrees = new int[n];
        for (int[] edge : edges) {
            indegrees[edge[0]]++;
            indegrees[edge[1]]++;
            if (node2neighbours[edge[0]] == null) node2neighbours[edge[0]] = new HashSet<>();
            node2neighbours[edge[0]].add(edge[1]);
            if (node2neighbours[edge[1]] == null) node2neighbours[edge[1]] = new HashSet<>();
            node2neighbours[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) return false;
        }
        dfs(0, new boolean[n]);
        return count == n;
    }

    private void dfs(int x, boolean[] visited) {
        if (count >= n) return;
        count++;
        HashSet<Integer> set = node2neighbours[x];
        if (set == null) return;
        for (Integer i : set) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind261_validTree_2 obj = new UnionFind261_validTree_2();
        System.out.println(obj.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}