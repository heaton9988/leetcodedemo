import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Priority347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, Integer> num2count = new HashMap<>();
        for (int num : nums) {
            Integer count = num2count.get(num);
            if (count == null) {
                num2count.put(num, 1);
            } else {
                num2count.put(num, 1 + count);
            }
        }
        for (Map.Entry<Integer, Integer> entry : num2count.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Priority347_topKFrequent obj = new Priority347_topKFrequent();
        long start = System.currentTimeMillis();
//        Object o = obj.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Object o = obj.topKFrequent(new int[]{3, 0, 1, 0}, 1);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}