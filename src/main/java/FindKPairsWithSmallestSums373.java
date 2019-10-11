import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List ret = new ArrayList();
        if (nums1 == null | nums1.length == 0 || nums2 == null || nums2.length == 0) return ret;
        int len1 = nums1.length;
        int len2 = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] + b[1] - a[0] - a[1]));
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (queue.size() < k) {
                    queue.add(new int[]{nums1[i], nums2[j]});
                } else {
                    int[] peek = queue.peek();
                    if (peek[0] + peek[1] > nums1[i] + nums2[j]) {
                        queue.poll();
                        queue.add(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        List retReverse = new ArrayList();
        while (!queue.isEmpty()) {
            retReverse.add(queue.poll());
        }
        for (int i = retReverse.size() - 1; i >= 0; i--) {
            ret.add(retReverse.get(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        //You may assume that nums' length ≥ k-1 and k ≥ 1.
        FindKPairsWithSmallestSums373 obj = new FindKPairsWithSmallestSums373();
        long start = System.currentTimeMillis();
        System.out.println(obj.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}