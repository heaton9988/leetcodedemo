import util.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Trie212_findWords {
    Trie root = new Trie();
    HashSet<String> res = new HashSet<>();
    char[][] board;
    int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) addWord(word);
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(root, i, j, new boolean[rows][cols]);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(Trie curr, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j]) return;
        char c = board[i][j];
        int digit = c - 'a';

        visited[i][j] = true;
        curr = curr.child[digit];
        if (curr != null) {
            if (curr.word != null) res.add(curr.word);
            dfs(curr, i - 1, j, visited);
            dfs(curr, i + 1, j, visited);
            dfs(curr, i, j - 1, visited);
            dfs(curr, i, j + 1, visited);
        }
        visited[i][j] = false;
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
        curr.word = word;
    }

    static class Trie {
        Trie[] child = new Trie[26];
        String word;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Trie212_findWords obj = new Trie212_findWords();

        System.out.println(obj.findWords(Util.str2charMatrix("oaan,etae,ihkr,iflv"), new String[]{"oath", "pea", "eat", "rain"}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}