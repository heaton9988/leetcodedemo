import java.util.Arrays;
import java.util.List;

public class WordBreak139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, 0, wordDict, new Boolean[s.length()]);
    }

    public boolean word_Break(String s, int start, List<String> wordDict, Boolean[] result) {
        if (s.length() == start) {
            return true;
        }
        if (result[start] != null) {
            return result[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (wordDict.contains(substring)) {
                if (word_Break(s, end, wordDict, result)) {
                    return result[start] = true;
                }
            }
        }
        return result[start] = false;
    }


    public static void main(String[] args) {
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
//        String s = "catsandog";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        WordBreak139_2 obj = new WordBreak139_2();
        long start = System.currentTimeMillis();
        boolean result = obj.wordBreak(s, wordDict);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}