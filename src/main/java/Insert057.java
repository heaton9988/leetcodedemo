import java.util.ArrayList;
import java.util.List;

public class Insert057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        List<int[]> resList = new ArrayList<>();

        int l = 0, r = 0;
        while (l < intervals.length && r < 1) {
            int resSize = resList.size();
            int[] last = resSize == 0 ? null : resList.get(resList.size() - 1);
            if (intervals[l][0] <= newInterval[0]) {
                if (last == null || last[1] < intervals[l][0]) {
                    resList.add(intervals[l]);
                } else if (last[1] >= intervals[l][0]) {
                    last[1] = Math.max(last[1], intervals[l][1]);
                }
                l++;
            } else {
                if (last == null || last[1] < newInterval[0]) {
                    resList.add(newInterval);
                } else {
                    last[1] = Math.max(last[1], newInterval[1]);
                }
                r++;
            }
        }
        while (l < intervals.length) {
            int resSize = resList.size();
            int[] last = resSize == 0 ? null : resList.get(resList.size() - 1);
            if (last == null || last[1] < intervals[l][0]) {
                resList.add(intervals[l]);
            } else if (last[1] >= intervals[l][0]) {
                last[1] = Math.max(last[1], intervals[l][1]);
            }
            l++;
        }
        while (r < 1) {
            int resSize = resList.size();
            int[] last = resSize == 0 ? null : resList.get(resList.size() - 1);
            if (last == null || last[1] < newInterval[0]) {
                resList.add(newInterval);
            } else {
                last[1] = Math.max(last[1], newInterval[1]);
            }
            r++;
        }

        int[][] res = new int[resList.size()][];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        Insert057 obj = new Insert057();
        long start = System.currentTimeMillis();
        obj.insert(new int[][]{
                new int[]{1, 5}
        }, new int[]{2, 7});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}