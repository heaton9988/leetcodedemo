public class MaxProfit121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (i >= 1) {
                int profit = prices[i] - minValue;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfit121 obj = new MaxProfit121();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxProfit(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}