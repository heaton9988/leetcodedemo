import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals056 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;
        int len = intervals.length;
        if (len == 0 || intervals[0].length == 0) return new int[0][];
        if (len == 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return new Integer(o1[0]).compareTo(new Integer(o2[0]));
            }
        });

        LinkedList<int[]> retList = new LinkedList<>();
        for (int[] interval : intervals) {
            if (retList.isEmpty() || retList.getLast()[1] < interval[0]) {
                retList.add(interval);
            } else {
                int[] last = retList.getLast();
                retList.set(retList.size() - 1, new int[]{last[0], Math.max(last[1], interval[1])});
            }
        }
        int[][] ret = new int[retList.size()][2];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[][] prices = new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}};
        int[][] prices = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
        MergeIntervals056 obj = new MergeIntervals056();
        long start = System.currentTimeMillis();
        System.out.println(obj.merge(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}