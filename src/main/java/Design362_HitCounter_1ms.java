import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Design362_HitCounter_1ms {
    private static final int M = 300;
    private int sum;
    private LinkedList<Node> list;

    private class Node {
        int t;
        int cnt;

        Node(int t) {
            this.t = t;
            this.cnt = 1;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Design362_HitCounter_1ms() {
        this.sum = 0;
        this.list = new LinkedList<Node>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        while (!list.isEmpty() && list.peekFirst().t <= timestamp - M) {
            sum -= list.removeFirst().cnt;
        }
        if (!list.isEmpty() && list.peekLast().t == timestamp) {
            list.peekLast().cnt++;
        } else {
            list.addLast(new Node(timestamp));
        }
        sum++;
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (!list.isEmpty() && list.peekFirst().t <= timestamp - M) {
            sum -= list.removeFirst().cnt;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Design362_HitCounter_1ms counter = new Design362_HitCounter_1ms();

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