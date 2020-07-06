public class DP044_isMatch_dp {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (pLen == 0) return sLen == 0;

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 0; j < pLen; j++) {
            if (p.charAt(j) != '*') break;
            dp[0][j + 1] = true;
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                char schar = s.charAt(i);
                char pchar = p.charAt(j);
                if (pchar == '*') {
                    for (int x = 0; x + i < sLen; x++) { // 如果是* ,那么i之后的都是true
                        dp[i + 1 + x][j + 1] |= dp[i][j]; // if(dp[i][j]是false可以break, 后续优化
                        if (!dp[i + 1 + x][j + 1]) break;
                    }
                    dp[i + 1][j + 1] |= dp[i][j] | dp[i + 1][j];
                } else if (schar == pchar || pchar == '?') {
                    dp[i + 1][j + 1] |= dp[i][j];
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(new DP044_isMatch_dp().isMatch("a", "a*")); // true
        System.out.println(new DP044_isMatch_dp().isMatch("a", "*a")); // true
        System.out.println(new DP044_isMatch_dp().isMatch("aa", "a")); // false
        System.out.println(new DP044_isMatch_dp().isMatch("aa", "*")); // true
        System.out.println(new DP044_isMatch_dp().isMatch("cb", "?a")); // false
        System.out.println(new DP044_isMatch_dp().isMatch("adceb", "*a*b")); // true
        System.out.println(new DP044_isMatch_dp().isMatch("acdcb", "a*c?b")); // false
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}