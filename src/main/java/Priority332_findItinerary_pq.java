import java.util.*;

public class Priority332_findItinerary_pq {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }
        visit(graph, "JFK", ans);
        return ans;
    }

    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        PriorityQueue<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.poll();
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }

    public static void main(String[] args) {
        Priority332_findItinerary_pq obj = new Priority332_findItinerary_pq();
        long start = System.currentTimeMillis();
        List<List<String>> param = Arrays.asList(
                Arrays.asList("JFK", "SFO")
                , Arrays.asList("JFK", "ATL")
                , Arrays.asList("SFO", "ATL")
                , Arrays.asList("ATL", "JFK")
                , Arrays.asList("ATL", "SFO")
        );
//        param = Arrays.asList(
//                Arrays.asList("MUC", "LHR")
//                , Arrays.asList("JFK", "MUC")
//                , Arrays.asList("SFO", "SJC")
//                , Arrays.asList("LHR", "SFO")
//        );
//        param = Arrays.asList(
//                Arrays.asList("EZE", "AXA")
//                , Arrays.asList("TIA", "ANU")
//                , Arrays.asList("ANU", "JFK")
//                , Arrays.asList("JFK", "ANU")
//                , Arrays.asList("ANU", "EZE")
//                , Arrays.asList("TIA", "ANU")
//                , Arrays.asList("AXA", "TIA")
//                , Arrays.asList("TIA", "JFK")
//                , Arrays.asList("ANU", "TIA")
//                , Arrays.asList("JFK", "TIA")
//        );
        Object o = obj.findItinerary(param);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}