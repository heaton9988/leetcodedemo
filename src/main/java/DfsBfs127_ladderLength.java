import java.util.*;

public class DfsBfs127_ladderLength {
    Map<String, List<String>> pattern2strs = new HashMap<>();
    String endWord;
    HashSet<String> visited = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        this.endWord = endWord;
        for (String s : wordList) {
            for (String pattern : getPatterns(s)) {
                List<String> list = pattern2strs.get(pattern);
                if (list == null) {
                    list = new ArrayList<>();
                    pattern2strs.put(pattern, list);
                }
                list.add(s);
            }
        }
        return dfs(beginWord);
    }

    private int dfs(String curr) {
        if (curr.equals(endWord)) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        List<String> nextWords = new ArrayList<>();
        for (String pattern : getPatterns(curr)) {
            List<String> list = pattern2strs.get(pattern);
            if (list != null) {
                for (String s : list) {
                    if (!s.equals(curr)) {
                        nextWords.add(s);
                    }
                }
            }
        }
        boolean hasNext = false;
        for (String nextWord : nextWords) {
            if (visited.contains(nextWord)) continue;
            hasNext = true;
            visited.add(nextWord);
            int dfsVal = dfs(nextWord);
            visited.remove(nextWord);
            if (dfsVal < min) min = dfsVal;
        }
        return hasNext ? min + 1 : 0;
    }

    private List<String> getPatterns(String s) {
        List<String> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char temp = cs[i];
            cs[i] = '*';
            res.add(new String(cs));
            cs[i] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new DfsBfs127_ladderLength().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }
}