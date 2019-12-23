import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public int numDistinctIslands(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		HashSet<List<Integer>> islandSet = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					List<Integer> island = new LinkedList<>();
					dfs(grid, island, i, j, i, j);
					islandSet.add(island);
				}
			}
		}

		return islandSet.size();

	}

	public void dfs(int[][] grid, List<Integer> island, int i, int j, int ii, int jj) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
			return;
		grid[i][j] = 0;
		island.add(i - ii);
		island.add(j - jj);
		dfs(grid, island, i - 1, j, ii, jj);
		dfs(grid, island, i + 1, j, ii, jj);
		dfs(grid, island, i, j - 1, ii, jj);
		dfs(grid, island, i, j + 1, ii, jj);
	}

	int minStep = Integer.MAX_VALUE;

	private void _dfs(int numRows, int numColumns, int[][] lot, int i, int j, int count) {
		if (i < 0 || i >= numRows || j < 0 || j >= numColumns || lot[i][j] == 0) {
			return;
		}
		if (lot[i][j] == 9) {
			if (count < minStep) {
				minStep = count;
				return;
			}
		} else if (lot[i][j] == 1) {
			lot[i][j] = 0;
		}
		_dfs(numRows, numColumns, lot, i - 1, j, count + 1);
		_dfs(numRows, numColumns, lot, i + 1, j, count + 1);
		_dfs(numRows, numColumns, lot, i, j - 1, count + 1);
		_dfs(numRows, numColumns, lot, i, j + 1, count + 1);
	}

	public int removeObstacle(int numRows, int numColumns, int[][] lot) {
		_dfs(numRows, numColumns, lot, 0, 0, 0);
		return minStep == Integer.MAX_VALUE ? -1 : minStep;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		long start = System.currentTimeMillis();

		int i = obj.removeObstacle(5, 4, new int[][] {
				new int[] { 1, 1, 1, 1 },
				new int[] { 0, 1, 1, 1 },
				new int[] { 0, 1, 0, 1 },
				new int[] { 1, 1, 9, 1 },
				new int[] { 0, 0, 1, 1 }
		});
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}