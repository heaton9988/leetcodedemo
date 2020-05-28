import java.util.LinkedList;
import java.util.PriorityQueue;

public class String358_rearrangeString {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        char c[] = s.toCharArray();
        for (char ch : c) {
            count[ch - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count[b] - count[a]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add(i);
            }
        }
        StringBuilder res = new StringBuilder();
        LinkedList<Integer> list = new LinkedList();
        while (!pq.isEmpty()) {
            Integer top = pq.poll();
            res.append((char) ('a' + top));
            count[top]--;
            if (count[top] > 0) {
                list.addLast(top);
            }
            if (list.size() >= k) {
                pq.offer(list.pollFirst());
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