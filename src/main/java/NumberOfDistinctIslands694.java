import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NumberOfDistinctIslands694 {
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

	public static void main(String[] args) {
		NumberOfDistinctIslands694 obj = new NumberOfDistinctIslands694();
		long start = System.currentTimeMillis();

		System.out.println(obj.numDistinctIslands(new int[][] {
				new int[] { 1, 1, 0, 1, 1 },
				new int[] { 1, 0, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 1 },
				new int[] { 1, 1, 0, 1, 1 }
		}));
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}