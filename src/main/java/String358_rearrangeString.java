import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class String358_rearrangeString {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> count[o2] - count[o1]);
        StringBuilder res = new StringBuilder();
        Queue<Integer> intervalList = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) pq.add(i);
        }
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            intervalList.add(curr);
            count[curr]--;
            res.append((char) ('a' + curr));
            if (intervalList.size() >= k) {
                int mem = intervalList.poll();
                if (count[mem] > 0) {
                    pq.offer(mem);
                }
            }
        }
        return res.length() == s.length() ? res.toString() : "";
    }

    public static void main(String[] args) throws Exception {
        String358_rearrangeString obj = new String358_rearrangeString();
        long start = System.currentTimeMillis();
        Object o = obj.rearrangeString("aabbcc", 3);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}