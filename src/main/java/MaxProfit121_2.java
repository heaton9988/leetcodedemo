public class MaxProfit121_2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int chazhi = prices[1] - min;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < min)
                min = prices[i - 1];
            int chazhi2 = prices[i] - min;
            if (chazhi2 > chazhi)
                chazhi = chazhi2;
        }
        return chazhi;
    }

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        MaxProfit121_2 obj = new MaxProfit121_2();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxProfit(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}