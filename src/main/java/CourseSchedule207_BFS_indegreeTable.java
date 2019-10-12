import java.util.LinkedList;

public class CourseSchedule207_BFS_indegreeTable {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] end2start = new int[numCourses];
		for (int[] endAndStart : prerequisites) {
			end2start[endAndStart[0]]++;
		}
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (end2start[i] == 0) {
				queue.addLast(i);
			}
		}
		while (!queue.isEmpty()) {
			Integer removed = queue.removeFirst();
			numCourses--;
			for (int[] endAndStart : prerequisites) {
				if (endAndStart[1] == removed) {
					if (--end2start[endAndStart[0]] == 0) {
						queue.add(endAndStart[0]);
					}
				}
			}
		}
		return numCourses == 0;
	}

	public static void main(String[] args) {
		CourseSchedule207_BFS_indegreeTable obj = new CourseSchedule207_BFS_indegreeTable();
		long start = System.currentTimeMillis();
		System.out.println(obj.canFinish(3, new int[][] { new int[] { 1, 0 }, new int[] { 0, 2 } }));
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}