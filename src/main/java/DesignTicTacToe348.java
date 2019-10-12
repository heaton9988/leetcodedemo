public class DesignTicTacToe348 {
	int[] judge;//用于判断当前玩家是否胜利，0~n-1行，n~2*n-1列，2*n主对角线，2*n+1副对角线
	boolean[][] isFull;//判断当前位置是否已经下过棋
	boolean hasRes;//是否已经分出胜负
	int n;

	/** Initialize your data structure here. */
	public DesignTicTacToe348(int n) {
		judge = new int[2 * n + 2];
		isFull = new boolean[n][n];
		this.n = n;
	}

	/** Player {player} makes a move at ({row}, {col}).
	 @param row The row of the board.
	 @param col The column of the board.
	 @param player The player, can be either 1 or 2.
	 @return The current winning condition, can be either:
	 0: No one wins.
	 1: Player 1 wins.
	 2: Player 2 wins. */
	public int move(int row, int col, int player) {
		if (row >= n || col >= n) {
			hasRes = true;
			return 0;
		}
		if (hasRes || isFull[row][col])
			return 0;
		int add = player == 1 ? 1 : -1;//增量，玩家1增加1，玩家2增量为负
		isFull[row][col] = true;
		int target = player == 1 ? n : -n;//达到n玩家1胜，达到-n玩家2胜
		judge[row] += add;
		judge[col + n] += add;
		if (judge[row] == target || judge[col + n] == target) {
			hasRes = true;
			return player;
		}
		if (row == col) {//主对角线
			judge[judge.length - 2] += add;
			if (judge[judge.length - 2] == target) {
				hasRes = true;
				return player;
			}
		}
		if (row + col == n - 1) {//副对角线
			judge[judge.length - 1] += add;
			if (judge[judge.length - 1] == target) {
				hasRes = true;
				return player;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		DesignTicTacToe348 obj = new DesignTicTacToe348(3);
		long start = System.currentTimeMillis();
		obj.move(0, 0, 1);
		obj.move(0, 1, 1);
		obj.move(0, 2, 1);
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}