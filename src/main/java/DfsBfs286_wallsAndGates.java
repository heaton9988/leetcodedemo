import java.util.LinkedList;

public class DfsBfs286_wallsAndGates {
    int[][] rooms;
    int rows, cols;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        rows = rooms.length;
        if (rows == 0) return;
        cols = rooms[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    bfs(i, j, new boolean[rows][cols]);
                }
            }
        }
    }

    private void bfs(int i, int j, boolean[][] visited) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{i, j});
        visited[i][j] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int a = 0; a < size; a++) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                for (int[] direct : directions) {
                    int nextX = x + direct[0], nextY = y + direct[1];
                    if (nextX < 0 || nextY < 0 || nextX >= rows || nextY >= cols
                            || rooms[nextX][nextY] == 0 || rooms[nextX][nextY] == -1 || visited[nextX][nextY]) {
                        continue;
                    }
                    rooms[nextX][nextY] = Math.min(rooms[nextX][nextY], step);
                    queue.addLast(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] param = new int[][]{
                new int[]{m, -1, 0, m}
                , new int[]{m, m, m, -1}
                , new int[]{m, -1, m, -1}
                , new int[]{0, -1, m, m}
        };
        new DfsBfs286_wallsAndGates().wallsAndGates(param);
        System.out.println();
    }
}