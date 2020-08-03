public class Trie208_Trie {
    Trie2 root = new Trie2();

    public Trie208_Trie() {
    }

    public void insert(String word) {
        Trie2 curr = root;
        for (char c : word.toCharArray()) {
            int digit = c - 'a';
            if (curr.child[digit] == null) {
                curr.child[digit] = new Trie2();
            }
            curr = curr.child[digit];
        }
        curr.word = true;
    }

    public boolean search(String word) {
        Trie2 curr = root;
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int digit = cs[i] - 'a';
            if (curr.child[digit] == null) {
                return false;
            }
            curr = curr.child[digit];
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        Trie2 curr = root;
        char[] cs = prefix.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int digit = cs[i] - 'a';
            if (curr.child[digit] == null) {
                return false;
            }
            curr = curr.child[digit];
        }
        return true;
    }

    static class Trie2 {
        Trie2[] child = new Trie2[26];
        boolean word;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Trie208_Trie trie = new Trie208_Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}
