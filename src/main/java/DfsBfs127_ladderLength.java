import java.util.*;

public class DfsBfs127_ladderLength {
    Map<String, List<String>> pattern2strs = new HashMap<>();
    String endWord;
    HashSet<String> visited = new HashSet<>();
    int res = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
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
        dfs(beginWord, 1);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private void dfs(String curr, int count) {
        if (curr.equals(endWord)) {
            if (count < res) res = count;
        } else {
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
            for (String nextWord : nextWords) {
                if (visited.contains(nextWord)) continue;
                visited.add(nextWord);
                dfs(nextWord, count + 1);
                visited.remove(nextWord);
            }
        }
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
//        int i = new DfsBfs127_ladderLength().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int i = new DfsBfs127_ladderLength().ladderLength("hot", "dog", Arrays.asList("hot", "dog", "dot"));
        System.out.println(i);
    }
}