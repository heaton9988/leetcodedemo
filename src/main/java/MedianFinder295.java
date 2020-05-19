import java.util.PriorityQueue;

public class MedianFinder295 {
    PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> a - b);
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    int count = 0;

    public MedianFinder295() {
    }

    public void addNum(int num) {
        count++;
        max.offer(num);
        min.offer(max.poll());
        if (count % 2 == 1) {
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if (count == 0) return 0;
        int mvalue = max.peek();
        if (count % 2 == 0) {
            return (min.peek() + mvalue) / 2.0;
        } else return mvalue;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MedianFinder295 obj = new MedianFinder295();
        obj.addNum(2);
        obj.addNum(1);
        System.out.println(obj.findMedian());
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}