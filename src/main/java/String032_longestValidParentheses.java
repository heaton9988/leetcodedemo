public class String032_longestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int dp[] = new int[n];
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (cs[i] == ')') {
                if (cs[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (cs[i - 1] == ')') {
                    int index = i - dp[i - 1];
                    if (index > 0 && cs[index - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[index - 2];
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String032_longestValidParentheses().longestValidParentheses(")()(())");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}