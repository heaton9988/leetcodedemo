import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Backtracking140_wordBreak_substring_cache {
    HashSet<String> set;
    String s;
    List<String> res = new ArrayList<>();
    int len;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        len = s.length();
        set = new HashSet<>(wordDict);
        helper(0, new ArrayList<>());
        return res;
    }

    private void helper(int start, List<String> list) {
        if (start == len) {
            res.add(String.join(" ", list));
            return;
        }
        for (int i = start + 1; i <= len; i++) {
            String sub = s.substring(start, i);
            if (set.contains(sub)) {
                list.add(sub);
                helper(i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking140_wordBreak_substring_cache().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        Object o = new Backtracking140_wordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                , Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}