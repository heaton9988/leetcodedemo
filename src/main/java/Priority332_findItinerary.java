import java.util.*;

public class Priority332_findItinerary {
    static class Node implements Comparable {
        String end;
        int index;

        Node(String end, int index) {
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            Node other = (Node) o;
            int compare1 = this.end.compareTo(other.end);
            if (compare1 == 0) {
                return this.index - other.index;
            }
            return compare1;
        }
    }

    boolean[] visited;
    HashMap<String, TreeSet<Node>> start2ends = new HashMap<>();
    List<String> res;
    boolean found = false;
    int len;

    public List<String> findItinerary(List<List<String>> tickets) {
        len = tickets.size();
        visited = new boolean[len];
        for (int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            TreeSet<Node> set = start2ends.get(ticket.get(0));
            if (set == null) {
                set = new TreeSet<>();
                start2ends.put(ticket.get(0), set);
            }
            set.add(new Node(ticket.get(1), i));
        }
        dfs("JFK", new ArrayList<>());
        return res;
    }

    private void dfs(String ticket0, List<String> list) {
        if (found) return;
        list.add(ticket0);
        if (len + 1 == list.size()) {
            res = new ArrayList<>(list);
            found = true;
            return;
        }

        TreeSet<Node> nodes = start2ends.get(ticket0);
        if (nodes != null) {
            for (Node n : nodes) {
                if (found || visited[n.index]) {
                    continue;
                }
                visited[n.index] = true;
                dfs(n.end, list);
                visited[n.index] = false;
            }
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Priority332_findItinerary obj = new Priority332_findItinerary();
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
        param = Arrays.asList(
                Arrays.asList("EZE", "AXA")
                , Arrays.asList("TIA", "ANU")
                , Arrays.asList("ANU", "JFK")
                , Arrays.asList("JFK", "ANU")
                , Arrays.asList("ANU", "EZE")
                , Arrays.asList("TIA", "ANU")
                , Arrays.asList("AXA", "TIA")
                , Arrays.asList("TIA", "JFK")
                , Arrays.asList("ANU", "TIA")
                , Arrays.asList("JFK", "TIA")
        );
        Object o = obj.findItinerary(param);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}