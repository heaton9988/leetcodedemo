public class UnionFind261_validTree {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) return true;
        if (edges.length != n - 1) return false;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int component = n;
        for (int[] e : edges) {
            int p1 = find(parent, e[0]), p2 = find(parent, e[1]);
            if (p1 == p2) {
                return false; // tree: between every pair exists only one path!
            }
            parent[p1] = p2;
            component--; // connect two components, count decrements
        }

        return component == 1;
    }

    private int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind261_validTree obj = new UnionFind261_validTree();
        System.out.println(obj.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}