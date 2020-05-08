public class MaxProfit122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int res = 0;
        int left = prices[0];
        for (int i = 0; i < n; i++) {
            if (i + 1 < prices.length) {
                if (prices[i + 1] < prices[i] && left < prices[i]) {
                    res += prices[i] - left;
                    left = prices[i + 1];
                    i++;
                } else if (prices[i] < prices[i - 1]) {
                    left = prices[i];
                }
            } else if (i == prices.length - 1) {
                if (prices[i] > left) {
                    res += prices[i] - left;
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfit122 obj = new MaxProfit122();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxProfit(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}