import java.util.HashMap;

public class ContainsDuplicate220_timeout {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer lastIndex = map.get(num);
            if (lastIndex != null) {
                min = Math.min(min, i - lastIndex);
            }
            for (int j = num - t; j <= num + t; j++) {
                map.put(j, i);
            }
        }
        return min <= k;
    }

    public static void main(String[] args) {
        ContainsDuplicate220_timeout obj = new ContainsDuplicate220_timeout();
        long start = System.currentTimeMillis();

        Object v = obj.containsNearbyAlmostDuplicate(new int[]{2, 1}, 1, 1);
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}