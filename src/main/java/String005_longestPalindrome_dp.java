public class String005_longestPalindrome_dp {
    int start = 0, end = 0;

    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n == 0) return "";
        if (n == 1) return s;

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                boolean eq = cs[i] == cs[j];
                if (eq) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Object o = new String005_longestPalindrome_dp().longestPalindrome("babad");
        System.out.println(o);
    }
}