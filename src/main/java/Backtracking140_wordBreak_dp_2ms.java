import java.util.*;

public class Backtracking140_wordBreak_dp_2ms {
    Set<String> dict = new HashSet<>();
    String s;
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        //corner case
        if (s == null || s.length() == 0) return res;
        for (String word : wordDict) {
            dict.add(word);
        }
        boolean[] mem = new boolean[s.length() + 1];
        Arrays.fill(mem, true);
        dfs(dict, mem, 0, new StringBuilder());
        return res;
    }

    private boolean dfs(Set<String> dict, boolean[] mem, int index, StringBuilder sb) {
        if (index == s.length()) {
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return true;
        }

        if (mem[index] == false) {
            return false;
        }

        int size = res.size();
        for (int i = index; i < s.length(); i++) {
            int len = sb.length();
            //pruning
            if (mem[i + 1] == false) {
                continue;
            }
            String newString = s.substring(index, i + 1);
            if (dict.contains(newString)) {
                sb.append(newString + " ");
                dfs(dict, mem, i + 1, sb);
                //setback
                sb.setLength(len);
            }
        }

        if (size == res.size()) {
            mem[index] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        Object o = new Backtracking140_wordBreak_dp_2ms().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        Object o = new Backtracking140_wordBreak_dp_2ms().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        Object o = new Backtracking140_wordBreak_dp_2ms().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                , Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}