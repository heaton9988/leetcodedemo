import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums373_2 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));
        List<List<Integer>> result = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0) return result;
        for (int i = 0; i < n1; i++) pq.offer(new int[]{i, 0});

        while (pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] + 1 < n2) pq.offer(new int[]{pair[0], pair[1] + 1});
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        //You may assume that nums' length ≥ k-1 and k ≥ 1.
        FindKPairsWithSmallestSums373_2 obj = new FindKPairsWithSmallestSums373_2();
        long start = System.currentTimeMillis();
        System.out.println(obj.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}