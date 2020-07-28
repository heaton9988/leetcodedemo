import java.util.*;

public class TopologicalSort269_alienOrder_2 {
    public String alienOrder(String[] words) {
        // -------------------------------------------------mmp 这题的题目意思我看了半天 初始化
        //  同一个 String 中 “abc” 这三个之间是没有相互顺序的 我的奶奶个腿的
        // 谁出的题出来挨打
        HashMap<Character, Set<Character>> graph = new HashMap();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            // 这里改成这样就是为了防止 abc
            int len = Math.max(words[i].length(), words[i + 1].length());

            for (int j = 0; j < len; j++) {
                // 这里是个坑 要防止 abc -> ab 这种情况
                if (j >= words[i].length()) break;
                if (j >= words[i + 1].length()) return "";

                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                }
                Set<Character> set = graph.computeIfAbsent(words[i].charAt(j), k -> new HashSet<>());
                set.add(words[i + 1].charAt(j));
                graph.put(words[i].charAt(j), set);
                break;
            }
        }

        // --------------------------------------------------这一下是拓扑排序----------------------------

        LinkedList<Character> queue = new LinkedList();
        // 入度初始化
        int[] inDegree = new int[26];

        int numChar = 0;
        Arrays.fill(inDegree, -1);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree[c - 'a'] = 0;
            }
        }
        // 入度为0的先学习 想成一个课程表
        //
        for (Character key : graph.keySet()) {
            for (Character value : graph.get(key)) {
                inDegree[value - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                queue.add((char) (i + 'a'));
            }
            if (inDegree[i] != -1) {
                numChar++;
            }
        }

        while (!queue.isEmpty()) {
            Character firstChar = queue.poll();
            res.append(firstChar);
            if (graph.containsKey(firstChar)) {
                for (Character nextChar : graph.get(firstChar)) {
                    inDegree[nextChar - 'a']--;
                    if (inDegree[nextChar - 'a'] == 0) {
                        queue.add(nextChar);
                    }
                }
            }
        }
        if (res.length() != numChar) {
            return "";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TopologicalSort269_alienOrder_2 obj = new TopologicalSort269_alienOrder_2();
//        System.out.println(obj.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
//        System.out.println(obj.alienOrder(new String[]{"z", "x","z"}));
//        System.out.println(obj.alienOrder(new String[]{"z", "z"}));
//        System.out.println(obj.alienOrder(new String[]{"zy", "zx"}));
        System.out.println(obj.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}