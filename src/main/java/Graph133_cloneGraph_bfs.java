import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph133_cloneGraph_bfs {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        visited.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node curr = queue.pollFirst();

            for (Node neighbour : curr.neighbors) {
                if (!visited.containsKey(neighbour)) {
                    visited.put(neighbour, new Node(neighbour.val));
                    queue.addLast(neighbour);
                }
                visited.get(curr).neighbors.add(visited.get(neighbour));
            }
        }
        return visited.get(node);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Graph133_cloneGraph_bfs obj = new Graph133_cloneGraph_bfs();
        obj.cloneGraph(null);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}