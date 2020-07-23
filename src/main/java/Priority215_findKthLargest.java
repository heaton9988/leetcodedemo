import java.util.PriorityQueue;

public class Priority215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) throws Exception {
        Priority215_findKthLargest obj = new Priority215_findKthLargest();
        long start = System.currentTimeMillis();
        Object o = obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}