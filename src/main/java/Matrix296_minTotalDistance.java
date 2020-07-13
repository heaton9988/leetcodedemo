import java.util.PriorityQueue;

public class Matrix296_minTotalDistance {
    private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minTotalDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] cache = new int[rows][cols][4];
        int player = 0;
        PriorityQueue<int[]> queue = new PriorityQueue();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    player++;
                    cache[i][j] = new int[]{i, j, 0, 1};
                    queue.add(cache[i][j]);
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] arr = queue.poll();
                int i = arr[0], j = arr[1], preStep = arr[2], countPlayers = arr[3];

                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[j];
                    if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
                    if (cache[x][y] == null) {
                        cache[x][y] = new int[]{x, y, preStep + 1, countPlayers};
                        queue.offer(cache[x][y]);
                    } else {

//                        cache[x][y][]
                    }
                }
            }
        }

        int res = 0;
        return res;
    }

    public static void main(String[] args) {
        Object a = new Matrix296_minTotalDistance().minTotalDistance(new int[][]{
                new int[]{1, 0, 0, 0, 1},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0}
        });
        System.out.println(a);
    }
}