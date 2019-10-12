import util.Util;

import java.util.*;

public class CourseScheduleII210_BFS_indegree {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
//		boolean isPossible = true;
		Map<Integer, List<Integer>> node2neighborList = new HashMap<>();
		int[] indegree = new int[numCourses];
		int[] topologicalOrder = new int[numCourses];

		// Create the adjacency list representation of the graph
		for (int i = 0; i < prerequisites.length; i++) {
			int end = prerequisites[i][0];
			int start = prerequisites[i][1];
			List<Integer> neighborList = node2neighborList.getOrDefault(start, new ArrayList<Integer>());
			neighborList.add(end);
			node2neighborList.put(start, neighborList);

			// Record in-degree of each vertex
			indegree[end] += 1;
		}

		// Add all vertices with 0 in-degree to the queue
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int resultIndex = 0;
		// Process until the Q becomes empty
		while (!q.isEmpty()) {
			int node = q.remove();
			topologicalOrder[resultIndex++] = node;

			// Reduce the in-degree of each neighbor by 1
			if (node2neighborList.containsKey(node)) {
				for (Integer neighbor : node2neighborList.get(node)) {
					indegree[neighbor]--;

					// If in-degree of a neighbor becomes 0, add it to the Q
					if (indegree[neighbor] == 0) {
						q.add(neighbor);
					}
				}
			}
		}

		// Check to see if topological sort is possible or not.
		if (resultIndex == numCourses) {
			return topologicalOrder;
		}

		return new int[0];
	}

	public static void main(String[] args) {
		CourseScheduleII210_BFS_indegree obj = new CourseScheduleII210_BFS_indegree();
		long start = System.currentTimeMillis();
		Util.printArr(obj.findOrder(4, new int[][] { new int[] { 1, 0 }, new int[] { 2, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 } }));
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}