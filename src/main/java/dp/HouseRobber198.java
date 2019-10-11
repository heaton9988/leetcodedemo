package dp;

public class HouseRobber198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[1], nums[0]);
        if (len == 3) return Math.max(nums[1], nums[0] + nums[2]);
        int dp[] = new int[len + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[1], nums[0]);
        dp[3] = Math.max(nums[1], nums[0] + nums[2]);

        for (int i = 4; i <= len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 3] + nums[i - 2]);
        }

        return dp[len];
    }

//    private int subRob(int[] nums, int start, int end) {
//        if (start == end) return nums[start];
//        if (end - start == 1) return Math.max(nums[start], nums[start + 1]);
//        if (end - start == 2) return Math.max(nums[start] + nums[start + 2], nums[start + 1]);
//        if (end - start >= 3) { // 有四个元素
//            return Math.max(subRob(nums, 0, end - 2) + nums[end], subRob(nums, 0, end - 3) + nums[end - 1]);
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        HouseRobber198 obj = new HouseRobber198();
        long start = System.currentTimeMillis();
        int result = obj.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println("cost " + (System.currentTimeMillis() - start));
        System.out.println(result);
    }
}