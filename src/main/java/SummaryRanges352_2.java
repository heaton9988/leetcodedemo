import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges352_2 {
    private TreeMap<Integer, Integer> l2r;
    private TreeMap<Integer, Integer> r2l;

    public SummaryRanges352_2() {
        l2r = new TreeMap<>();
        r2l = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> alreadyEntry = l2r.floorEntry(val);
        if (alreadyEntry != null && alreadyEntry.getKey() <= val && alreadyEntry.getValue() >= val) {
            return;
        }
        Map.Entry<Integer, Integer> lowerEntry = r2l.lowerEntry(val);
        Map.Entry<Integer, Integer> higherEntry = l2r.higherEntry(val);
        if (l2r.size() != 0) {
            int lowL = -2, lowR = -2, highL = -2, highR = -2;
            if (lowerEntry != null) {
                lowL = lowerEntry.getValue();
                lowR = lowerEntry.getKey();
            }
            if (higherEntry != null) {
                highL = higherEntry.getKey();
                highR = higherEntry.getValue();
            }
            if (val == lowR + 1 && val == highL - 1) {
                r2l.remove(lowR);
                l2r.remove(lowL);
                r2l.remove(highR);
                l2r.remove(highL);
                r2l.put(highR, lowL);
                l2r.put(lowL, highR);
            } else if (val == lowR + 1) {
                r2l.remove(lowR);
                l2r.remove(lowL);
                r2l.put(val, lowL);
                l2r.put(lowL, val);
            } else if (val == highL - 1) {
                r2l.remove(highR);
                l2r.remove(highL);
                r2l.put(highR, val);
                l2r.put(val, highR);
            } else {
                l2r.put(val, val);
                r2l.put(val, val);
            }
        } else {
            l2r.put(val, val);
            r2l.put(val, val);
        }
        System.out.println();
    }

    public int[][] getIntervals() {
        int[][] res = new int[l2r.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : l2r.entrySet()) {
            res[i++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return res;
    }

    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(val);
     * int[][] param_2 = obj.getIntervals();
     */
    public static void main(String[] args) {
//        TreeMap map = new TreeMap();
//        map.put(1, 1);
//        map.put(2, 2);
//        map.put(10, 10);
//        Map.Entry entry1 = map.floorEntry(2);
//        Map.Entry entry = map.ceilingEntry(2);
        long start = System.currentTimeMillis();
        SummaryRanges352_2 obj = new SummaryRanges352_2();
        obj.addNum(6);
        obj.addNum(6);
        obj.addNum(0);
        obj.addNum(4);
        obj.addNum(8);
        obj.addNum(7);
        obj.addNum(6);
        obj.addNum(4);
        obj.addNum(7);
        obj.addNum(5);
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