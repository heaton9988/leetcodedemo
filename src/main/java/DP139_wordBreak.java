import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DP139_wordBreak {
    int max = 0;
    HashSet<String> set = new HashSet<>();
    String s;
    int len;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.len = s.length();
        for (String str : wordDict) {
            if (str.length() > max) max = str.length();
            set.add(str);
        }
        boolean dp[] = new boolean[len];
        helper(0, dp);
        return dp[len - 1];
    }

    private void helper(int start, boolean[] dp) {
        if (start >= len) return;
        for (int end = start + 1; end <= len && end <= start + max; end++) {
            if (dp[end - 1]) continue;
            String sub = s.substring(start, end);
            if (set.contains(sub)) {
                dp[end - 1] = true;
                helper(end, dp);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP139_wordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
//        Object o = new DP139_wordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}