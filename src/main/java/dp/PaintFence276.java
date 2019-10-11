package dp;

public class PaintFence276 {
    public int numWays(int nPosts, int kColors) {
        if (nPosts <= 0 || kColors <= 0) return 0;
        if (nPosts == 1) return kColors;
        if (nPosts == 2) return kColors * kColors;
        int[] dp = new int[nPosts + 1];
        dp[1] = kColors;
        dp[2] = kColors * kColors;

        for (int i = 3; i <= nPosts; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (kColors - 1);
            if (dp[i] == 0) return 0;
        }

        return dp[nPosts];
    }

    public static void main(String[] args) {
        PaintFence276 obj = new PaintFence276();
        long start = System.currentTimeMillis();

//        for (int i = 0; i < 10; i++) {
//            for (int j = 1; j < 3; j++) {
        int result = obj.numWays(4, 3);
//                System.out.println("npost=" + i + ",colors=" + j + " result=" + result);
//            }
//        }
        System.out.println("cost " + (System.currentTimeMillis() - start));
    }
}