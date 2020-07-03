public class DP322_coinChange {
    int[] dp;
    int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        dp = new int[amount + 1];
        return helper(amount);
    }

    private int helper(int target) {
        if (target < 0) return -1;
        if (target == 0) return 0;
        if (dp[target] != 0) return dp[target];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(target - coin);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        dp[target] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[target];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new DP322_coinChange().coinChange(new int[]{2}, 3);
        Object o = new DP322_coinChange().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}