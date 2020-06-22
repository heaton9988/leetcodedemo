public class Backtracking377_combinationSum4_dp {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    if (i - num >= 0) {
                        dp[i] += dp[i - num];
                    }
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking377_combinationSum4_dp().combinationSum4(new int[]{1, 2, 3}, 35);
//        Object o = new Backtracking377_combinationSum4_dp().combinationSum4(new int[]{3, 33, 333}, 10000);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}