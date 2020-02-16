package zongjie1;

import java.util.Arrays;

public class MinMeetingRooms253 {
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int end = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] param = new int[][]{
                {1, 5},
                {1, 5},
                {11, 51},
                {11, 51}
        };
        Object o = new MinMeetingRooms253().minMeetingRooms(param);
        System.out.println(o);
    }
}
