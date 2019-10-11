import java.util.PriorityQueue;

/**
 * A Star/ A* 算法
 */
public class MedianFinder {
    PriorityQueue<Integer> smalls = new PriorityQueue<>();
    PriorityQueue<Integer> bigs = new PriorityQueue<>();
    int size = 0;

    public MedianFinder() {
        smalls = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        bigs = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }

    public void addNum(int num) {
        size++;
        Integer biggestInSmalls = smalls.peek();
        Integer smallestInBigs = bigs.peek();
        if (biggestInSmalls == null && smallestInBigs == null) {
            smalls.add(num);
        } else if (biggestInSmalls != null) {
            if (num <= biggestInSmalls) {
                smalls.add(num);
            } else {
                bigs.add(num);
            }
        } else if (smallestInBigs != null) {
            if (num >= smallestInBigs) {
                bigs.add(num);
            } else {
                smalls.add(num);
            }
        }
    }

    public double findMedian() {
        while (true) {
            int diff = smalls.size() - bigs.size();
            if (Math.abs(diff) <= 1) {
                break;
            }
            if (diff > 0) {
                bigs.add(smalls.poll());
            } else {
                smalls.add(bigs.poll());
            }
        }
        if (size > 0) {
            if (size % 2 == 0) {
                return (bigs.peek() + smalls.peek()) * 0.5;
            } else {
                if (bigs.size() > smalls.size()) {
                    return bigs.peek();
                } else {
                    return smalls.peek();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */