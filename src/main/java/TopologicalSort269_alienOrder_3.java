import java.util.*;

public class TopologicalSort269_alienOrder_3 {
    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            int len = Math.max(words[i].length(), words[i + 1].length());
            for (int j = 0; j < len; j++) {
                if (j >= words[i].length()) {
                    break;
                }
                if (j >= words[i + 1].length()) {
                    return "";
                }
                char prev = words[i].charAt(j);
                char next = words[i + 1].charAt(j);
                if (prev == next) continue;
                Set<Character> set = graph.computeIfAbsent(prev, k -> new HashSet<Character>());
                set.add(next);
                break;
            }
        }
        int[] indegrees = new int[26];
        Arrays.fill(indegrees, -1);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegrees[c - 'a'] = 0;
            }
        }
        for (Set<Character> set : graph.values()) {
            for (char c : set) {
                indegrees[c - 'a']++;
            }
        }
        LinkedList<Character> queue = new LinkedList<>();
        int numChars = 0;
        for (int i = 0; i < 26; i++) {
            if (indegrees[i] >= 0) {
                numChars++;
                if (indegrees[i] == 0) {
                    queue.addLast((char) (i + 'a'));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.pollFirst();
            res.append(curr);

            Set<Character> set = graph.get(curr);
            if (set == null) continue;
            for (char next : set) {
                if (--indegrees[next - 'a'] == 0) {
                    queue.addLast(next);
                }
            }
        }
        if (res.length() != numChars) return "";
        return res.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TopologicalSort269_alienOrder_3 obj = new TopologicalSort269_alienOrder_3();
        System.out.println(obj.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(obj.alienOrder(new String[]{"z", "x", "z"}));
        System.out.println(obj.alienOrder(new String[]{"z", "z"}));
        System.out.println(obj.alienOrder(new String[]{"zy", "zx"}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}