public class String392_isSubsequence_followUp {
    public boolean isSubsequence(String s, String t) {
        // 预处理
        long t1 = System.currentTimeMillis();
        t = " " + t; // 开头加一个空字符作为匹配入口
        int n = t.length();
        int[][] dp = new int[n][26]; // 记录每个位置的下一个ch的位置
        for (char ch = 'a'; ch < 'z'; ch++) {
            int p = -1;
            for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
                dp[i][ch - 'a'] = p;
                char c = t.charAt(i);
                if (c == ch) {
                    p = i;
                }
            }
        }
        System.out.println("process " + (System.currentTimeMillis() - t1));
        // 匹配
        int i = 0;
        for (char ch : s.toCharArray()) { // 跳跃遍历
            i = dp[i][ch - 'a'];
            if (i == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String392_isSubsequence_followUp().isSubsequence("axc", "abab");
//        Object o = new String392_isSubsequence_followUp().isSubsequence("abc", "ahbgdc");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}