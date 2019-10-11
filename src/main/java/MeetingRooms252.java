import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return new Integer(o1[0]).compareTo(new Integer(o2[0]));
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{new int[]{5, 10}, new int[]{0, 30}, new int[]{15, 20}};
        MeetingRooms252 obj = new MeetingRooms252();
        long start = System.currentTimeMillis();
        System.out.println(obj.canAttendMeetings(intervals));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}