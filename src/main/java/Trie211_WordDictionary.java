public class Trie211_WordDictionary {
    Trie root;

    public Trie211_WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            int digit = c - 'a';
            if (curr.child[digit] == null) {
                curr.child[digit] = new Trie();
            }
            curr = curr.child[digit];
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return help(root, 0, word.toCharArray());
    }

    private boolean help(Trie curr, int index, char[] cs) {
        for (int i = index; i < cs.length; i++) {
            char c = cs[i];
            if (c == '.') {
                for (Trie child : curr.child) {
                    if (child != null) {
                        if (help(child, i + 1, cs)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int digit = c - 'a';
                if (curr.child[digit] == null) {
                    return false;
                }
                curr = curr.child[digit];
            }
        }
        return curr.word;
    }

    static class Trie {
        Trie[] child = new Trie[26];
        boolean word;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Trie211_WordDictionary obj = new Trie211_WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}
