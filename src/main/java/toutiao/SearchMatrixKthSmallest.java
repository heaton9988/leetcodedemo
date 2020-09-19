package toutiao;

import java.util.PriorityQueue;

public class SearchMatrixKthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) pq.add(new int[]{matrix[i][0], i, 0});

        int count = 0;
        while (k > 0) {
            int[] ele = pq.poll();
            count++;
            if (count == k) return ele[0];
            if (ele[2] >= N-1) continue;
            pq.add(new int[]{matrix[ele[1]][ele[2] + 1], ele[1], ele[2] + 1});
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{1, 4, 7, 11, 15}
                , new int[]{2, 7, 8, 12, 19}
                , new int[]{3, 6, 9, 16, 22}
                , new int[]{10, 13, 14, 17, 24}
                , new int[]{18, 21, 23, 26, 30}
        };
        for (int i = 1; i < arr1.length * arr1[0].length; i++) {
            int result = new SearchMatrixKthSmallest().kthSmallest(arr1, i);
            System.out.println(i + " " + result);
        }
    }
}