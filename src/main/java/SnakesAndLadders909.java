import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders909 {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;

        Map<Integer, Integer> dist = new HashMap();
        dist.put(1, 0);

        Queue<Integer> queue = new LinkedList();
        queue.add(1);

        while (!queue.isEmpty()) {
            int s = queue.remove();
            if (s == N * N) {
                return dist.get(s);
            }

            for (int s2 = s + 1; s2 <= Math.min(s + 6, N * N); ++s2) {
                int rc = get(s2, N);
                int r = rc / N, c = rc % N;
                int s2Final = board[r][c] == -1 ? s2 : board[r][c];
                if (!dist.containsKey(s2Final)) {
                    dist.put(s2Final, dist.get(s) + 1);
                    queue.add(s2Final);
                }
            }
        }
        return -1;
    }

    public int get(int s, int N) {
        // Given a square num s, return board coordinates (r, c) as r*N + c
        int quot = (s - 1) / N;
        int rem = (s - 1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
        return row * N + col;
    }


    public static void main(String[] args) {
//        int[][] prices = new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}};
        int[][] prices = new int[][]{
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, 35, -1, -1, 13, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, 15, -1, -1, -1, -1}};
        SnakesAndLadders909 obj = new SnakesAndLadders909();
        long start = System.currentTimeMillis();
        System.out.println(obj.snakesAndLadders(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}