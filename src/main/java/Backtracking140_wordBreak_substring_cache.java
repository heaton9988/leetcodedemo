import java.util.*;

public class Backtracking140_wordBreak_substring_cache {
    HashSet<String> set;
    String s;
    int len;
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        len = s.length();
        set = new HashSet<>(wordDict);
        return wordBreak(0);
    }

    private List<String> wordBreak(int start) {
        if (map.containsKey(start)) return map.get(start);
        if (start == len) {
            return null;
        }
        LinkedList<String> ret = new LinkedList<>();
        for (int end = start + 1; end <= len; end++) {
            String sub = s.substring(start, end);
            if (set.contains(sub)) {
                List<String> nextWords = wordBreak(end);
                if (nextWords != null) {
                    for (String nextWord : nextWords) {
                        ret.add(sub + " " + nextWord);
                    }
                } else {
                    ret.add(sub);
                }
            }
        }
        map.put(start, ret);
        return ret;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking140_wordBreak_substring_cache().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        Object o = new Backtracking140_wordBreak_substring_cache().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                , Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}