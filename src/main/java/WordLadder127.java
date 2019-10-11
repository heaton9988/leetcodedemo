import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();

        HashMap<String, LinkedHashSet<String>> fuzzy2wordSet = new HashMap<>();
        for (String s : wordList) {
            for (int i = 0; i < L; i++) {
                String fuzzy = s.substring(0, i) + '*' + s.substring(i + 1, L);
                LinkedHashSet<String> wordSet = fuzzy2wordSet.get(fuzzy);
                if (wordSet == null) {
                    wordSet = new LinkedHashSet<>();
                    fuzzy2wordSet.put(fuzzy, wordSet);
                }
                wordSet.add(s);
            }
        }

        LinkedList<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{beginWord, new Integer(1)});

        HashMap<String, Boolean> word2visited = new HashMap<>();
        word2visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Object[] pair = queue.poll();
            String lastWord = (String) pair[0];
            Integer lastCount = (Integer) pair[1];

            for (int i = 0; i < L; i++) {
                String fuzzyWord = lastWord.substring(0, i) + '*' + lastWord.substring(i + 1, L);

                LinkedHashSet<String> wordSet = fuzzy2wordSet.get(fuzzyWord);
                if (wordSet != null && wordSet.size() > 0) {
                    for (String nextWord : wordSet) {
                        if (nextWord.equals(endWord)) {
                            return lastCount + 1;
                        }
                        if (!word2visited.containsKey(nextWord)) {
                            word2visited.put(nextWord, true);
                            queue.add(new Object[]{nextWord, new Integer(lastCount + 1)});
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";

        WordLadder127 obj = new WordLadder127();
        long start = System.currentTimeMillis();
        int result = obj.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}