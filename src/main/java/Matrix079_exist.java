public class Matrix079_exist {
    char[][] board;
    char[] cs;
    int rows, cols;
    boolean[][] visited;
    int wordLen;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.cs = word.toCharArray();
        wordLen = cs.length;
        rows = board.length;
        if (rows == 0) return false;
        cols = board[0].length;
        if (cols == 0) return false;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, int index) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) {
            return false;
        }
        if (cs[index] != board[i][j]) return false;
        if (index == wordLen - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean result = helper(i - 1, j, index + 1) || helper(i + 1, j, index + 1) || helper(i, j - 1, index + 1) || helper(i, j + 1, index + 1);
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        boolean result = new Matrix079_exist().exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCCE");
        System.out.println(result);
    }
}