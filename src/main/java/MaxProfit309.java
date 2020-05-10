public class MaxProfit309 {
    public int maxProfit(int[] prices) {
        int T_i0 = 0;
        int T_i1 = Integer.MIN_VALUE;

        int lastLastTi0 = 0;
        for (int i = 0; i < prices.length; i++) {
            int lastTi0 = T_i0;

            T_i0 = Math.max(T_i0, T_i1 + prices[i]);
            T_i1 = Math.max(T_i1, lastLastTi0 - prices[i]);

            lastLastTi0 = lastTi0;
        }

        return T_i0;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        MaxProfit309 obj = new MaxProfit309();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxProfit(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}