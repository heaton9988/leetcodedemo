import java.util.PriorityQueue;

public class Matrix378_kthSmallest_pq {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int size = n * n;
        int res = 0;
        if (k <= size / 2) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            for (int i = 0; i < n; i++) {
                queue.add(new int[]{matrix[i][0], i, 0});
            }
            for (int i = 0; i < k; i++) {
                int[] min = queue.poll();
                res = min[0];
                if (min[2] + 1 < n) {
                    queue.offer(new int[]{matrix[min[1]][min[2] + 1], min[1], min[2] + 1});
                }
            }
        } else {
            k = size + 1 - k;
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int i = 0; i < n; i++) {
                queue.add(new int[]{matrix[i][n - 1], i, n - 1});
            }
            for (int i = 0; i < k; i++) {
                int[] max = queue.poll();
                res = max[0];
                if (max[2] - 1 >= 0) {
                    queue.offer(new int[]{matrix[max[1]][max[2] - 1], max[1], max[2] - 1});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{1, 3, 5, 7}
                , new int[]{10, 11, 16, 20}
                , new int[]{23, 30, 34, 50}
        };
        System.out.println(new Matrix378_kthSmallest_pq().kthSmallest(arr1, 5));
    }
}