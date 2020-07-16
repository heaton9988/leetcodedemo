import java.util.*;

public class DfsBfs127_ladderLength_bfs {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> pattern2strs = new HashMap<>();
        HashSet<String> visitedLeft = new HashSet<>();
        HashSet<String> visitedRight = new HashSet<>();
        int res = Integer.MAX_VALUE;

        boolean hasEndWord = false;
        for (String s : wordList) {
            if (s.equals(endWord)) hasEndWord = true;
            for (String pattern : getPatterns(s)) {
                List<String> list = pattern2strs.get(pattern);
                if (list == null) {
                    list = new ArrayList<>();
                    pattern2strs.put(pattern, list);
                }
                list.add(s);
            }
        }
        if (!hasEndWord) return 0;

        LinkedList<String> leftQ = new LinkedList<>();
        leftQ.add(beginWord);
        visitedLeft.add(beginWord);
        LinkedList<String> rightQ = new LinkedList<>();
        rightQ.add(endWord);
        visitedRight.add(endWord);
        int countLeft = 0;
        int countRight = 0;
        while (!leftQ.isEmpty() || !rightQ.isEmpty()) {
            int sizeLeft = leftQ.size();
            if (sizeLeft > 0) countLeft++;
            for (int i = 0; i < sizeLeft; i++) {
                String curr = leftQ.poll();
                HashSet<String> tempSet = new HashSet<>();
                for (String pattern : getPatterns(curr)) {
                    List<String> list = pattern2strs.get(pattern);
                    if (list != null) for (String s : list) tempSet.add(s);
                }
                for (String s : tempSet) {
                    if (visitedRight.contains(s)) {
                        return countLeft + countRight + 1;
                    }
                    if (!visitedLeft.contains(s)) {
                        leftQ.add(s);
                        visitedLeft.add(s);
                    }
                }
            }

            int sizeRight = rightQ.size();
            if (sizeRight > 0) countRight++;
            for (int i = 0; i < sizeRight; i++) {
                String curr = rightQ.poll();
                HashSet<String> tempSet = new HashSet<>();
                for (String pattern : getPatterns(curr)) {
                    List<String> list = pattern2strs.get(pattern);
                    if (list != null) for (String s : list) tempSet.add(s);
                }
                for (String s : tempSet) {
                    if (visitedLeft.contains(s)) {
                        return countLeft + countRight + 1;
                    }
                    if (!visitedRight.contains(s)) {
                        rightQ.add(s);
                        visitedRight.add(s);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
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
        int i = new DfsBfs127_ladderLength_bfs().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
//        int i = new DfsBfs127_ladderLength_bfs().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        int i = new DfsBfs127_ladderLength_bfs().ladderLength("hot", "dog", Arrays.asList("hot", "dog", "dot"));
        System.out.println(i);
    }
}