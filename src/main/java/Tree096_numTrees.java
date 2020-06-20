public class Tree096_numTrees {
    public int numTrees(int n) {
        if (n <= 2) return n;
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Object o = new Tree096_numTrees().numTrees(4);
        System.out.println(o);
    }
}