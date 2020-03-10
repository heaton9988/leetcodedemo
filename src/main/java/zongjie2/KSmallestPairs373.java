package zongjie2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) return res;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < k && i < nums1.length; i++) {
            queue.add(new int[]{nums1[i], nums2[0], 0});
        }

        while (!queue.isEmpty() && res.size() < k) {
            int[] curr = queue.poll();
            List<Integer> one = new ArrayList<>(2);
            one.add(curr[0]);
            one.add(curr[1]);
            res.add(one);
            if (curr[2] == nums2.length - 1) {
                continue;
            }
            queue.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }

        return res;
    }

    public static void main(String[] args) {
        Object o = new KSmallestPairs373().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 44);
        System.out.println(o);
    }
}