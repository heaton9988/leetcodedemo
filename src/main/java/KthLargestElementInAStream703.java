import java.util.PriorityQueue;

public class KthLargestElementInAStream703 {
    private final PriorityQueue<Integer> heap;
    private final int k;

    public KthLargestElementInAStream703(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.add(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        //You may assume that nums' length ≥ k-1 and k ≥ 1.
        KthLargestElementInAStream703 obj = new KthLargestElementInAStream703(3, new int[]{4, 5, 8, 2});
        long start = System.currentTimeMillis();
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}