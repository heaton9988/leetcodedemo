import java.util.Deque;
import java.util.LinkedList;

public class Design346_MovingAverage {
    Deque<Integer> queue;
    int size;
    int sum;

    public Design346_MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        sum += val;
        queue.offerLast(val);
        if (queue.size() > size) {
            sum -= queue.pollFirst();
        }
        return sum / (queue.size() * 1.0);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Design346_MovingAverage obj = new Design346_MovingAverage(3);

        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}