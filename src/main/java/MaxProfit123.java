public class MaxProfit123 {
    public int maxProfit(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
        int T_i20 = 0, T_i21 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            T_i20 = Math.max(T_i20, T_i21 + price);
            T_i21 = Math.max(T_i21, T_i10 - price);
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }

        return T_i20;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        MaxProfit123 obj = new MaxProfit123();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxProfit(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}