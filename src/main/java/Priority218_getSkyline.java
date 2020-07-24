import java.util.ArrayList;
import java.util.List;

public class Priority218_getSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<>();
        }
        return merge(buildings, 0, buildings.length - 1);
    }

    private List<List<Integer>> merge(int[][] buildings, int start, int end) {

        List<List<Integer>> res = new ArrayList<>();
        //只有一个建筑, 将 [x, h], [y, 0] 加入结果
        if (start == end) {
            List<Integer> temp = new ArrayList<>();
            temp.add(buildings[start][0]);
            temp.add(buildings[start][2]);
            res.add(temp);

            temp = new ArrayList<>();
            temp.add(buildings[start][1]);
            temp.add(00);
            res.add(temp);
            return res;
        }
        int mid = (start + end) >>> 1;
        //第一组解
        List<List<Integer>> Skyline1 = merge(buildings, start, mid);
        //第二组解
        List<List<Integer>> Skyline2 = merge(buildings, mid + 1, end);
        //下边将两组解合并
        int h1 = 0;
        int h2 = 0;
        int i = 0;
        int j = 0;
        while (i < Skyline1.size() || j < Skyline2.size()) {
            long x1 = i < Skyline1.size() ? Skyline1.get(i).get(0) : Long.MAX_VALUE;
            long x2 = j < Skyline2.size() ? Skyline2.get(j).get(0) : Long.MAX_VALUE;
            long x = 0;
            //比较两个坐标
            if (x1 < x2) {
                h1 = Skyline1.get(i).get(1);
                x = x1;
                i++;
            } else if (x1 > x2) {
                h2 = Skyline2.get(j).get(1);
                x = x2;
                j++;
            } else {
                h1 = Skyline1.get(i).get(1);
                h2 = Skyline2.get(j).get(1);
                x = x1;
                i++;
                j++;
            }
            //更新 height
            int height = Math.max(h1, h2);
            //重复的解不要加入
            if (res.isEmpty() || height != res.get(res.size() - 1).get(1)) {
                List<Integer> temp = new ArrayList<>();
                temp.add((int) x);
                temp.add(height);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Priority218_getSkyline obj = new Priority218_getSkyline();
        long start = System.currentTimeMillis();
        int[][] param = new int[][]{
                new int[]{2, 9, 10}
                , new int[]{3, 7, 15}
                , new int[]{5, 12, 12}
                , new int[]{15, 20, 10}
                , new int[]{19, 24, 8}
        };
        Object o = obj.getSkyline(param);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}