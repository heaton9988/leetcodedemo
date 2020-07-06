public class DP010_isMatch_dp {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 1; j < pLen; j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                char schar = s.charAt(i);
                char pchar = p.charAt(j);
                if (schar == pchar || pchar == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (pchar == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i][j + 1] || dp[i + 1][j];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(new DP010_isMatch_dp().isMatch("", "a*a*")); // true
        System.out.println(new DP010_isMatch_dp().isMatch("aa", "a*")); // true
//        System.out.println(new DP010_isMatch_dp().isMatch("aa", "a")); // false
//        System.out.println(new DP010_isMatch_dp().isMatch("ab", ".*")); // true
        System.out.println(new DP010_isMatch_dp().isMatch("aab", "c*a*b")); // true
//        System.out.println(new DP010_isMatch_dp().isMatch("mississippi", "mis*is*p*.")); // false
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}