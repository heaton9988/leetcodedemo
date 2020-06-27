import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking140_wordBreak {
    List<String> res = new ArrayList<>();
    Trie root = new Trie();
    char[] cs;

    static class Trie {
        String word;
        Trie[] child = new Trie[26];
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        cs = s.toCharArray();
        for (String word : wordDict) {
            Trie curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.child[index] == null) {
                    curr.child[index] = new Trie();
                }
                curr = curr.child[index];
            }
            curr.word = word;
        }
        dfs(0, root, new StringBuilder());
        return res;
    }

    private void dfs(int index, Trie curr, StringBuilder sb) {
        if (index == cs.length) {
            if (curr.word != null) {
                res.add(sb.toString());
            }
            return;
        }
        int digit = cs[index] - 'a';
        Trie next = curr.child[digit];
        if (next == null) {
            return;
        }
        sb.append(cs[index]);
        int sbLen = sb.length();
        if (next.word != null) {
            sb.append(' ');
            dfs(index + 1, root, sb);
            sb.setLength(sbLen);
        }
        dfs(index + 1, next, sb);
        sb.setLength(sbLen);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking140_wordBreak().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        Object o = new Backtracking140_wordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                , Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}