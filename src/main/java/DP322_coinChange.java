import java.util.HashSet;

public class DP322_coinChange {
    HashSet<Integer> set = new HashSet<>();
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        for (int coin : coins) set.add(coin);
        dp = new int[amount + 1];
        for (int target = 1; target <= amount; target++) {
            helper(target);
        }
        return dp[amount];
    }

    private int helper(int target) {
        if (dp[target] != 0) return dp[target];
        if (set.contains(target)) {
            dp[target] = 1;
            return dp[target];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : set) {
            if (target > coin) {
                int res = helper(target - coin);
                if (res > 0) {
                    min = Math.min(min, 1 + res);
                }
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