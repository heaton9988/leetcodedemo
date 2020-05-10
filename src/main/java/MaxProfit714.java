public class MaxProfit714 {
    public int maxProfit(int[] prices, int fee) {
        int T_i0 = 0;
        int T_i1 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            T_i0 = Math.max(T_i0, T_i1 + prices[i]);
            T_i1 = Math.max(T_i1, T_i0 - prices[i] - fee);
        }

        return T_i0;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        MaxProfit714 obj = new MaxProfit714();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxProfit(prices, 2));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}