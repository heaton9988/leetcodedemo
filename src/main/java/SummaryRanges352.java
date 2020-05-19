import java.util.ArrayList;
import java.util.List;

public class SummaryRanges352 {
    private List<int[]> list;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges352() {
        this.list = new ArrayList<>();
    }

    public void addNum(int val) {
        if (list.isEmpty()) {
            addNum(val, 0);
        } else {
            //判断val是否在某区间内
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int[] area = list.get(i);
                if (val >= area[0] && val <= area[1]) {
                    //val在某区间内，直接退出
                    return;
                } else if (val < area[0]) {
                    //添加到当前区间前面
                    addNum(val, i);
                    return;
                }
            }
            //添加到最后
            addNum(val, size);
        }
    }

    private void addNum(int val, int index) {
        //检查能否与前面的区间合并
        boolean left = index != 0 && list.get(index - 1)[1] + 1 == val;
        //检查能否与后面的区间合并
        boolean right = index < list.size() && list.get(index)[0] - 1 == val;
        if (left && right) {
            int[] pre = list.remove(index - 1);
            list.get(index - 1)[0] = pre[0];
        } else if (left) {
            list.get(index - 1)[1] = val;
        } else if (right) {
            list.get(index)[0] = val;
        }else {
            list.add(index, new int[]{val, val});
        }

    }

    public int[][] getIntervals() {
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(val);
     * int[][] param_2 = obj.getIntervals();
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SummaryRanges352 obj = new SummaryRanges352();
        obj.addNum(20);
        obj.addNum(15);
        obj.addNum(16);
        obj.addNum(19);
        obj.addNum(18);
        obj.addNum(17);
        int[][] param_2 = obj.getIntervals();
        for (int[] arr : param_2) {
            for (int a : arr) {
                System.out.print(a + " ~ ");
            }
            System.out.println();
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}