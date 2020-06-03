public class String132_minCut_2 {
    public int minCut(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n <= 1) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int r = 1; r < n; r++) {
            if (isPali(s, 0, r)) dp[r] = 0;
            else {
                dp[r] = r;
                int l = r;
                while (l >= 1) {
                    if (isPali(s, l, r)) {
                        dp[r] = Math.min(dp[r], dp[l - 1] + 1);
                    }
                    l--;
                }
            }
        }
        return dp[n - 1];
    }

    private boolean isPali(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Object o = new String132_minCut_2().minCut("cdd");
//        Object o = new String131_partition().partition("aab");
        System.out.println(o);
    }
}