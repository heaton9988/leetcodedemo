import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate220_bucket {
    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        if (x < 0) {
            return (x + 1) / w - 1;
        } else {
            return x / w;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (map.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (map.containsKey(m - 1) && Math.abs(nums[i] - map.get(m - 1)) < w) {
                return true;
            }
            if (map.containsKey(m + 1) && Math.abs(nums[i] - map.get(m + 1)) < w) {
                return true;
            }
            // now bucket m is empty and no almost duplicate in nei***or buckets
            map.put(m, (long) nums[i]);
            if (i >= k) map.remove(getID(nums[i - k], w));
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate220_bucket obj = new ContainsDuplicate220_bucket();
        long start = System.currentTimeMillis();

        Object v = obj.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}