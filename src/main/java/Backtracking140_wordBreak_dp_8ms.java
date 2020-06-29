import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Backtracking140_wordBreak_dp_8ms {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] dp = new List[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);
        List<String> res = recursive(dp, 0, s, set);
        return res;
    }

    public List<String> recursive(List<String>[] dp, int start, String s, HashSet<String> wordDict) {
        if (dp[start] == null) {
            dp[start] = new ArrayList<>();
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[i + 1] != null && dp[i + 1].isEmpty()) {
                continue;
            }
            String curStr = s.substring(start, i + 1);
            if (wordDict.contains(curStr)) {
                if (i + 1 != s.length()) {
                    if (dp[i + 1] == null) {
                        dp[i + 1] = recursive(dp, i + 1, s, wordDict);
                    }
                    for (String temp : dp[i + 1]) {
                        dp[start].add(curStr + " " + temp);
                    }
                } else {
                    dp[start].add(curStr);
                }
            }
        }
        return dp[start];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking140_wordBreak_dp_8ms().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        Object o = new Backtracking140_wordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                , Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}