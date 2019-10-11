import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    static int count = 0;

    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            count++;
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                if (word_Break(s, wordDict, end, memo)) {
                    return memo[start] = true;
                }
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
//        String s = "catsandog";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        WordBreak139 obj = new WordBreak139();
        long start = System.currentTimeMillis();
        boolean result = obj.wordBreak(s, wordDict);
        System.out.println(result);
        System.out.println(count);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}