public class Tree117_connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        if (root.left != null && root.right != null) root.left.next = root.right;

        Node a = root.right != null ? root.right : root.left;
        if (a != null) {
            Node node = root.next;
            while (node != null && node.left == null && node.right == null) {
                node = node.next;
            }
            if (node != null) {
                a.next = node.left != null ? node.left : node.right;
            }
        }
        connect(root.right);
        connect(root.left);
        return root;
    }


    public static void main(String[] args) {
        Object o = new Tree117_connect().connect(null);
        System.out.println(o);
    }
}