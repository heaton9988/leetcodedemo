import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        //You may assume that nums' length ≥ k-1 and k ≥ 1.
        TopKFrequentElements347 obj = new TopKFrequentElements347();
        long start = System.currentTimeMillis();
        System.out.println(obj.topKFrequent(new int[]{3, 3, 3, 2, 2, 1}, 2));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}