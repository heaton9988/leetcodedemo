import java.util.Arrays;

public class UnionFind261_validTree_unionFind {
    public boolean validTree(int n, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            if (!disjointSet.union(edge[0], edge[1]))
                return false;
        }
        return disjointSet.getCount() == 1;
    }

    //并查集
    class DisjointSet {
        int n;
        int[] parent;
        int[] rank;
        int count; //连同分量

        DisjointSet(int n) {
            this.n = n;
            this.parent = new int[n];
            Arrays.fill(parent, -1);
            this.rank = new int[n];
            this.count = n;
        }

        //寻找父节点
        private int findRoot(int x) {
            while (parent[x] != -1) {
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            //如果两个在同一颗树上，直接返回false
            if (xRoot == yRoot) {
                return false;
            }
            //压缩路径
            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] == rank[yRoot]) {
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }
            count--;
            return true;
        }

        public int getCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind261_validTree_unionFind obj = new UnionFind261_validTree_unionFind();
        System.out.println(obj.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}