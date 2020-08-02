import java.util.Stack;

public class UnionFind261_validTree_dfs {
    public boolean validTree(int n, int[][] edges) {
        //构建邻接矩阵
        int[][] graph = new int[n][n];
        //有边的元素设置为1，没有边的元素设置为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        //进行DFS
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        boolean[] visited = new boolean[n];
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            visited[cur] = true;
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1) {
                    if (visited[i]) return false;

                    visited[i] = true;
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    stack.add(i);
                }
            }
        }
        //判断是否为单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind261_validTree_dfs obj = new UnionFind261_validTree_dfs();
        System.out.println(obj.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}