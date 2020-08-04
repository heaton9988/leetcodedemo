import java.util.Map;
import java.util.TreeMap;

public class Design362_HitCounter {
    TreeMap<Integer, Integer> map;

    public Design362_HitCounter() {
        map = new TreeMap<>();
    }

    public void hit(int timestamp) {
        Integer count = map.get(timestamp);
        if (count == null) {
            map.put(timestamp, 1);
        } else {
            map.put(timestamp, 1 + count);
        }
    }

    public int getHits(int timestamp) {
        int start = timestamp - 299;
        if (start < 0) start = 0;

        int sum = 0;
        while (true) {
//            System.out.println("start=" + start);
            Map.Entry<Integer, Integer> e = map.ceilingEntry(start);
            if (e == null) {
                break;
            }
            if (e.getKey() <= timestamp) {
                sum += e.getValue();
                start = e.getKey() + 1;
            } else {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Design362_HitCounter counter = new Design362_HitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        // 在时刻 4 统计过去 5 分钟内的敲击次数, 函数返回 3 。
        System.out.println(counter.getHits(4));
        // 在时刻 300 敲击一次。
        counter.hit(300);
        // 在时刻 300 统计过去 5 分钟内的敲击次数，函数返回 4 。
        System.out.println(counter.getHits(300));
        // 在时刻 301 统计过去 5 分钟内的敲击次数，函数返回 3 。
        System.out.println(counter.getHits(301));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}