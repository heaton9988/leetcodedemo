public class DP312_maxCoins_dp_top2bottom {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];
        for (int i = 0; i < nums.length; i++) new_nums[i + 1] = nums[i];
        new_nums[0] = new_nums[n - 1] = 1;

        int[][] cache = new int[n][n];

        // find the maximum number of coins obtained from adding all balloons from (0, len(nums) - 1)
        return dp(cache, new_nums, 0, n - 1);
    }

    public int dp(int[][] cache, int[] nums, int left, int right) {
        // no more balloons can be added
        if (left + 1 == right) {
            return 0;
        }
        // we've already seen this, return from cache
        if (cache[left][right] > 0) {
            return cache[left][right];
        }
        // add each balloon on the interval and return the maximum score
        int ans = 0;
        for (int i = left + 1; i < right; ++i) {
            int dpLeft = dp(cache, nums, left, i);
            int dpRight = dp(cache, nums, i, right);
            int temp = nums[left] * nums[i] * nums[right] + dpLeft + dpRight;
            ans = Math.max(ans, temp);
        }
        // add to the cache
        cache[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP312_maxCoins_dp_top2bottom().maxCoins(new int[]{9, 76, 64});
//        Object o = new DP312_maxCoins().maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}