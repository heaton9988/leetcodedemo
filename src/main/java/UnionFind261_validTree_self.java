public class UnionFind261_validTree_self {
    int[] parents;
    int count;

    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) return true;
        if (n - 1 != edges.length) return false;

        parents = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return count == 1;
    }

    private void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return;
        parents[rx] = parents[ry];
        count--;
    }

    private int find(int x) {
        while (x != parents[x]) {
            x = parents[x];
        }
        return x;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind261_validTree_self obj = new UnionFind261_validTree_self();
        System.out.println(obj.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}