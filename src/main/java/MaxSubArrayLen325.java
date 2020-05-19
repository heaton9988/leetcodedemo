import java.util.HashMap;

public class MaxSubArrayLen325 {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> sum2index = new HashMap<>();
        sum2index.put(0,-1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!sum2index.containsKey(sum)) {
                sum2index.put(sum, i);
            }
            if (sum2index.containsKey(sum - k)) {
                res = Math.max(res, i - sum2index.get(sum - k));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MaxSubArrayLen325 obj = new MaxSubArrayLen325();
        System.out.println(obj.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}