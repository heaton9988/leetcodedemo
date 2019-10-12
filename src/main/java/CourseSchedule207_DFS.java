public class CourseSchedule207_DFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] adjacency = new int[numCourses][numCourses];
		// 0: never be visited
		// 1: be visited by current dfs operation
		// -1: be visited by last dfs operation
		int[] visited = new int[numCourses];
		for (int[] endAndStart : prerequisites)
			adjacency[endAndStart[1]][endAndStart[0]] = 1;
		// 对每个course调用一下dfs, 如果有环, 返回false
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(adjacency, visited, i))
				return false;
		}
		return true;
	}

	private boolean dfs(int[][] adjacency, int[] visited, int course) {
		if (visited[course] == 1) // has loop
			return false;
		if (visited[course] == -1) // has been judged by last dfs operation, it is not in loop
			return true;
		visited[course] = 1;
		for (int j = 0; j < adjacency.length; j++) {
			if (adjacency[course][j] == 1 && !dfs(adjacency, visited, j))
				return false;
		}
		visited[course] = -1;
		return true;
	}

	public static void main(String[] args) {
		CourseSchedule207_DFS obj = new CourseSchedule207_DFS();
		long start = System.currentTimeMillis();
		System.out.println(obj.canFinish(3, new int[][] { new int[] { 1, 0 }, new int[] { 0, 2 } }));
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}