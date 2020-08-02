import java.util.LinkedList;
import java.util.Queue;

public class UnionFind261_validTree_bfs {
    public boolean validTree(int n, int[][] edges) {
        //构建邻接矩阵
        int[][] graph = new int[n][n];
        //有边的元素设置为1，没有边的元素设置为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        //进行BFS
        Queue<Integer> queue = new LinkedList<>();
        //从第一个节点开始搜索，这样就不会漏掉无边图的情况
        queue.add(0);
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            visited[cur] = true;
            //获取邻接点
            for (int i = 0; i < n; i++) {
                //查看当前节点的邻接点
                if (graph[cur][i] == 1) {
                    //如果访问过，则返回false
                    if (visited[i])
                        return false;

                    //标记邻接点，入队列
                    visited[i] = true;
                    //涂黑访问过的节点
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    queue.add(i);
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
        UnionFind261_validTree_bfs obj = new UnionFind261_validTree_bfs();
        System.out.println(obj.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}