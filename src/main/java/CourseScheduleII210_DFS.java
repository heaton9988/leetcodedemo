import util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII210_DFS {
	static int WHITE = 1;
	static int GRAY = 2;
	static int BLACK = 3;

	boolean isPossible;
	Map<Integer, Integer> color;
	Map<Integer, List<Integer>> node2neighbours;
	List<Integer> topologicalOrder;

	public int[] findOrder(int numCourses, int[][] prerequisites) { // O(N) O(N)
		this.init(numCourses);

		// Create the adjacency list representation of the graph
		for (int i = 0; i < prerequisites.length; i++) {
			int end = prerequisites[i][0];
			int start = prerequisites[i][1];
			List<Integer> lst = node2neighbours.getOrDefault(start, new ArrayList<Integer>());
			lst.add(end);
			node2neighbours.put(start, lst);
		}

		// If the node is unprocessed, then call dfs on it.
		for (int i = 0; i < numCourses; i++) {
			if (this.color.get(i) == WHITE) {
				this.dfs(i);
			}
		}

		int[] order;
		if (this.isPossible) {
			order = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				order[i] = this.topologicalOrder.get(numCourses - i - 1);
			}
		} else {
			order = new int[0];
		}

		return order;
	}

	private void init(int numCourses) {
		this.isPossible = true;
		this.color = new HashMap<Integer, Integer>();
		this.node2neighbours = new HashMap<Integer, List<Integer>>();
		this.topologicalOrder = new ArrayList<Integer>();

		// By default all vertces are WHITE
		for (int i = 0; i < numCourses; i++) {
			this.color.put(i, WHITE);
		}
	}

	private void dfs(int node) {
		// Don't recurse further if we found a cycle already
		if (!this.isPossible) {
			return;
		}

		// Start the recursion
		this.color.put(node, GRAY);

		// Traverse on nei***oring vertices
		for (Integer neior : this.node2neighbours.getOrDefault(node, new ArrayList<Integer>())) {
			if (this.color.get(neior) == WHITE) {
				this.dfs(neior);
			} else if (this.color.get(neior) == GRAY) {
				// An edge to a GRAY vertex represents a cycle
				this.isPossible = false;
			}
		}

		// Recursion ends. We mark it as black
		this.color.put(node, BLACK);
		this.topologicalOrder.add(node);
	}

	public static void main(String[] args) {
		CourseScheduleII210_DFS obj = new CourseScheduleII210_DFS();
		long start = System.currentTimeMillis();
		Util.printArr(obj.findOrder(4, new int[][] { new int[] { 1, 0 }, new int[] { 2, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 } }));
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}