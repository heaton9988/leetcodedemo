import java.util.PriorityQueue;

public class KthLargestElementInAnArray215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            if (q.size() < k) {
                q.add(num);
            } else if (q.peek() < num) {
                q.poll();
                q.add(num);
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        //You may assume that nums' length ≥ k-1 and k ≥ 1.
        KthLargestElementInAnArray215 obj = new KthLargestElementInAnArray215();
        long start = System.currentTimeMillis();
        System.out.println(obj.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}