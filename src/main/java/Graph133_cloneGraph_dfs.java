import java.util.*;

public class Graph133_cloneGraph_dfs {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        Node newNode = map.get(node);
        if (newNode != null) {
            return newNode;
        }
        newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node neighbour : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbour));
        }
        return newNode;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Graph133_cloneGraph_dfs obj = new Graph133_cloneGraph_dfs();
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