public class String032_longestValidParentheses_dp {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int index = i - dp[i - 1];
                    if (index > 0 && s.charAt(index - 1) == '(') {
                        dp[i] = dp[i - 1] + (index >= 2 ? dp[index - 2] : 0) + 2;
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String032_longestValidParentheses_dp().longestValidParentheses("(()()");
        Object o = new String032_longestValidParentheses_dp().longestValidParentheses("())(())");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}