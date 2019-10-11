import java.util.Arrays;

public class CoinChange322_2 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{2, 5, 1};
        int target = 11;
        CoinChange322_2 obj = new CoinChange322_2();
        long start = System.currentTimeMillis();

        System.out.println(obj.coinChange(prices, target));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}