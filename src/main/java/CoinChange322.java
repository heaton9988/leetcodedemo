import java.util.Arrays;

public class CoinChange322 {
    int minCount = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        useNext(0, amount, coins, coins.length - 1);//递归调用，从尾向首递归调用，尽量使用大额硬币
        if (minCount == Integer.MAX_VALUE) return -1;
        else return minCount;
    }

    //i是已经用了多少个硬币，amount是剩下金额，coins是硬币集合，n是第几种硬币
    private void useNext(int i, int amount, int[] coins, int n) {
        if (amount == 0) { //找到一种组合
            if (i < minCount) minCount = i;
            return;//结束
        }
        if (n == -1 || amount / coins[n] + i >= minCount) return;//尝试失败，压根就不用进行后面的循环
        for (int j = amount / coins[n]; j >= 0; j--) {//尽可能多的使用大硬币，
            useNext(i + j, amount - coins[n] * j, coins, n - 1);
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{2, 5, 1};
        int target = 11;
        CoinChange322 obj = new CoinChange322();
        long start = System.currentTimeMillis();

        System.out.println(obj.coinChange(prices, target));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}