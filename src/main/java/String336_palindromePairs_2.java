import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String336_palindromePairs_2 {
    public static void main(String[] args) {
//        Object o = new String336_palindromePairs_2().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
        Object o = new String336_palindromePairs_2().palindromePairs(new String[]{"aab", "b"});
        System.out.println(o);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        //构建trie
        TrieNode root = buildTire(words);
        List<List<Integer>> res = new ArrayList();
        //对于每个单词,在trie中搜索
        for (int i = 0; i < words.length; i++) {
            search(words[i], i, root, res);
        }
        return res;
    }

    private void search(String word, int i, TrieNode node, List<List<Integer>> res) {
        int k = word.length();
        for (int j = 0; j < k; j++) {
            //循环中在trie中发现的单词是比当前word长度要短的
            char c = word.charAt(j);
            if (node.index != -1 && isPalidrome(word, j, k - 1)) {
                res.add(Arrays.asList(i, node.index));
            }
            TrieNode child = node.children[c - 'a'];
            if (child == null) { // 所有可能被排除，提前退出
                return;
            }
            node = child;
        }
        if (node.index != -1 && node.index != i) { // 长度等于当前搜索的word的单词
            res.add(Arrays.asList(i, node.index));
        }
        // 长度长于当前搜索的word的单词
        for (int rest : node.belowIsPali) {
            res.add(Arrays.asList(i, rest));
        }
    }

    private TrieNode buildTire(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        return root;
    }

    private void addWord(TrieNode root, String word, int i) {
        for (int j = word.length() - 1; j >= 0; j--) {
            if (isPalidrome(word, 0, j)) {
                root.belowIsPali.add(i);
            }
            char c = word.charAt(j);
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
        }
        root.index = i;
    }

    private boolean isPalidrome(String word, int i, int j) {
        if (word.length() <= 1) {
            return true;
        }
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }

    class TrieNode {
        int index;
        List<Integer> belowIsPali;
        TrieNode[] children;

        public TrieNode() {
            index = -1;
            belowIsPali = new ArrayList<Integer>();
            children = new TrieNode[26];
        }
    }
}