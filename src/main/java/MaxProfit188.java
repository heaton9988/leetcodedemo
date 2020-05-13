import java.util.Arrays;

public class MaxProfit188 {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
            int i0 = 0;
            int i1 = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                i0 = Math.max(i0, i1 + prices[i]);
                i1 = Math.max(i1, i0 - prices[i]);
            }
            return i0;
        }
        int[] i0 = new int[k + 1];
        int[] i1 = new int[k + 1];
        Arrays.fill(i1, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                i0[j] = Math.max(i0[j], i1[j] + prices[i]);
                i1[j] = Math.max(i1[j], i0[j - 1] - prices[i]);
            }
        }
        return i0[k];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        MaxProfit188 obj = new MaxProfit188();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxProfit(3, prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}