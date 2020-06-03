import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String336_palindromePairs {
    public static void main(String[] args) {
//        Object o = new String336_palindromePairs().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
//        Object o = new String336_palindromePairs().palindromePairs(new String[]{"ab", "ba"});
//        Object o = new String336_palindromePairs().palindromePairs(new String[]{"abc", "cbaz"});
        Object o = new String336_palindromePairs().palindromePairs(new String[]{"a", "abc", "aba", ""});
        System.out.println(o);
    }

    private void search(TriNode node, String word, int index) {
        char[] cs = word.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (node.index != -1 && isPalidrome(word, i, n - 1)) { // word比Tri长, word的剩余部分如果是回文, 则match
                res.add(Arrays.asList(index, node.index));
            }
            TriNode child = node.child[c - 'a'];
            if (child == null) {
                return;
            }
            node = child;
        }
        if (node.index != -1 && node.index != index) { // Tri存在和当前word长度相同, 顺序相反的词
            res.add(Arrays.asList(index, node.index));
        }
        for (Integer restIsPali : node.belowIsPali) { // Tri比word长, 并且剩余部分是回文的index存储在belowIsPali里
            res.add(Arrays.asList(index, restIsPali));
        }
    }

    private boolean isPalidrome(String word, int i, int j) {
        if (i == j) return true;
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }

    class TriNode {
        int index = -1;
        TriNode[] child = new TriNode[26];
        List<Integer> belowIsPali = new ArrayList<>();
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        TriNode root = buildTriNode(words);
        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i);
        }
        return res;
    }

    private TriNode buildTriNode(String[] words) {
        TriNode root = new TriNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        return root;
    }

    private void addWord(TriNode root, String w, int index) {
        for (int j = w.length() - 1; j >= 0; j--) {
            char c = w.charAt(j);
            if (isPalidrome(w, 0, j)) {
                root.belowIsPali.add(index);
            }
            if (root.child[c - 'a'] == null) {
                root.child[c - 'a'] = new TriNode();
            }
            root = root.child[c - 'a'];
        }
        root.index = index;
    }
}