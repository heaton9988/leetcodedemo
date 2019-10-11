import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        q.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] peek = q.peek();
            if (peek[1] <= intervals[i][0]) {
                q.poll();
            }
            q.add(intervals[i]);
        }
        return q.size();
    }

    public static void main(String[] args) {
//        int[][] prices = new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}};
        int[][] prices = new int[][]{new int[]{5, 8}, new int[]{6, 8}};
        MinMeetingRooms253 obj = new MinMeetingRooms253();
        long start = System.currentTimeMillis();
        System.out.println(obj.minMeetingRooms(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}